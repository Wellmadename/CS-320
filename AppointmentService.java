/*
 * Andrew Rapolevich SNHU CS-320
*/
package AppointmentServices;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class AppointmentService {
	private final Map<String, Appointment> appointments = new HashMap<>();
	public void addAppointment(Appointment appointment) {
		if (appointment == null || appointments.containsKey(appointment.getId())) {
			throw new IllegalArgumentException("Invald Appointment Id");
		}
		appointments.put(appointment.getId(), appointment);
	}
	
	public void deleteAppointment(String id) {
		if(!appointments.containsKey(id)) {
			throw new IllegalArgumentException("No Appointments with that Id");
		}
		appointments.remove(id);
	}
	
	public void updateAppointment(String id, Date appointmentDate, String description) {
		Appointment appointment = appointments.get(id);
		if (appointment == null) {
			throw new IllegalArgumentException("Please enter appointment ID");
		}
		
		if (appointmentDate != null) {
			appointment.setAppointmentDate(appointmentDate);
		}
		
		if (description != null) {
			appointment.setDescription(description);
		}
	}
	
	public Appointment getAppointmentId(String id) {
		return appointments.get(id);
	}
}
