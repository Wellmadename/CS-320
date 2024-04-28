/*
 * Andrew Rapolevich SNHU CS-320.
 */
package ContactServiceTests;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import ContactServices.Contact;

class ContactTest {
	@Test
	void testContact() { // Pass (Making sure our entries are correct and fulfill the prompts properly.)
		Contact contact = new Contact("12345", "Andrew", "Rapolevich", "1717453923", "1234 Street ave");
		assertTrue(contact.getId().equals("12345"));
		assertTrue(contact.getFirstName().equals("Andrew"));
		assertTrue(contact.getLastName().equals("Rapolevich"));
		assertTrue(contact.getPhone().equals("1717453923"));
		assertTrue(contact.getAddress().equals("1234 Street ave"));
	}

	@Test
	void testContactIdTooLong() { // Pass
		assertThrows(IllegalArgumentException.class, () -> {
			new Contact("1234523423421342", "Andrew", "Rapolevich", "1717453923", "1234 Street ave");
		});

	}

	@Test
	void testContactIdNull() { // Pass
		assertThrows(IllegalArgumentException.class, () -> {
			new Contact(null, "Andrew", "Rapolevich", "1717453923", "1234 Street ave");
		});
	}

	@Test
	void testContactFirstNameTooLong() { //Pass
		assertThrows(IllegalArgumentException.class, () -> {
			new Contact("12345", "Andrewsnameiswaytoolong", "Rapolevich", "1717453923", "1234 Street ave");
		});
	}

	@Test
	void testContactFirstNameNull() { //Pass
		assertThrows(IllegalArgumentException.class, () -> {
			new Contact("12345", null, "Rapolevich", "1717453923", "1234 Street ave");
		});
	}

	@Test
	void testContactLastNameTooLong() { //Pass
		assertThrows(IllegalArgumentException.class, () -> {
			new Contact("12345", "Andrew", "Rapolevichisjustlong", "1717453923", "1234 Street ave");
		});
	}

	@Test
	void testContactLastNameNull() { //Pass
		assertThrows(IllegalArgumentException.class, () -> {
			new Contact("12345", "Andrew", null, "1717453923", "1234 Street ave");
		});
	}

	@Test
	void testContactPhoneNotTenDigits() { //Pass
		assertThrows(IllegalArgumentException.class, () -> {
			new Contact("12345", "Andrew", "Rapolevich", "17174539231231", "1234 Street ave");
		});
	}

	@Test
	void testContactPhoneNull() { //Pass
		assertThrows(IllegalArgumentException.class, () -> {
			new Contact("12345", "Andrew", "Rapolevich", null, "1234 Street ave");
		});
	}

	@Test
	void testContactAddressTooLong() { //Pass
		assertThrows(IllegalArgumentException.class, () -> {
			new Contact("12345", "Andrew", "Rapolevich", "1717453923",
					"123456712312312313123123123112312312123333331231453262345 "
							+ "31312313123123121231323131231231312312312313212 Street ave");
		});
	}

	@Test
	void testContactAddressNull() { //Pass
		assertThrows(IllegalArgumentException.class, () -> {
			new Contact("12345", "Andrew", "Rapolevich", "1717453923", null);
		});
	}
}