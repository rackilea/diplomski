public static String getFormatStringFromListWitoutLastSeparator(List<String> someList) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < someList.size(); i++) {
            sb.append(someList.get(i));
            if(i < someList.size() -1) {
                 sb.append(";");
            }
        }

        return sb.toString();
        //0 item;1 item;2 item;3 item;4 item
        /*
           someList[0] = 0 item
           someList[1] = ;
           someList[2] = 1 item
           someList[3] = ;
           {etc..}
        */
    }