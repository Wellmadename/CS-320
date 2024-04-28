/*
 * Andrew Rapolevich SNHU CS-320
*/
package AppointmentServicesTests;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Assertions;
import AppointmentServices.Appointment;
import org.junit.jupiter.api.Test;
import java.util.Calendar;
import java.util.Date;

class AppointmentTest {
	
	@Test
	void testAppointment() {
		Date validDate = Date.from(Calendar.getInstance().toInstant().plusSeconds(172800));
		Appointment appointment = new Appointment("123", validDate , "A Giagntic toy");
		assertTrue(appointment.getId().equals("123"));
		assertTrue(appointment.getAppointmentDate().equals(validDate));
		assertTrue(appointment.getDescription().equals("A Giagntic toy"));
	}
	@Test
	void testIdIsNull() {
		Date validDate = Date.from(Calendar.getInstance().toInstant().plusSeconds(172800));
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Appointment(null, validDate, "A Giagntic toy");
		});
	}
	
	@Test
	void testIdIsTooLong() {
		Date validDate = Date.from(Calendar.getInstance().toInstant().plusSeconds(172800));
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Appointment("1236541654651511", validDate, "A Giagntic toy");
		});
	}
	
	@Test
	void testAppointmentIsNull() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Appointment("123", null, "A Giagntic toy");
		});
	}
	
	@Test
	void testAppointmentIsBeforeDate() {
		Date validDate = Date.from(Calendar.getInstance().toInstant().minusSeconds(172800));
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Appointment("123", validDate , "A Giagntic toy");
		});
	}
	@Test
	void testDescriptionIsNull() {
		Date validDate = Date.from(Calendar.getInstance().toInstant().plusSeconds(172800));
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Appointment("123", validDate, null);
		});
	}
	
	@Test
	void testDescriptionIsTooLong() {
		Date validDate = Date.from(Calendar.getInstance().toInstant().plusSeconds(172800));
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Appointment("1234567891011", validDate, "This is the hard part of testing where I have to test 50 characters"
					+ " to make sure that it works properly and can be overflown for how large the prompt needs to be."
					+ "I'll be looking into seeing if this works properly but if not im going to look for another option.");
		});
	}
}
