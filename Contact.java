/*
 * Andrew Rapolevich SNHU CS-320.
 */
package ContactServices;

public class Contact {

	private String firstName;
	private String lastName;
	private String phone;
	private String address;
	private String id;

	public Contact(String id, String firstName, String lastName, String phone, String address) {

		if (id == null || id.length() > 10) {
			throw new IllegalArgumentException("Invalid ID");
		}

		if (firstName == null || firstName.length() > 10) {
			throw new IllegalArgumentException("Invalid First Name");
		}

		if (lastName == null || lastName.length() > 10) {
			throw new IllegalArgumentException("Invalid Last Name");
		}

		if (phone == null || phone.length() != 10) {
			throw new IllegalArgumentException("Invalid Phone Number (Must be 10 Digits)");
		}

		if (address == null || address.length() > 30) {
			throw new IllegalArgumentException("Invalid Address");
		}
		this.firstName = firstName;
		this.lastName = lastName;
		this.phone = phone;
		this.address = address;
		this.id = id;

	}

	public String getId() {
		return id;
	}

	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public String getPhone() {
		return phone;
	}

	public String getAddress() {
		return address;
	}

	public void setFirstName(String firstName) {
		if (firstName == null || firstName.length() > 10) {
			throw new IllegalArgumentException("Invalid Input First Name.");
		}
		this.firstName = firstName;
	}

	public void setLastName(String lastName) {
		if (lastName == null || lastName.length() > 10) {
			throw new IllegalArgumentException("Invalid Input Last Name.");
		}
		this.lastName = lastName;
	}

	public void setPhone(String phone) {
		if (phone == null || phone.length() != 10) {
			throw new IllegalArgumentException("Invalid Phone Number (Must be 10 digits)");
		}
		this.phone = phone;
	}

	public void setAddress(String address) {
		if (address == null || address.length() > 30) {
			throw new IllegalArgumentException("Invalid Address.");
		}
		this.address = address;
	}

}
