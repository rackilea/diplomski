public List<Notification> getNotificationByTime(long notificationTime) {

    return mongoTemplate.find(new Query(Criteria.where("createdAt").lte(notificationTime),
        Criteria.where("updatedAt").lte(notificationTime)),Criteria.where("failureTime").gt(3)
            ), Notification.class);
  }