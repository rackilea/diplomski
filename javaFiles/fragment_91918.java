BasicDBObject doc = new BasicDBObject("title", "MongoDB").
            append("description", "database").
            append("likes", 100).
            append("url", "http://www.instagram.com/").
            append("by", "users").
            append("instagram", new BasicDBObject("description","database").append("likes", "likes"));