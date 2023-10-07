package edu.bu.met.cs665.example1;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TaskScheduler {
    private List<Task> tasks;
    private Map<Task, User> taskAssignments;

    public TaskScheduler() {
        tasks = new ArrayList<>();
        taskAssignments = new HashMap<>();
    }

    public void createTask(int id ,String name, String description) {
        Task task = new Task(id ,name, description);
        tasks.add(task);
    }

    public void assignTaskToUser(Task task, User user) {
        if (tasks.contains(task)) {
            taskAssignments.put(task, user);
        }
    }

    public void cancelTask(Task task) {
        tasks.remove(task);
        taskAssignments.remove(task);
    }

    public void showAllWithUsers() {
        for (Task task : tasks) {
            User user = taskAssignments.get(task);
            String assignedTo = (user != null) ? user.getUsername() : "Unassigned";
            System.out.println("Task: " + task.getName() + " | Description: " + task.getDescription() + " | Assigned to: " + assignedTo);
        }
    }

    public Task getTaskById(int taskId) {
        for (Task task : tasks) {
            // Assuming each task has a unique ID (you may need to modify this condition)
            if (task.getId() == taskId) {
                return task;
            }
        }
        return null; // Task not found
    }
}
