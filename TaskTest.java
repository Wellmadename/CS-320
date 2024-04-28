/*
 * Andrew Rapolevich SNHU CS-320
*/
package TaskServicesTests;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Assertions;
import TaskServices.Task;
import org.junit.jupiter.api.Test;
class TaskTest {
	@Test
	void testTask() {
		Task task = new Task("123456", "Scott", "A small pool toy");
		assertTrue(task.getId().equals("123456"));
		assertTrue(task.getName().equals("Scott"));
		assertTrue(task.getDescription().equals("A small pool toy"));
	}
	@Test
	void testIdIsNull() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Task(null, "Scott", "A small pool toy");
		});
	}
	
	@Test
	void testIdIsTooLong() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Task("1234567891011", "Scott", "A small pool toy");
		});
	}
	
	@Test
	void testNameIsNull() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Task("123456", null, "A small pool toy");
		});
	}
	
	@Test
	void testNameIsTooLong() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Task("123456", "Scottypipkinsdilligentlyhere", "A small pool toy");
		});
	}
	@Test
	void testDescriptionIsNull() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Task("123456", "Scott", null);
		});
	}
	
	@Test
	void testDescriptionIsTooLong() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Task("1234567891011", "Scott", "This is the hard part of testing where I have to test 50 characters"
					+ " to make sure that it works properly and can be overflown for how large the prompt needs to be."
					+ "I'll be looking into seeing if this works properly but if not im going to look for another option.");
		});
	}
}
