SOAPMessage response = connection.call(requestMessage, serviceURL);
    Iterator attachmentsIterator = response.getAttachments();
    while (attachmentsIterator.hasNext()) {
        AttachmentPart attachment = (AttachmentPart) attachmentsIterator.next();
        //do something with attachment 
    }