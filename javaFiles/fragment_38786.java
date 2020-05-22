function messageReceived(payload) {    
  var notificationOptions = {
    body: payload.notification.body,
    icon: payload.notification.icon,
    click_action: payload.notification.click_action
  };
  new Notification(payload.notification.title, notificationOptions);
}