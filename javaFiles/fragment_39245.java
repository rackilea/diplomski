public class Parent {
     private int id;
     private int row;
     public Parent(int id,int row) {
        this.id=id;
        this.row=row
     }

     public int getId() {
         return id;
     }

     public int getRow() {
         return row;
     }
}

public class Son extends Parent {
    public Son(int id,int row) {
        super(id,son);
    }

    public Son(Parent p) {
        super(p.getId(), p.getRow());
    }
}