public class Service{ 
    private Dao dao;

    public Service(Dao dao){
        this.dao = dao;
    }

    public void mainMethod(){
        dao.step1();
        subMethod();
        dao.step2();
    }

    public void subMethod(){
       //...
    }
}