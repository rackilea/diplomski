if(Desktop.isDesktopSupported()){
    try {
        //Desktop.getDesktop().edit(new File("D:\\Users\\Name\\Desktop\\Book1.xlsx"));
        Desktop.getDesktop().open(new File("D:\\Users\\Name\\Desktop\\Book1.xlsx"));
    } catch (IOException e) {
        e.printStackTrace();
    } 
} else {
    System.out.println("Desktop is not supported");
}