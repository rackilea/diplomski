for (String e : images){
        String temp = e.replaceFirst(strSeparator, "");
        String temp1 = temp.replace(strSeparator, ", ");
        String temp2 = temp1.replace(System.getProperty("line.separator"), "");
        System.out.println("IMAGES are: " + temp2);
    }