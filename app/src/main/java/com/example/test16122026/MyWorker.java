package com.example.test16122026;

import android.content.Context;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.work.Data;
import androidx.work.Worker;
import androidx.work.WorkerParameters;

public class MyWorker extends Worker {
    public final String TAG = "MyWorker";

    public MyWorker(@NonNull Context context, @NonNull WorkerParameters workerParams) {
        super(context, workerParams);
    }

    @NonNull
    @Override
    public Result doWork() {
        String s = getInputData().getString("keyA");
        int i = getInputData().getInt("keyB", 0);

        Log.v(TAG, "Work is in progress");
        Log.v(TAG, "Int " + i + " and String " + s);
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        Data output = new Data.Builder()
                .putString("keyC", "Hello")
                .putInt("keyD", 10)
                .build();

        Log.v(TAG, "Work finished");
        return Worker.Result.success(output);
    }
}