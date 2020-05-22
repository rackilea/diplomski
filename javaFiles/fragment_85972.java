StringBuilder builder = new StringBuilder;
    while(reader.ready()){
        builder.append(reader.readLine());
        builder.append("\n");
    }
    String oldtext = builder.toString();