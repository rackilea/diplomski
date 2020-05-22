public class GetStuff {
    public GetStuff(String data) {
        System.out.println(data);
    }
}

public class GetSecondStuff extends GetStuff {
    private int newData;

    public GetSecondStuff(String data, int newData) {
        super(data);
        this.newData = newData;


        data = "GetSecondStuff";        
        System.out.println(data);

        System.out.println(getAllMyStuffMethod());

    }

    private String getAllMyStuffMethod() {
        String ret=null;
          if (this.newData==0)
              ret="0";
          else
              ret="1";

        return "new data : "+ret;
    }
}

public class main {

    public static void main(String[] args) {        

        GetSecondStuff gf2 = new GetSecondStuff("GetStuff",1);      
    }

}