package com.example.todo.model;

import android.app.Application;
import android.os.AsyncTask;

import androidx.lifecycle.LiveData;
import androidx.room.RoomDatabase;

import java.util.List;

public class TaskRepository {
    private final TaskDao mTaskDao;
    private final LiveData<List<Task>> mAllTasks;


    public TaskRepository(Application application) {
      TaskRoomDatabase db = TaskRoomDatabase.getDatabase(application);
        mTaskDao = db.taskDao();
        mAllTasks = mTaskDao.getAllTasks();
    }

    public LiveData<List<Task>> getAllTasks() {
        return mAllTasks;
    }

    public void deleteAll(){
        new deleteAllTasksAsyncTask(mTaskDao).execute();
    }
    public void insert(Task task) {
        new insertAsyncTask(mTaskDao).execute(task);
    }
    public void deleteTask(Task task){ new deleteTaskAsyncTask(mTaskDao).execute(task);}


    private static class insertAsyncTask extends AsyncTask<Task, Void, Void> {

        private final TaskDao mAsyncTaskDao;

        insertAsyncTask(TaskDao dao) {
            mAsyncTaskDao = dao;
        }

        @Override
        protected Void doInBackground(final Task... params) {
            mAsyncTaskDao.insert(params[0]);
            return null;
        }
    }

    private static class deleteAllTasksAsyncTask extends AsyncTask<Void, Void, Void> {
        private final TaskDao mAsyncTaskDao;

        deleteAllTasksAsyncTask(TaskDao dao) {
            mAsyncTaskDao = dao;
        }
        @Override
        protected Void doInBackground(Void... voids) {
            mAsyncTaskDao.deleteAll();
            return null;
        }
    }

    private static class deleteTaskAsyncTask extends AsyncTask<Task, Void, Void> {
        private final TaskDao mAsyncTaskDao;

        deleteTaskAsyncTask(TaskDao dao) {
            mAsyncTaskDao = dao;
        }

        @Override
        protected Void doInBackground(Task... tasks) {
            mAsyncTaskDao.deleteTask(tasks[0]);
            return null;
        }
    }
}
