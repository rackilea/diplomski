String[] tags = new String[2];
    tags[0] = "bob";
    tags[1] = "hank";

    String query = "SELECT * FROM Subject";

    if (tags != null && tags.length>0) {
        for(int i = 0;i<tags.length;i++){
            query = query + " WHERE Tag like '%" + tags[i] + "%'";
        }
    }

    System.out.println(query);