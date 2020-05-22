StringBuilder sb = new StringBuilder();
    int length = 0;
    for(…; …; …) {
        String s = … //calculateNextString();
        sb.append(s);
        length += utf8Length(s);
        if(length >= 5242880) {
            // Do something

            // in case you're flushing the data:
            sb.setLength(0);
            length = 0;
        }
    }