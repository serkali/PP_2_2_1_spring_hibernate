package hiber;

import hiber.config.AppConfig;
import hiber.model.Car;
import hiber.model.User;
import hiber.service.UserService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.sql.SQLException;
import java.util.List;

public class MainApp {
    public static void main(String[] args) throws SQLException {
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(AppConfig.class);

        UserService userService = context.getBean(UserService.class);
        User userOne = new User("User2", "Lastname2", "user2@mail.ru");
        userOne.setCar(new Car("BMW", 5));
        User userTwo = new User("User3", "Lastname3", "user3@mail.ru");
        userTwo.setCar(new Car("Land Cruiser", 200));
        User userThree = new User("User4", "Lastname4", "user4@mail.ru");
        userThree.setCar(new Car("Mercedes", 600));
        userService.add(userOne);
        userService.add(userTwo);
        userService.add(userThree);
        List<User> users = userService.listUsers();
        for (User user : users) {
            System.out.println("Id = " + user.getId());
            System.out.println("First Name = " + user.getFirstName());
            System.out.println("Last Name = " + user.getLastName());
            System.out.println("Email = " + user.getEmail());
            System.out.println();
        }
        User user = userService.getUserAndCarsModelAndSeries("BMW", 5);
        System.out.println(user.getCar());


        context.close();
    }
}
