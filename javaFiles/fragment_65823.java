UILocalNotification notification = new UILocalNotification();
notification.setAlertTitle("title");
notification.setAlertBody("text");

NSMutableDictionary<NSObject, NSObject> dict = new NSMutableDictionary<>();
//add any customer stuff to your dictionary here
notification.setUserInfo(dict);
notification.setFireDate(new NSDate(date));         //date is some date in the future. Make sure it is in the correct TZ. If it does not work, try to make it at least 5 minutes in the future. I remember this helping my situation
notification.setTimeZone(NSTimeZone.getLocalTimeZone());
UIApplication.getSharedApplication().scheduleLocalNotification(notification);