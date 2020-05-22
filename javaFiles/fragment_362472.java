import org.jetbrains.annotations.NotNull;

import java.util.StringJoiner;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;

public class Main {

    private static class MySchedulerInterface implements SchedulerInterface {
        private final ProfileRequest request;

        public MySchedulerInterface(ProfileRequest req1) {
            this.request = req1;
        }

        @Override
        public void onSuccess(String response) {
            System.out.println("onSuccess:[" + request + "]" + response);
        }

        @Override
        public void onFailure(Exception exception) {
            System.out.println("onFailure:[" + request + "]" + exception);
        }

        @Override
        public void onSchedulerStop(String uid) {
            System.out.println("onSchedulerStop:[" + request + "] - " + uid);
        }

        @Override
        public void onSchedulerStart(String uid) {
            System.out.println("onSchedulerStart:[" + request + "] - " + uid);
        }
    }

    public static void main(String[] args) throws InterruptedException {

        ApiInterface api = new ApiInterface();

        ProfileRequest req1 = new ProfileRequest("1", "apple");
        ProfileRequest req2 = new ProfileRequest("2", "orange");
        ProfileRequest req3 = new ProfileRequest("3", "peach");
        ProfileRequest req11 = new ProfileRequest("1", "pineapple");

        MyScheduler scheduler = new MyScheduler();
        scheduler.createScheduler(api, req1, new MySchedulerInterface(req1));
        scheduler.createScheduler(api, req2, new MySchedulerInterface(req2));
        scheduler.createScheduler(api, req3, new MySchedulerInterface(req3));

        System.out.println("Created 3 tasks");
        TimeUnit.SECONDS.sleep(2);
        System.out.println("Starting 3 tasks");
        scheduler.start("1");
        scheduler.start("2");
        scheduler.start("3");
        System.out.println("Started 3 tasks");

        TimeUnit.SECONDS.sleep(10);

        System.out.println("Replacing task 1...");
        scheduler.createScheduler(api, req11, new MySchedulerInterface(req11));
        System.out.println("Replaced task 1.");

        TimeUnit.SECONDS.sleep(10);
        System.out.println("Stopping 3 tasks...");
        scheduler.stop("1");
        scheduler.stop("2");
        scheduler.stop("3");
        System.out.println("The end.");
    }
}

class ProfileRequest {
    private final String uid;
    private final String value;

    public ProfileRequest(String uid, String value) {
        this.uid = uid;
        this.value = value;
    }

    public String getUid() {
        return uid;
    }

    public String getValue() {
        return value;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", ProfileRequest.class.getSimpleName() + "[", "]")
                .add("uid='" + uid + "'")
                .add("value='" + value + "'")
                .toString();
    }
}

class ApiInterface {
    public void createBookmark(ProfileRequest request, Callback<String> stringCallback) {
        stringCallback.onSuccess("SUCCESS: I'm done with " + request);
    }
}

interface SchedulerInterface {

    void onSuccess(String response);

    void onFailure(Exception exception);

    void onSchedulerStop(String uid);

    void onSchedulerStart(String uid);
}


interface Callback<T> {
    void onSuccess(@NotNull T response);

    void onFailure(@NotNull Exception exception);
}

class MyScheduler extends TaskScheduler {

    private final int DEFAULT_SCHEDULER_INTERVAL = 2; // seconds

    public MyScheduler() {
    }

    public void createScheduler(@NotNull ApiInterface apiInterface,
                                @NotNull ProfileRequest request,
                                @NotNull SchedulerInterface schedulerInterface) {
        super.setTask(new SchedulerRunnable(apiInterface, request, schedulerInterface), request.getUid(), DEFAULT_SCHEDULER_INTERVAL);
    }

    @Override
    public ScheduledTask doStart(@NotNull String uid) {
        final ScheduledTask task = super.doStart(uid);
        if (task != null) {
            final SchedulerRunnable runnable = (SchedulerRunnable) task.runnable;
            runnable.schedulerInterface.onSchedulerStart(uid);
        }
        return task;
    }

    @Override
    protected ScheduledTask doStop(@NotNull String uid) {
        final ScheduledTask task = super.doStop(uid);
        if (task != null) {
            final SchedulerRunnable runnable = (SchedulerRunnable) task.runnable;
            runnable.schedulerInterface.onSchedulerStop(uid);
        }
        return task;
    }

    private class SchedulerRunnable implements Runnable {

        private final ApiInterface apiInterface;
        private final ProfileRequest request;
        private final SchedulerInterface schedulerInterface;

        SchedulerRunnable(ApiInterface apiInterface, ProfileRequest request, SchedulerInterface schedulerInterface) {
            this.apiInterface = apiInterface;
            this.request = request;
            this.schedulerInterface = schedulerInterface;
        }

        @Override
        public void run() {
            apiInterface.createBookmark(request, new Callback<String>() {
                @Override
                public void onSuccess(@NotNull String response) {
                    schedulerInterface.onSuccess(response);
                }

                @Override
                public void onFailure(@NotNull Exception exception) {
                    schedulerInterface.onFailure(exception);
                }
            });
        }
    }
}


class SchedulerModel {
    ScheduledExecutorService executorService;
    Runnable runnable;
    int interval;
}


class TaskScheduler {

    static class ScheduledTask {
        String uid;
        Runnable runnable;
        int interval;
        ScheduledFuture<?> future;

        ScheduledTask(String uid, Runnable runnable, int interval, ScheduledFuture<?> future) {
            this.uid = uid;
            this.runnable = runnable;
            this.interval = interval;
            this.future = future;
        }

        void dispose() {
            if (future != null) {
                future.cancel(true);
            }
        }

        boolean isScheduled() {
            return future != null;
        }
    }

    private ConcurrentMap<String, ScheduledTask> scheduledTasks = new ConcurrentHashMap<>();
    private ScheduledExecutorService executor = Executors.newScheduledThreadPool(10);

    TaskScheduler() {
    }

    /**
     * Method is used to initialize scheduler task and time delays
     *
     * @param runnable Represents a command that can be executed
     * @param interval The time interval for execution of code
     */
    void setTask(Runnable runnable, String uid, int interval) {
        AtomicBoolean requiresRestart = new AtomicBoolean(false);
        final ScheduledTask task = scheduledTasks.compute(uid, (id, oldTask) -> {
            ScheduledTask newTask = new ScheduledTask(uid, runnable, interval, null);
            if (oldTask != null) {
                oldTask.dispose();
                requiresRestart.set(oldTask.isScheduled());
            }
            return newTask;
        });

        if (requiresRestart.get()) {
            start(uid);
        }
    }

    public void start(@NotNull String uid) {
        doStart(uid);
    }

    public void stop(@NotNull String uid) {
        doStop(uid);
    }

    protected ScheduledTask doStart(@NotNull String uid) {
        final ScheduledTask scheduledTask = scheduledTasks.computeIfPresent(uid, (id, oldTask) -> {
            ScheduledFuture<?> future = executor.scheduleWithFixedDelay(
                    oldTask.runnable, 0, oldTask.interval, TimeUnit.SECONDS);
            ScheduledTask newTask = new ScheduledTask(oldTask.uid, oldTask.runnable, oldTask.interval, future);
            return newTask;
        });
        return scheduledTask;
    }

    protected ScheduledTask doStop(@NotNull String uid) {
        final ScheduledTask task = scheduledTasks.remove(uid);
        task.dispose();
        return task;
    }


}