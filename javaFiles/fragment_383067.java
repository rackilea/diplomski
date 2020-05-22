List<Notification> notExpiredList = Notification.findAllNotExpired();

// check in terminal
for (Notification notification : notExpiredList) {
    Logger.info("This Notification IS NOT expired: " + notification.title);
}

List<Notification> expiredList = Notification.findAllExpired();

// check in terminal
for (Notification notification : expiredList) {
    Logger.warn("This Notification IS expired: " + notification.title);
}