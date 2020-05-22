public class MyClass{
    private MyObject svc;
    private MyObject2 svc2;

    public MyClass(MyObject svc, MyObject2 svc2){
        this.svc = svc;
        this.svc2 = svc2;
        //this.svc2 = new MyObject2(svc); // <-- remove implementation details
    }

    public void getSvc(){
        Result response = this.svc.getResponse();
        if(!response.isEmpty())
             this.svc2.filterResponse(response);
        else
            System.out.println("empty");
    }
}