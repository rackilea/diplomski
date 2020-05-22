while((line = reader.readLine()) != null){
    String str[] = line.split(",");
    if (str.size() > 1){
        System.out.println("Data 0: " + str[0]);
        System.out.println("Data 1: " + str[1]);
        hm.put(str[0], str[1]);
    }
}