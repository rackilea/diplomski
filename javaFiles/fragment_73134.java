import com.google.appengine.api.taskqueue.Queue;
import com.google.appengine.api.taskqueue.QueueFactory;
import static com.google.appengine.api.taskqueue.TaskOptions.Builder.*;

        Queue downloadqueue = QueueFactory.getDefaultQueue();
        queue.add(withUrl("/worker").param("url", urlToFetch))