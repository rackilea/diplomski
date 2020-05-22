public static void main(String[] args) {
    System.out.println("program started.");

    Controller c;
    try {
       Model m = new Model();
       View v = new View();
       c = new Controller(m,v);
       c.sendDataToView();
       c.showView();
    }catch(Exception ex) {
        System.out.println("error");
    }
}