import models.Task;
import models.User;
import services.UserService;

import java.sql.SQLException;

public class Main {
    public static void main(String[] args) throws SQLException{
        UserService userService = new UserService();
        User user = new User("User1_Lastname", "User1_Firstname", 25, "MainDep", "2-222-222");
        userService.saveUser(user);

        Task task1 = new Task("Test#1", "Write Module Test", 2, "01-02-2024");
        task1.setUser(user);
        user.addTask(task1);

        Task task2 = new Task("Test#2", "Write Integration Test", 3, "03-02-2024");
        task2.setUser(user);
        user.addTask(task2);

        userService.updateUser(user);
    }


}
