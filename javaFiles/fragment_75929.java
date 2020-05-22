for (String line : lines) {
        String[] array = line.split(",");
        if (array.length == 0) 
            continue;
        System.out.println(array[0]+","+array[1]);
    }