@Scheduled(fixedDelayString = "300000")
@TryLock(name = "flowerNotification", owner = POD_NAME, lockFor = THREE_MINUTES)
public void sendFlowerNotifications() {
  List<Notification> notifications = notificationService.getNotifications();
  for(Notification notification: notifications){
    sendNotification(notification);
  }
}