public class MBeanEventListener implements NotificationListener {
    public void handleNotification(Notification notification, Object handback) {
        MBeanServerNotification mbs = (MBeanServerNotification) notification;
        if(MBeanServerNotification.REGISTRATION_NOTIFICATION.equals(mbs.getType())) {
            log("MBean Registered [" + mbs.getMBeanName() + "]");
        } else if(MBeanServerNotification.UNREGISTRATION_NOTIFICATION.equals(mbs.getType())) {
            log("MBean Unregistered [" + mbs.getMBeanName() + "]");
        }
    }       
}