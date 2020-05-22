FacebookType photo = fc.publish(pageid + "/photos" , FacebookType.class,
            BinaryAttachment.with(photoName, photoInputStream));
Link photoLink = fc.fetchObject(photo.getId(), Link.class);
FacebookType post =  fc.publish(pageid + "/feed", FacebookType.class,
            Parameter.with("message", "your message"),Parameter.with("type", "photo"),
            Parameter.with("link", photoLink.getLink()));