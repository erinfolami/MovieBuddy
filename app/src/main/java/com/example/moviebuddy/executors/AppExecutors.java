package com.example.moviebuddy.executors;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;

public class AppExecutors {

    //This class will be Implementing the Singleton Pattern
    // so that the class can have only one instance  of the executor object, to prevent: memory leak,optimize memory resource etc

    //An object that executes submitted Runnable tasks.
    //Executor is normally used instead of explicitly creating threads.

    private static AppExecutors instance;

    private final ScheduledExecutorService mNetworkIo = Executors.newScheduledThreadPool(3);

    private AppExecutors(){

    }

    public static AppExecutors getInstance() {
        if (instance == null) {
            instance = new AppExecutors();
        }
        return instance;
    }

    public ScheduledExecutorService NetworkIo(){
        return mNetworkIo;
    }


    


}
