import java.util.concurrent.atomic.AtomicLong;

import javax.management.Notification;

import org.springframework.jmx.export.annotation.ManagedOperation;
import org.springframework.jmx.export.annotation.ManagedResource;
import org.springframework.jmx.export.notification.NotificationPublisher;
import org.springframework.jmx.export.notification.NotificationPublisherAware;

@ManagedResource
public class JMXDemo implements NotificationPublisherAware {
    private final AtomicLong notificationSequence = new AtomicLong();
    private NotificationPublisher notificationPublisher;

    @Override
    public void setNotificationPublisher(
            final NotificationPublisher notificationPublisher) {
        this.notificationPublisher = notificationPublisher;
    }

    @ManagedOperation
    public void trigger() {
        if (notificationPublisher != null) {
            final Notification notification = new Notification("type",
                    getClass().getName(),
                    notificationSequence.getAndIncrement(), "The message");
            notificationPublisher.sendNotification(notification);
        }
    }
}