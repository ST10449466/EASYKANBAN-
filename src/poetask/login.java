package poetask;

import javax.swing.*;

public class login {
    Task taskobj = new Task();
    int option;
    String firstName;
    String lastName;
    String username = "";
    String password;
    String myUsername;
    String myPassword;

    public void menu() {
        while (option != 3) {
            option = Integer.parseInt(JOptionPane.showInputDialog("Please select one of the following options\n"
                    + "1. Register User\n"
                    + "2. Login\n"
                    + "3. Exit"));
            switch (option) {
                case 1:
                    JOptionPane.showMessageDialog(null, "Menu - Register");
                    registerUser();
                    break;
                case 2:
                    JOptionPane.showMessageDialog(null, "Menu - Login");
                    Login();
                    break;
                case 3:
                    JOptionPane.showMessageDialog(null, "Leaving so soon");
                    System.exit(0);
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Invalid option. Please enter a value from 1 - 3");
            }
        }
    }

    public void Login() {
        boolean loggedIn = false;
        while (!loggedIn) {
            myUsername = JOptionPane.showInputDialog("Please enter your username");
            myPassword = JOptionPane.showInputDialog("Please enter your password");
            loggedIn = loginUser(myUsername, myPassword);

            if (loggedIn) {
                // Display personalized welcome message upon successful login
                JOptionPane.showMessageDialog(null, "Login successful!\nWelcome back " + firstName + " " + lastName + ", it is great to see you again.");
                JOptionPane.showMessageDialog(null, "Welcome to EasyKanban!");

                boolean quit = false;
                ArrayReport report = new ArrayReport();
                
                while (!quit) {
                    // Prompt user for options after logging in                                              
                            
                    option = Integer.parseInt(JOptionPane.showInputDialog("Please select one of the following options:\n"
                                        + "1. Add Task\n"
                                        + "2. Display a task status with 'done'\n"
                                        + "3. Display the Longest Duration Task of the developer\n"
                                        + "4. Search for a task by task name, to diplay the Tasks's Name, Developer, Task Status\n"
                                        + "5. Search all tasks assigned to developer to display task name and task status\n"
                                        + "6. Delete a task by entering a task name\n"
                                        + "7. Show report of full detailed tasks\n"                           
                                        + "8. Quit"));
                    
                    switch (option) {
                        case 1:
                            taskobj.addTasks();
                            break;
                        case 2:                                                  
                            report.displayDoneTasks(); 
                            break;
                        case 3:
                            report.displayLongestTask();
                            //JOptionPane.showMessageDialog(null, "Exiting the application. Goodbye!");
                            break;         
                        case 4:
                            String searchName = JOptionPane.showInputDialog("Enter task name to search:");
                            report.searchByTaskName(searchName);
                            break;
                        case 5:
                            String searchDev = JOptionPane.showInputDialog(null,"Enter devloper name to search:" );
                            report.searchByTaskName(searchDev);
                            break;
                        case 6:
                            String deleteName = JOptionPane.showInputDialog("Enter task name to delete:");
                            report.deleteTask(deleteName);
                            break;
                        case 7: 
                            report.displayAllTasks();
                            break;
                        case 8:
                            JOptionPane.showMessageDialog(null, "Exiting...");
                            break;
                        default:
                            JOptionPane.showMessageDialog(null, "Invalid option. Please enter a value from 1 - 8");
                            break;
                    }
                }

        }
    }
    }
    public void registerUser() {
        firstName = JOptionPane.showInputDialog("Please enter your first name");
        lastName = JOptionPane.showInputDialog("Please enter your last name");
        username = JOptionPane.showInputDialog("Please enter your username");
        while (!checkUsername(username)) {
            JOptionPane.showMessageDialog(null, "Username must be 5 characters or less and contain '_'");
            username = JOptionPane.showInputDialog("Please re-enter your username");
        }

        password = JOptionPane.showInputDialog("Please enter your password");
        while (!checkPasswordComplexity(password)) {
            JOptionPane.showMessageDialog(null, "Password must be at least 8 characters with uppercase letters, numbers, and special characters.");
            password = JOptionPane.showInputDialog("Please re-enter your password");
        }
        JOptionPane.showMessageDialog(null, "Registration Successful");
    }

    public boolean loginUser(String inputUsername, String inputPassword) {
        return this.username.equals(inputUsername) && this.password.equals(inputPassword);
    }

    public boolean checkUsername(String username) {
        return username.length() <= 5 && username.contains("_");
    }

    public boolean checkPasswordComplexity(String password) {
        boolean capitalLetter = false;
        boolean digit = false;
        boolean specialCharacter = false;
        
        for (char c : password.toCharArray()) {
            if (Character.isUpperCase(c)) capitalLetter = true;
            else if (Character.isDigit(c)) digit = true;
            else if ("!@#$%^&*()_-+=<>~".contains(String.valueOf(c))) specialCharacter = true;
        }
        
        return password.length() >= 8 && capitalLetter && digit && specialCharacter;
    }
}
