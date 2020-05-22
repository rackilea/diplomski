public static void show(long id)
    {
        Notification notification = Notification.findById(id);
        User connectedUser = User.find("byEmail", Security.connected()).first();

        if(notification.recipient.equals(connectedUser))
        {
            render(notification);
        }
        else
        {
            forbidden("This isnt your message stop hacking the urls!");     
        }
    }