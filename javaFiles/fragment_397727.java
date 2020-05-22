while (answer.hasMoreElements())
   {
        SearchResult sr = (SearchResult)answer.next();

        System.out.println("user name" + sr.getName());
        Attributes attrs = sr.getAttributes();
        System.out.println("email" + attrs.get("mail"));
   }