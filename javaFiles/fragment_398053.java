try{

        //FileWriting
        File file = new File(date+".txt");
        writer = new FileWriter(file,append);
        writer.write("Tid: "+timeStamp+"\r\n");
        writer.write("\r\n");
        writer.write(title.getText().replaceAll("(.{50}[^ ]+)\\s+", "$1\r\n")+"\r\n");
        writer.write("\r\n");

        writer.write(area.getText().replaceAll("(.{50}[^ ]+)\\s+", "$1\r\n")+"\r\n");
        writer.write("\r\n");
        writer.write("\r\n");
        writer.close();

    }