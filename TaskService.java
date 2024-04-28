/*
 * Andrew Rapolevich SNHU CS-320
*/
package TaskServices;
import java.util.HashMap;
import java.util.Map;
public class TaskService {
	private final Map<String, Task> tasks = new HashMap<>();
	public void addTask(Task task) {
		if (task == null || tasks.containsKey(task.getId())) {
			throw new IllegalArgumentException("Invald Task Id");
		}
		tasks.put(task.getId(), task);
	}
	
	public void deleteTask(String id) {
		if(!tasks.containsKey(id)) {
			throw new IllegalArgumentException("No Tasks with that Id");
		}
		tasks.remove(id);
	}
	
	public void updateTask(String id, String name, String description) {
		Task searchId = tasks.get(id);
		if (searchId == null) {
			throw new IllegalArgumentException("Please enter Task ID");
		}
		
		if (name != null) {
			searchId.setName(name);
		}
		
		if (description != null) {
			searchId.setDescription(description);
		}
	}
	
	public Task getSearchId(String id) {
		return tasks.get(id);
	}
}
