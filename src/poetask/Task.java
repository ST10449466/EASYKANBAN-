package poetask;

import javax.swing.*;

public class Task {

    private String[] taskName;
    private int[] taskNumber;
    private String[] taskDescription;
    private String[] developerDetails;
    private int[] taskDuration;
    private String[] taskId;
    private String[] mainMenu;
    private String[] taskStatus;
    private int total = 0;
    private int size = 0;

    public void addTasks() {
        int numberOfTasks = Integer.parseInt(JOptionPane.showInputDialog("How many tasks do you want to capture?"));

        // Initialize arrays based on the number of tasks
        taskName = new String[numberOfTasks];
        taskDescription = new String[numberOfTasks];
        developerDetails = new String[numberOfTasks];
        taskDuration = new int[numberOfTasks];
        taskNumber = new int[numberOfTasks];
        taskId = new String[numberOfTasks];
        mainMenu = new String[numberOfTasks];
        taskStatus = new String[numberOfTasks];

        for (int k = 0; k < numberOfTasks; k++) {
            taskName[k] = JOptionPane.showInputDialog("Enter the task name");

            String description;
            boolean valid = false;
            while (!valid) {
                description = JOptionPane.showInputDialog("Enter the task description (max 50 characters)");
                if (checkTaskDescription(description)) {
                    taskDescription[k] = description;
                    valid = true;
                }
            }

            developerDetails[k] = JOptionPane.showInputDialog("Enter the developer's name and surname");
            taskDuration[k] = Integer.parseInt(JOptionPane.showInputDialog("Enter task duration in hours"));
            total += taskDuration[k];

            taskNumber[k] = k + 1;
            taskId[k] = createTaskId(taskName[k], taskNumber[k], developerDetails[k]);
            mainMenu[k] = taskStatus();

            JOptionPane.showMessageDialog(null, printTaskDetails(k), "Task Details", JOptionPane.PLAIN_MESSAGE);
             JOptionPane.showMessageDialog(null, "Total hours " + total + "hrs", "Total hours", JOptionPane.PLAIN_MESSAGE);
        
        }
    }

    public boolean checkTaskDescription(String taskDescription) {
        if (taskDescription.length() <= 50) {
            JOptionPane.showMessageDialog(null, "Task description is successfully captured.", "Task description", JOptionPane.INFORMATION_MESSAGE);
            return true;
        } else {
            JOptionPane.showMessageDialog(null, "Please enter a task description of less than 50 characters.", "Task description", JOptionPane.ERROR_MESSAGE);
            return false;
        }
    }

    public String createTaskId(String taskName, int taskNumber, String developerDetails) {
        String namePart = taskName.length() >= 2 ? taskName.substring(0, 2).toUpperCase() : taskName.toUpperCase();
        String devPart = developerDetails.split(" ")[1].substring(0, 3).toUpperCase();
        return namePart + ":" + taskNumber + ":" + devPart;
    }

    public String printTaskDetails(int pointer) {
        return "Task Details:\n"
                + "Task Status: " + mainMenu[pointer] + "\n"
                + "Task Number: " + taskNumber[pointer] + "\n"
                + "Task Name: " + taskName[pointer] + "\n"
                + "Task Description: " + taskDescription[pointer] + "\n"
                + "Task ID: " + taskId[pointer] + "\n"
                + "Task Duration: " + taskDuration[pointer] + " hours";
    }

    public String taskStatus() {
        String status = "";
        boolean valid = false;

        while (!valid) {
            int choice = Integer.parseInt(JOptionPane.showInputDialog(null, "Select task status:\n1. To do\n2. Doing\n3. Done"));
            switch (choice) {
                case 1:
                    status = "To do";
                    valid = true;
                    break;
                case 2:
                    status = "Doing";
                    valid = true;
                    break;
                case 3:
                    status = "Done";
                    valid = true;
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Invalid option. Enter 1 - 3.");
            }
        }
        return status;
    }

}
    

