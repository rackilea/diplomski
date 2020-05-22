for (int i = 1; i < 3095; i++) {
        if ((i-1) % 13 == 0) {
            System.out.println();
        }
        System.out.println("INSERT INTO categories (categories_id, parent_id) " +
                           "VALUES ('" + i + "' , '" + (i - ((i-1) % 13)) + "')");
    }