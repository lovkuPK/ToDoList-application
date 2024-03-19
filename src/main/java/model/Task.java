package model;

//The description of the class is listed below:
public class Task {
    private final int id;
    private final String description;
    private boolean completed;

    //Constructor of the class
    public Task (int id, String description){
        this.id = id;
        this.description = description;
        this.completed = false;
    }
    //Method, that returns the id of the task
    public int getId(){
        return id;
    }
    //Method, that makes the task status as completed
    public void setCompleted(boolean completed){
        this.completed = completed;
    }

    @Override
    public String toString() {
        return "Task{" +
                "id=" + id +
                ", description='" + description + '\'' +
                ", completed=" + completed +
                '}';
    }
}
