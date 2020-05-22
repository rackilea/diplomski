FindItemResponse response = null;
        try {
            response = service.findItem(StandardFolder.INBOX, MessagePropertyPath.getAllPropertyPaths(), unReadMessages);
            for(Item item : response.getItems()) {
                if(item instanceof Message) {
                    Message message = (Message)item;