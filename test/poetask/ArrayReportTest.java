/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package poetask;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author RC_Student_lab
 */
public class ArrayReportTest {
    ArrayReport report = new ArrayReport();
    
    public ArrayReportTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of displayDoneTasks method, of class ArrayReport.
     */
    @Test
    public void testDisplayDoneTasks() {
               // Setup: Initialize the arrays
        String[] taskName = {"Create Login", "Create Add Features", "Create Report", "Add Arrays"};
        String[] developerDetails = {"Mike Smith", "Edward Harrington", "Samatha Paulson", "Glenda Oberholzer"};
        int[] taskDuration = {5, 8, 2, 11};
        int[] taskId = {1, 2, 3, 4};
        String[] taskStatus = {"To Do", "Doing", "Done", "To Do"};

        // Call the method
        report.displayDoneTasks();

        // Assertions: Ensure the correct task details are displayed
        String expectedOutput = "Completed Tasks:\n"
                + "Task Name: Create Report\nDeveloper: Samatha Paulson\nDuration: 2 hours\nStatus: Done\n\n";

        // Check if the output contains the correct "Done" task details
        assertTrue("Output does not contain expected task details", report.toString().contains(expectedOutput));
    
    
    }


    /**
     * Test of displayLongestTask method, of class ArrayReport.
     */
    @Test
    public void testDisplayLongestTask() {
    String[] taskName = {"Create Login", "Create Add Features", "Create Report", "Add Arrays"};
    String[] developerDetails = {"Mike Smith", "Edward Harrington", "Samatha Paulson", "Glenda Oberholzer"};
    int[] taskDuration = {5, 8, 2, 11};
    int[] taskId = {1, 2, 3, 4};
    String[] taskStatus = {"To Do", "Doing", "Done", "To Do"};
    report.displayLongestTask();
    }

    /**
     * Test of searchByTaskName method, of class ArrayReport.
     */
    @Test
    public void testSearchByTaskName(String searchName) {
    String[] taskName = {"Create Login", "Create Add Features", "Create Report", "Add Arrays"};
    String[] developerDetails = {"Mike Smith", "Edward Harrington", "Samatha Paulson", "Glenda Oberholzer"};
    int[] taskDuration = {5, 8, 2, 11};
    int[] taskId = {1, 2, 3, 4};
    String[] taskStatus = {"To Do", "Doing", "Done", "To Do"};
    report.searchByTaskName(searchName);
    }

    /**
     * Test of searchByDeveloper method, of class ArrayReport.
     */
    @Test
    public void testSearchByDeveloper(String searchDev) {
    String[] taskName = {"Create Login", "Create Add Features", "Create Report", "Add Arrays"};
    String[] developerDetails = {"Mike Smith", "Edward Harrington", "Samatha Paulson", "Glenda Oberholzer"};
    int[] taskDuration = {5, 8, 2, 11};
    int[] taskId = {1, 2, 3, 4};
    String[] taskStatus = {"To Do", "Doing", "Done", "To Do"};
    report.searchByDeveloper(searchDev);
    }

    /**
     * Test of deleteTask method, of class ArrayReport.
     */
    @Test
    public void testDeleteTask(String deleteName) {
    String[] taskName = {"Create Login", "Create Add Features", "Create Report", "Add Arrays"};
    String[] developerDetails = {"Mike Smith", "Edward Harrington", "Samatha Paulson", "Glenda Oberholzer"};
    int[] taskDuration = {5, 8, 2, 11};
    int[] taskId = {1, 2, 3, 4};
    String[] taskStatus = {"To Do", "Doing", "Done", "To Do"};
    report.deleteTask(deleteName);
    }

    /**
     * Test of displayAllTasks method, of class ArrayReport.
     */
    @Test
    public void testDisplayAllTasks() {
    String[] taskName = {"Create Report"};
    String[] developerDetails = {"Mike Smith", "Edward Harrington", "Samatha Paulson", "Glenda Oberholzer"};
    int[] taskDuration = {5, 8, 2, 11};
    int[] taskId = {1, 2, 3, 4};
    String[] taskStatus = {"To Do", "Doing", "Done", "To Do"};
    report.displayAllTasks();
    }
    
}
