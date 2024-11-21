/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package poetask;

import javax.swing.JOptionPane;

/**
 *
 * @author RC_Student_lab
 */
public class ArrayReport {
//        String[] taskName;
//    int[] taskNumber;
//    String[] taskDescription;
//    String[] developerDetails;
//    int[] taskDuration ;
//    String[] taskId ;
//    String[] mainMenu;
//    String[] taskStatus;
//    int total = 0;
//    int size = 0;
//    private Object tasksByDeveloper;
    
    String[] taskName = {"Create Login", "Create Add Features", "Create Report", "Add Arrays"};
    String[] developerDetails = {"Mike Smith", "Edward Harrington", "Samatha Paulson", "Glenda Oberholzer"};
    int[] taskDuration = {5, 8, 2, 11};
    int[] taskId = {1, 2, 3, 4};
    String[] taskStatus = {"To Do", "Doing", "Done", "To Do"};
    int total = 0;
    int size = 0;
    //private Object tasksByDeveloper;
    String taskNumber;
    String taskDescription;
    
        //Display the cpmpleted task
    public boolean displayDoneTasks(){
        StringBuilder completedTasks = new StringBuilder("Completed Tasks:\n");
        boolean hasDoneTasks = false;
             for (int i = 0; i < taskStatus.length; i++) {
             if (taskStatus[i].equals("Done")) {
                 completedTasks.append("Task name:").append(taskName[i])
                         .append("\nDeveloper details:").append(developerDetails[i])
                         .append("\nTask Duration:").append(taskDuration[i])
                         .append("\n Task Status:").append(taskStatus[i]);
                hasDoneTasks = true;
             }
             }
                if (hasDoneTasks) {
        JOptionPane.showMessageDialog(null, completedTasks.toString(), "Completed Tasks", JOptionPane.INFORMATION_MESSAGE);
    } else {
        JOptionPane.showMessageDialog(null, "No tasks with 'Done' status found.", "Completed Tasks", JOptionPane.INFORMATION_MESSAGE);
    }
            return false;
   
    }
    
        // Display the longest task
    public void displayLongestTask() {    

if (taskDuration.length == 0) {
        JOptionPane.showMessageDialog(null, "No tasks available.", "Error", JOptionPane.ERROR_MESSAGE);
        return;
    }

    int maxIndex = 0;

    // Find the index of the task with the longest duration
    for (int i = 1; i < taskDuration.length; i++) {
        if (taskDuration[i] > taskDuration[maxIndex]) {
            maxIndex = i;
        }
        // Display the longest task details
    JOptionPane.showMessageDialog(null, "Longest Task:\n"
            + "Task Name: " + taskName[maxIndex] + "\n"
            + "Developer: " + developerDetails[maxIndex] + "\n"
            + "Duration: " + taskDuration[maxIndex] + " hours\n"
            + "Status: " + taskStatus[maxIndex], "Longest Task", JOptionPane.INFORMATION_MESSAGE);
    }
    }
        // Search by task name
    public void searchByTaskName(String searchName) {     
for (int i = 0; i < taskName.length; i++) {
        if (taskName[i].equalsIgnoreCase(searchName)) {
            JOptionPane.showMessageDialog(null, "Task Found:"
                    + "\nTask Name: " + taskName[i]
                    + "\nDeveloper: " + developerDetails[i]
                    + "\nStatus: " + taskStatus[i]
                    + "\nDuration: " + taskDuration[i] + " hours", "Search Result", JOptionPane.INFORMATION_MESSAGE);
            return; // Exit method once the task is found
        }else{
            JOptionPane.showMessageDialog(null, "Task not found.", "Search Result", JOptionPane.ERROR_MESSAGE);
        }
    }
 
    
    }
    
    //Search by developer
        public void searchByDeveloper(String searchDev) {
//        StringBuilder output = new StringBuilder("Tasks for developer " + developerDetails + ":\n");
//        boolean found = false;
        
        for (int i = 0; i < developerDetails.length; i++) {            
            if (developerDetails[i].equalsIgnoreCase(searchDev)) {
                JOptionPane.showMessageDialog(null, "Developer Detail:" + developerDetails
                        +"\nTask Name:" + taskName
                        +"\nTask status: " + taskStatus
                        +"\nTask Duration: " + taskDuration
                
                );
                break;
            }
//                output.append("Task Name: ").append(taskName[i])
//                      .append("\nStatus: ").append(taskStatus[i])
//                      .append("\nDuration: ").append(taskDuration[i]).append(" hours\n\n");
//            found = true;
//        
//        }
//            if(found){
//                JOptionPane.showMessageDialog(null, output.toString(), "Search by Developer", JOptionPane.INFORMATION_MESSAGE);
//            } else{
//                JOptionPane.showMessageDialog(null, "No tasks found for this developer.", "Search by Developer", JOptionPane.ERROR_MESSAGE);
//                }
    
        }
        }
           
        // Delete a task
    public void deleteTask(String deleteName) {
        boolean taskdelete = false;
        
        for (int i = 0; i < size; i++) {
            if (taskName[i].equalsIgnoreCase(deleteName)) {
                // Shift remaining tasks to fill the gap
                for (int r = i; r < size - 1; r++) {
                    taskName[r] = taskName[r + 1];
                    developerDetails[r] = developerDetails[r + 1];
                    taskDuration[r] = taskDuration[r + 1];
                    taskId[r] = taskId[r + 1];
                    taskStatus[r] = taskStatus[r + 1];
                }
                            // Clear the last element
            taskName[size - 1] = null;
            developerDetails[size - 1] = null;
            taskDuration[size - 1] = 0; 
            taskId[size - 1] = 0;
            taskStatus[size - 1] = null;

                size--; // Reduce task count
                taskdelete = true;
                JOptionPane.showMessageDialog(null, "Task deleted successfully.", "Delete Task", JOptionPane.PLAIN_MESSAGE);                
                break;
            }
        if(!taskdelete){
        JOptionPane.showMessageDialog(null, "Task not found.", "Delete Task", JOptionPane.ERROR_MESSAGE);
    }
    }
    }
    
            // Display all tasks
    public void displayAllTasks() {
        for (int i = 0; i < taskName.length; i++ )
            JOptionPane.showMessageDialog(null, "Task Name:" +taskName[i]
                    +"Task Number:" + taskNumber
                    +"Task Description: " + taskDescription
                    +"Task Developer Details: " + developerDetails[i]
                    +"Tadk duratiuon: " + taskDuration[i]
                    +"TadkID: " + taskId[i]
                    +"Task Status: " + taskStatus[i], "Task report", 1
                    
            );
//                return "Task Details:\n"
//                + "Task Status: " + mainMenu[pointer] + "\n"
//                + "Task Number: " + taskNumber[pointer] + "\n"
//                + "Task Name: " + taskName[pointer] + "\n"
//                + "Task Description: " + taskDescription[pointer] + "\n"
//                + "Task ID: " + taskId[pointer] + "\n"
//                + "Task Duration: " + taskDuration[pointer] + " hours";
//        if (size == 0) {
//            JOptionPane.showMessageDialog(null, "No tasks available.", "Task Report", JOptionPane.INFORMATION_MESSAGE);
//            return;
//        }
//
//        StringBuilder report = new StringBuilder("All Tasks:\n");
//        for (int i = 0; i < size; i++) {

//                   
//        }
//            JOptionPane.showMessageDialog(null, report.toString(), "Task Report", JOptionPane.INFORMATION_MESSAGE);
        } 

}
    

