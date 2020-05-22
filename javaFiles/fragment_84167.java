docRef.getDocument { (document, error) in
if let document = document, document.exists {
print(document.data()!)
let userNotifications = document.data()?["userNotifications"] as? [[String:Any]]
for data in userNotifications! {
            self.allNotifications.append(usernotifications(notificationData: data))
        }
print(self.allNotifications)

  } else {
print("Document does not exist")
 }
}