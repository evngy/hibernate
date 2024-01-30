package models;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;


@Entity
@Table (name = "Users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String lastname;
    private String firstname;
    private int age;
    private String department;
    private String phone;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Task> tasks;

    public User(){
    }

    public User(String lastname, String firstname, int age, String department, String phone){
        this.lastname = lastname;
        this.firstname = firstname;
        this.age = age;
        this.department = department;
        this.phone = phone;
        tasks = new ArrayList<Task>();
    }

    public void addTask(Task task){
        task.setUser(this);
        tasks.add(task);
    }

    public void removeTask(Task task){
        tasks.remove(task);
    }

    public int getId(){
        return id;
    }

    public String getLastname(){
        return lastname;
    }

    public void setLastname(String lastname){
        this.lastname = lastname;
    }

    public String getFirstname(){
        return firstname;
    }

    public void setFirstname(String firstname){
        this.firstname = firstname;
    }

    public int getAge(){
        return age;
    }

    public void setAge(int age){
        this.age = age;
    }

    public String getDepartment(){
        return department;
    }

    public void setDepartment(String department){
        this.department = department;
    }

    public String getPhone(){
        return phone;
    }

    public void setPhone(String phone){
        this.phone = phone;
    }

    public List<Task> getTasks() {
        return tasks;
    }

    public void setTasks(List<Task> tasks) {
        this.tasks = tasks;
    }

    @Override
    public String toString(){
        return "models.User{" +
                "id=" + id +
                ", lastname'" + lastname + '\'' +
                ", firstname" + firstname +
                ", age=" + age +
                ", department=" + department +
                ", phone=" + phone +
                '}';
    }

}
