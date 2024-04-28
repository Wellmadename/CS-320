/*
 * Andrew Rapolevich SNHU CS-320.
 */
package ContactServiceTests;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ContactServices.Contact;
import ContactServices.ContactService;

class ContactServiceTest {

	private ContactService contactService;
	private Contact contact;

	@BeforeEach
	void setUp() { //Pass (Used to give us our initial test value in lieu of a menu for input. 
		contactService = new ContactService();
		contact = new Contact("123456", "Jackson", "Stone", "1927908923", "7823 Carport ave");
	}

	@Test
	void addContact() { //Pass
		contactService.addContact(contact);
		assertEquals(contact, contactService.getSearchId("123456"));
	}

	@Test
	void addContactWithMatchingId() { //Pass
		contactService.addContact(contact);
		 assertThrows(IllegalArgumentException.class, () -> contactService.addContact(contact));
	}

	@Test
	void deleteContact() { //Pass
		contactService.addContact(contact);
		contactService.deleteContact("123456");
		assertNull(contactService.getSearchId("123456"));
	}
    
    @Test
    void testUpdateContact() { //Pass
        contactService.addContact(contact);
        contactService.updateContact("123456", "NewFirst", "UpdatedL", "1987234726", "10290 ChickenRun St");
        Contact updatedContact = contactService.getSearchId("123456");
        
        //Verifying if all entries work how they are supposed to.
        assertNotNull(updatedContact);
        assertEquals("NewFirst", updatedContact.getFirstName());
        assertEquals("UpdatedL", updatedContact.getLastName());
        assertEquals("1987234726", updatedContact.getPhone());
        assertEquals("10290 ChickenRun St", updatedContact.getAddress());
    }
}

