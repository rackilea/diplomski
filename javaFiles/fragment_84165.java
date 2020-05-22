docRef.getDocument { (document, error) in
if let document = document, document.exists {
    print(document.data()!)
    let userNotifications = document.data()["userNotifications"] as? [[String:Any]]
    for notificaton in userNotifications  {
        let body = notificaton["body"] as? String ?? ""
        let title = notificaton["title"] as? String ?? ""
        print(body, title)

    }

} else {
    print("Document does not exist")
}
}