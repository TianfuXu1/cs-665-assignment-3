package edu.bu.met.cs665.example1;

public interface Observable {
    void addObserver(Observer observer);
    void removeObserver(Observer observer);
    void notifyObservers(Task task);
}
