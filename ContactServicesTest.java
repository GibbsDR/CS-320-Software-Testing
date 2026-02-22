package Contact;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class ContactServicesTest {

    @Test
    void testAddContact() {
        ContactServices service = new ContactServices();
        Contact contact = new Contact("1", "John", "Doe", "1234567890", "123 Main Street");
        service.addContact(contact);
        assertNotNull(service.getContact("1"));
    }

    @Test
    void testDeleteContact() {
        ContactServices service = new ContactServices();
        Contact contact = new Contact("1", "John", "Doe", "1234567890", "123 Main Street");
        service.addContact(contact);
        service.deleteContact("1");
        assertNull(service.getContact("1"));
    }

    @Test
    void testUpdateContactFields() {
        ContactServices service = new ContactServices();
        Contact contact = new Contact("1", "John", "Doe", "1234567890", "123 Main Street");
        service.addContact(contact);

        service.updateFirstName("1", "Jane");
        service.updateLastName("1", "Smith");
        service.updatePhone("1", "0987654321");
        service.updateAddress("1", "456 Oak Avenue");

        Contact updated = service.getContact("1");
        assertEquals("Jane", updated.getFirstName());
        assertEquals("Smith", updated.getLastName());
        assertEquals("0987654321", updated.getPhone());
        assertEquals("456 Oak Avenue", updated.getAddress());
    }
}
