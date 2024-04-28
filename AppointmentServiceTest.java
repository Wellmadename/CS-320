/*
 * Andrew Rapolevich SNHU CS-320
*/
package AppointmentServicesTests;
import java.util.Calendar;
import java.util.Date;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import AppointmentServices.Appointment;
import AppointmentServices.AppointmentService;

class AppointmentServiceTest {
	private AppointmentService appointmentService;
	
	@BeforeEach
	void setUp() {
		appointmentService = new AppointmentService();
	}
	
	@Test
	void addAppointment() { //Pass
		Date validDate = Date.from(Calendar.getInstance().toInstant().plusSeconds(86400));
	    Appointment appointment = new Appointment("1234567", validDate, "Test Description"); //Setting the input. 
	    appointmentService.addAppointment(appointment);
	    Assertions.assertNotNull(appointmentService.getAppointmentId("1234567")); //Making sure the Appointment exists.
	}
	
	@Test
	void addAppointmentWithDuplicateId() { //Pass
		Date validDate = Date.from(Calendar.getInstance().toInstant().plusSeconds(86400));
	    Appointment firstAppointment = new Appointment("4321", validDate, "JUnit test Description");
	    Appointment secondAppointment = new Appointment("4321", validDate, "JUnit test Description");
	    appointmentService.addAppointment(firstAppointment);
	    Assertions.assertThrows(IllegalArgumentException.class, () -> {
	        appointmentService.addAppointment(secondAppointment);
	    });
	}
	
	@Test
	void deleteAppointment() { //Pass
		Date validDate = Date.from(Calendar.getInstance().toInstant().plusSeconds(86400));
	    Appointment Appointment = new Appointment("1234", validDate, "Test Decription");
	    appointmentService.addAppointment(Appointment);
	    appointmentService.deleteAppointment("1234");
	    Assertions.assertNull(appointmentService.getAppointmentId("1234")); //Determining if the Appointment had been deleted.
	}
	
	@Test
	void updateAppointment() { //Pass
		Date validDate = Date.from(Calendar.getInstance().toInstant().plusSeconds(86400));
		Date validDateTwo = Date.from(Calendar.getInstance().toInstant().plusSeconds(604800));
	    Appointment appointment = new Appointment("1234", validDate, "Test Description");
	    appointmentService.addAppointment(appointment);
	    appointmentService.updateAppointment("1234", validDateTwo, "The final description now");
	    Appointment updatedAppointment = appointmentService.getAppointmentId("1234");
	    Assertions.assertEquals(validDateTwo, updatedAppointment.getAppointmentDate()); //Validate we changed it.
	    Assertions.assertEquals("The final description now", updatedAppointment.getDescription()); //Same purpose as previous assertion.
	}
}
