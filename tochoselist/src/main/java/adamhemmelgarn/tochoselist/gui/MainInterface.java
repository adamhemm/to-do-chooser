package adamhemmelgarn.tochoselist.gui;
//this class creates and handles the main interface of the program
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import adamhemmelgarn.tochoselist.logic.*;
import adamhemmelgarn.tochoselist.classes.*;

public class MainInterface {
	
	private JFrame mainFrame;
	private JLabel headerLabel;
	private JLabel nameLabel;
	private JLabel descriptionLabel;
	private JPanel mainPanel;
	private JTextField taskName;
	private JTextArea taskDescription;
	private JButton addTaskButton;
	private ListHandler listHandler;
	
	public MainInterface() {
		SetUpGUI();
		listHandler = new ListHandler();
	}
	
	private void SetUpGUI() {
		mainFrame = new JFrame("To Choose List");
		mainFrame.setSize(400, 400);
		mainFrame.setLayout(new GridLayout(2,1));
		
		headerLabel = new JLabel("Enter your task in the fields below", JLabel.CENTER);
		headerLabel.setSize(350, 100);
		
		nameLabel = new JLabel("Name", JLabel.CENTER);
		descriptionLabel = new JLabel("Description", JLabel.CENTER);
		
		taskName = new JTextField(1);
		taskName.setText("");
		taskDescription = new JTextArea(1,1);
		taskDescription.setText("");
		
		addTaskButton = new JButton("Add Task");
		addTaskButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String tempName = taskName.getText();
				String tempDesc = taskDescription.getText();
				listHandler.AddTask(tempName, tempDesc);
			}
		});
		
		mainFrame.addWindowListener(new WindowAdapter() {
			public void WindowClosing(WindowEvent windowEvent) {
				System.exit(0);
			}
		});
		mainPanel = new JPanel();
		mainPanel.setSize(300, 300);
		mainPanel.setLayout(new GridLayout(2,2));
		mainPanel.add(nameLabel);
		mainPanel.add(taskName);
		mainPanel.add(descriptionLabel);
		mainPanel.add(taskDescription);
		mainPanel.add(addTaskButton);
		
		mainFrame.add(headerLabel);
		mainFrame.add(mainPanel);
		mainFrame.setVisible(true);
	}

}
