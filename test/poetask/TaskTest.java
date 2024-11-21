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
public class TaskTest {

    private int[] taskDuration;
    private int numTasks;

    /**
     * Test of checkTaskDescription method, of class Task.
     */
    public boolean checkTaskDescription(String Description) {

        return Description.length() <= 50;

    }

    @Test
    public void checkTaskDescription_Succes_MikeSmith() {
        String valid = "Create a task feature and task user. ";
        boolean result = checkTaskDescription(valid);
        assertTrue(result);

    }

    @Test
    public void checkTaskDescription_failure_MikeSmith() {
        String valid = "Please enter a task description of  less than 50 characters ";
        boolean result = checkTaskDescription(valid);
        assertFalse(result);

    }

    @Test
    public void checkTaskDescription_Succes_RobynHarrison() {
        String valid = "Create Login to authenticate user.";
        boolean result = checkTaskDescription(valid);
        assertTrue(result);
    }

    @Test
    public void checkTaskDescription_failure_RobynHarrison() {
        String valid = "Please enter a task description of  less than 50 characters ";
        boolean result = checkTaskDescription(valid);
        assertFalse(result);

    }

    public String createTaskId(String taskName, int taskNumber, String developerDetails) {
        String namePart = taskName.length() >= 2 ? developerDetails.substring(developerDetails.length() - 2).toUpperCase() : taskName.toUpperCase();
        String devPart = developerDetails.length() >= 3 ? developerDetails.substring(developerDetails.length() - 3).toUpperCase() : developerDetails.toUpperCase();
        return namePart + ":" + taskNumber + ":" + devPart;
    }

    /**
     * Test of createTaskId method, of class Task.
     */
    @Test
    public void testCreateTaskId_MikeSmith() {

        String Name = "Add task Feature";
        int Number = 1;
        String Details = "Mike Smith";
        String expResult = "AD:1:ITH";
        String result = createTaskId(Name, Number, Details);
        assertEquals(expResult, result);

    }

    @Test
    public void testCreateTaskId_RobynHarrison() {

        String Name = "Login Feature";
        int Number = 0;
        String Details = "Robyn Harrison";
        String expResult = "LO:0:SON";
        String result = createTaskId(Name, Number, Details);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.

    }

    public int returnTotalHours(int taskindex) {
        return taskDuration[taskindex];
    }

    @Test
    public void testReturnTotalHours() {
        taskDuration[0] = 10;
        taskDuration[1] = 12;
        taskDuration[2] = 55;
        taskDuration[3] = 11;
        taskDuration[4] = 1;

        numTasks = 5;
        int result = taskDuration[0] + taskDuration[1] + taskDuration[2] + taskDuration[3] + taskDuration[4];

        int TotalHours = returnTotalHours(result);
        assertEquals(result, TotalHours);
    }

}
