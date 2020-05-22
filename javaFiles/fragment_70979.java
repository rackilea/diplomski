try (FileWriter fw = new FileWriter("D:\\Servicelog.txt", true) ) {
    java.util.Date date = new java.util.Date();
    fw.write(new Timestamp(date.getTime()) + "\n");
    fw.write(message + "\n");
    fw.write("schemaBegins\n" + schemaString + "\n" + "schemaEnds");
} catch (Exception e) {
    e.printStackTrace();
}