package com.example.todo.views;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.todo.R;
import com.example.todo.model.Task;

import java.util.List;

public class TaskListAdapter extends RecyclerView.Adapter<TaskListAdapter.TaskViewHolder> {

    static class TaskViewHolder extends RecyclerView.ViewHolder {
        private final TextView taskItemView;

        private TaskViewHolder(View itemView) {
            super(itemView);
            taskItemView = itemView.findViewById(R.id.textView_title);
        }

    }
    private final LayoutInflater mInflater;
    private List<Task> mTasks; // Cached copy of tasks

    TaskListAdapter(Context context) { mInflater = LayoutInflater.from(context); }

    @Override
    public TaskViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = mInflater.inflate(R.layout.recyclerview_item, parent, false);
        return new TaskViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(TaskListAdapter.TaskViewHolder holder, int position) {
        if (mTasks != null) {
            Task current = mTasks.get(position);
            holder.taskItemView.setText(current.getTask());
        } else {
            // Covers the case of data not being ready yet.
            holder.taskItemView.setText("No Task");
        }
    }

    void setTasks(List<Task> tasks){
        mTasks = tasks;
        notifyDataSetChanged();
    }

    // getItemCount() is called many times, and when it is first called,
    // mTasks has not been updated (means initially, it's null, and we can't return null).
    @Override
    public int getItemCount() {
        if (mTasks != null)
            return mTasks.size();
        else return 0;
    }

    public Task getTaskAtPosition (int position){
        return mTasks.get(position);
    }


}
