/*
 * Andrew Rapolevich SNHU CS-320
*/
package TaskServicesTests;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import TaskServices.Task;
import TaskServices.TaskService;

class TaskServiceTest {
	private TaskService taskService;
	
	@BeforeEach
	void setUp() {
		taskService = new TaskService();
	}
	
	@Test
	void addTask() { //Pass
	    Task task = new Task("1234", "Jacob", "Test Description"); //Setting the input. 
	    taskService.addTask(task);
	    Assertions.assertNotNull(taskService.getSearchId("1234")); //Making sure the task exists.
	}
	
	@Test
	void addTaskWithDuplicateId() { //Pass
	    Task firstTask = new Task("1234", "Jacob", "Test Description");
	    Task secondTask = new Task("1234", "Jacob", "Test Description");
	    taskService.addTask(firstTask);
	    Assertions.assertThrows(IllegalArgumentException.class, () -> {
	        taskService.addTask(secondTask);
	    });
	}
	
	@Test
	void deleteTask() { //Pass
	    Task task = new Task("1234", "Jacob", "Test Decription");
	    taskService.addTask(task);
	    taskService.deleteTask("1234");
	    Assertions.assertNull(taskService.getSearchId("1234")); //Determining if the task had been deleted.
	}
	
	@Test
	void updateTask() { //Pass
	    Task task = new Task("1234", "Jacob", "Test Description");
	    taskService.addTask(task);
	    taskService.updateTask("1234", "Bocaj", "The final description now");
	    Task updatedTask = taskService.getSearchId("1234");
	    Assertions.assertEquals("Bocaj", updatedTask.getName()); //Validate we changed it.
	    Assertions.assertEquals("The final description now", updatedTask.getDescription()); //Same purpose as previous assertion.
	}
}

