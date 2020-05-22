ParseQuery<ParseObject> userQuery = ParseQuery.getQuery("_User");
        userQuery.whereEqualTo("objectId", currentUser.getObjectId());
        try {
            List<ParseObject> userList = userQuery.find();
            for (ParseObject author : userList) {

                sentRequest.put("author", author);
                try {
                    sentRequest.save();
                } catch (org.parse4j.ParseException e) {
                    e.printStackTrace();
                }

            }
        } catch (org.parse4j.ParseException e) {
            e.printStackTrace();
        }