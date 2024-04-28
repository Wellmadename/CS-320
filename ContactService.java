/*
 * Andrew Rapolevich SNHU CS-320.
 */
package ContactServices;

import java.util.Map;
import java.util.HashMap;

public class ContactService {
	private final Map<String, Contact> contacts = new HashMap<>(); // Hashing and creating keys

	public void addContact(Contact contact) {
		if (contact == null || contacts.containsKey(contact.getId())) { // If our contact is null or it matches an
																		// existing key.
			throw new IllegalArgumentException("Invalid Contact Input"); // Throw exception
		}
		contacts.put(contact.getId(), contact); // If statement not executed just add the contact.
	}

	public void deleteContact(String id) {
		if (!contacts.containsKey(id)) { // If the contact does not contain a previously generated key
			throw new IllegalArgumentException("No Valid Contact Exists"); // Throw an exception
		}
		contacts.remove(id); // Otherwise just remove the id.
	}

	public void updateContact(String id, String firstName, String lastName, String phone, String address) {

		Contact searchId = contacts.get(id);

		if (searchId == null) { // if id null
			throw new IllegalArgumentException("No Valid Contact Exists");
		}

		if (firstName != null) { // if first name is not null
			searchId.setFirstName(firstName); // set a first name
		}

		if (lastName != null) { // if last name is not null
			searchId.setLastName(lastName); // set a last name
		}

		if (phone != null) { // if the phone isn't null
			searchId.setPhone(phone); // set a phone number
		}

		if (address != null) { // if address is not null
			searchId.setAddress(address); // set an address
		}
	}

	public Contact getSearchId(String id) {
		return contacts.get(id);
	}
}
