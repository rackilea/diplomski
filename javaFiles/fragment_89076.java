public static void main(String[] args) throws Exception {
    ObjectOutputStream tocStream = new ObjectOutputStream(new FileOutputStream("myfile.toc"));
    Map<Integer,Object> tableOfContent = new HashMap<Integer, Object>();
    String myString = "dataOne";
    Date myDate = new Date();
    tableOfContent.put(0,myDate);
    tableOfContent.put(1,myString);
    tocStream.writeObject(tableOfContent);
    tocStream.flush();
    tocStream.close();
    ObjectInputStream tocInputStream = new ObjectInputStream(new FileInputStream("myfile.toc"));
    Map<Integer,Object> restoredTableOfContent = (Map<Integer, Object>) tocInputStream.readObject();
    Object restoredMyString  =  restoredTableOfContent.get(1);
    System.out.println(restoredMyString);
    tocInputStream.close();
}