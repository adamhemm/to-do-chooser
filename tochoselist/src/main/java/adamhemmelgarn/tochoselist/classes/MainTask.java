package adamhemmelgarn.tochoselist.classes;
//this class is the main tasks that will comprise the list
public class MainTask {
	
	private boolean isSelected = false;
	private boolean isCompleted = false;
	private String taskName;
	private String taskDescription;
	private boolean hasSub = false;
	private Integer numberOfSubTasks = 3;
	//the number of sub tasks is defaulted to 3 but can be increased to 6 when creating or editing the task
	private SubTask[] subTaskList;
	private boolean hasDependant = false;
	private MainTask dependantTask;
	
	public MainTask(String name, String description, Integer subNumber) {
		taskName = name;
		taskDescription = description;
		numberOfSubTasks = subNumber;
		subTaskList = new SubTask[subNumber];
	}
	
	public void selectTask() {
		isSelected = true;
	}
	
	public void completeTask() {
		isCompleted = true;
		isSelected = false;
	}
	
	public void setDependantTask(MainTask dependant) {
		hasDependant = true;
		dependantTask = dependant;
	}
	
	public void setSubList(SubTask[] subList) {
		if(subList.length > numberOfSubTasks) {
			//put in code to send error message that input list is greater than the task's sub task list
		}
		else {
			hasSub = true;
			subTaskList= subList;
		}
	}
	
	public MainTask getDependantTask() {
		if(hasDependant) {
			return dependantTask;
		}
		else {
			return null;
		}
	}
	
	public SubTask[] getSubTaskList() {
		if(hasSub) {
			return subTaskList;
		}
		else {
			return null;
		}
	}

	public boolean isSelected() {
		return isSelected;
	}

	public boolean isCompleted() {
		return isCompleted;
	}

	public String getTaskName() {
		return taskName;
	}

	public String getTaskDescription() {
		return taskDescription;
	}

	public boolean isHasSub() {
		return hasSub;
	}

	public Integer getNumberOfSubTasks() {
		return numberOfSubTasks;
	}

	public boolean isHasDependant() {
		return hasDependant;
	}

}
