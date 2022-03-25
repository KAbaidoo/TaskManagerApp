package com.example.todo.viewmodel;

import android.app.Application;

import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.example.todo.model.Task;
import com.example.todo.model.TaskRepository;


import java.util.List;

public class TaskViewModel extends AndroidViewModel {
    private TaskRepository mRepository;
    private LiveData<List<Task>> mAllTasks;

    public TaskViewModel (Application application) {
        super(application);
        mRepository = new TaskRepository(application);
        mAllTasks = mRepository.getAllTasks();
    }

    public LiveData<List<Task>> getAllTasks() { return mAllTasks; }
    public void insert(Task task) { mRepository.insert(task); }
    public void deleteAll() {mRepository.deleteAll();}
    public void deleteTask (Task task){ mRepository.deleteTask(task);}

}
