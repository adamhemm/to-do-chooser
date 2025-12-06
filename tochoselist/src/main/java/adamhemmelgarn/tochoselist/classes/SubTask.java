package adamhemmelgarn.tochoselist.classes;
//this class represents sub tasks for the main tasks. it is bare bones as the sub tasks
//are meant to just break up a main task, not replace it
public class SubTask {
	
	private String taskName;
	private String taskDescription;
	
	public SubTask(String name, String description) {
		taskName = name;
		taskDescription = description;
	}

	public String getTaskName() {
		return taskName;
	}

	public String getTaskDescription() {
		return taskDescription;
	}

}
