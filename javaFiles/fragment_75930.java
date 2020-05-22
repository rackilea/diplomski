for (String line : lines) {
        if (line.lenght == 0) 
            continue;
        String[] array = line.split(",");
        System.out.println(array[0]+","+array[1]);
    }