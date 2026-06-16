package adamhemmelgarn.tochoselist.gui;
//this class creates and handles the main interface of the program
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

import adamhemmelgarn.tochoselist.logic.*;
import adamhemmelgarn.tochoselist.classes.*;

public class MainInterface {
	
	private JFrame mainFrame;
	private JLabel headerLabel;
	private JLabel nameLabel;
	private JLabel descriptionLabel;
	private JPanel mainPanel;
	private JPanel listPanel;
	private JPanel listButtonPanel;
	private JPanel listWrapper;
	private JPanel buttonPanel;
	private JTextField taskName;
	private JTextArea taskDescription;
	private JButton addTaskButton;
	private JButton nextButton;
	private JButton prevButton;
	private JButton saveButton;
	private CardLayout cl;
	private ListHandler listHandler;
	private LoadHandler loadHandler;//use when loading a list file
	private ArrayList<MainTask> toChooseList;
	
	public MainInterface() {
		SetUpGUI();
	}
	
	private void UpdateList() {//used when a list has been loaded or created
		toChooseList = listHandler.getToChooseList();
		listPanel.removeAll();
		for(MainTask main : toChooseList) {
			JPanel cardPanel = new JPanel();
			JLabel name = new JLabel(main.getTaskName(), JLabel.CENTER);
			JLabel desc = new JLabel(main.getTaskDescription(), JLabel.CENTER);
			cardPanel.add(name);
			cardPanel.add(desc);
			listPanel.add(cardPanel);
		}
		listPanel.updateUI();
		listWrapper.setVisible(true);
		
	}
	
	private void SetUpGUI() {
		mainFrame = new JFrame("To Choose List");
		mainFrame.setSize(400, 400);
		mainFrame.setLayout(new GridLayout(4,1));
		
		listPanel = new JPanel();
		listButtonPanel = new JPanel();
		listWrapper = new JPanel();
		cl = new CardLayout();
		listPanel.setLayout(cl);
		listButtonPanel.setLayout(new GridLayout(1,2));
		listWrapper.setLayout(new GridLayout(2,1));
		listHandler = new ListHandler();
		
		nextButton = new JButton("next");
		prevButton = new JButton("previous");
		nextButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cl.next(listPanel);
			}
		});
		prevButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cl.previous(listPanel);
			}
		});
		listButtonPanel.add(nextButton);
		listButtonPanel.add(prevButton);
		listWrapper.add(listPanel);
		listWrapper.add(listButtonPanel);
		listWrapper.setVisible(false);
		
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
				taskName.setText(null);
				taskDescription.setText(null);
				UpdateList();
			}
		});
		
		mainFrame.addWindowListener(new WindowAdapter() {
			public void WindowClosing(WindowEvent windowEvent) {
				System.exit(0);
			}
		});
		saveButton = new JButton("Save List");
		
		mainPanel = new JPanel();
		mainPanel.setSize(300, 300);
		mainPanel.setLayout(new GridLayout(2,2));
		mainPanel.add(nameLabel);
		mainPanel.add(taskName);
		mainPanel.add(descriptionLabel);
		mainPanel.add(taskDescription);
		buttonPanel = new JPanel();
		buttonPanel.setLayout(new GridLayout(1,2));
		buttonPanel.add(addTaskButton);
		buttonPanel.add(saveButton);
		
		mainFrame.add(listWrapper);
		mainFrame.add(headerLabel);
		mainFrame.add(mainPanel);
		mainFrame.add(buttonPanel);
		mainFrame.setVisible(true);
	}

}
