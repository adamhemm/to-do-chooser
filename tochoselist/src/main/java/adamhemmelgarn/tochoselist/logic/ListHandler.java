package adamhemmelgarn.tochoselist.logic;
//this class handles all interactions with the task list; selecting a task, marking a task complete,
//adding new tasks to a list, removing a task from the list, translate the list to and from a JSON
//format for saving and loading, and updating and editing individual tasks as necessary
import adamhemmelgarn.tochoselist.classes.*;
import java.util.ArrayList;

public class ListHandler {
	
	private ArrayList<MainTask> toChooseList;
	private String taskName;
	private String taskDesc;
	
	public ListHandler() {
		toChooseList = new ArrayList<MainTask>();
	}
	
	public void AddTask(String tempName, String tempDesc) {
		MainTask taskToAdd = new MainTask(tempName, tempDesc,0);
		toChooseList.add(taskToAdd);
		//System.out.println(toChooseList.get(0).getTaskName());
		//System.out.println(toChooseList.get(0).getTaskDescription());
	}

	public ArrayList<MainTask> getToChooseList() {
		return toChooseList;
	}

}
