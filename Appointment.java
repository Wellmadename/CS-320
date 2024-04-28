/*
 * Andrew Rapolevich SNHU CS-320
*/
package AppointmentServices;

import java.util.Date;

public class Appointment {
		private String id;
		private Date appointmentDate;
		private String description;
		
		public Appointment(String id, Date appointmentDate, String description) {
			if (id == null || id.length() > 10) {
				throw new IllegalArgumentException("Invalid id");
			}
			if (appointmentDate == null || appointmentDate.before(new Date())) {
				throw new IllegalArgumentException("Invalid appointment date");
			}
			if (description == null || description.length() > 50) {
				throw new IllegalArgumentException("Invalid description");
			}
			this.id = id;
			this.appointmentDate = new Date(appointmentDate.getTime());
			this.description = description;
		}
		
		public String getId() {
			return id;
		}
		
		public Date getAppointmentDate() {
			return appointmentDate;
		}
		
		public String getDescription() {
			return description;
		}
		
		public void setAppointmentDate(Date appointmentDate) {
			if (appointmentDate == null || appointmentDate.before(new Date())) {
				throw new IllegalArgumentException("Invalid date");
			}
			this.appointmentDate = new Date(appointmentDate.getTime());
		}
		
		public void setDescription(String description) {
			if (description == null || description.length() > 50) {
				throw new IllegalArgumentException("Invalid description");
			}
			this.description = description;
		}
}
