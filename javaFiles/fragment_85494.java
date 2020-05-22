import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.util.Iterator;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;



public class SelectPP {


    public static void main(String[] args) {

        Session session = null;
        //String query = "select example.id, example.data from Example example";
        CallableStatement callableStatement = null;
        ResultSet resultSet = null;

        try{

            SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
            session = sessionFactory.openSession();

            System.out.println("selecting records");
    //      Query q = session.getNamedQuery("getRecordsSP");
    //      Query q =  session.createSQLQuery("call getRecords","",Example.class);
    //      Query q = session.getNamedQuery("getRecordsSP");

            callableStatement = session.connection().prepareCall("{call getRecords}");
            callableStatement.execute();

            resultSet = callableStatement.getResultSet();

            while(resultSet.next()){
                System.out.println(resultSet.getInt(1));
                System.out.println(resultSet.getString(2));
            }

            //resultSet.

            System.out.print("Done");
            //List l = q.list();


        //  for(Iterator it = l.iterator() ;it.hasNext();){
        //      Object row [] = (Object []) it.next();

        //      Example row = (Example) it.next();
        //      System.out.println(row.getUser_id());
        //      System.out.println(row.getUser_data());
        //      System.out.println(row.length);
        //      System.out.println("ID " + row[0]);
        //  System.out.println("Data "+ row[1]);

        }
        catch (Exception e) {
            e.printStackTrace();
        }
        finally{
            session.flush();
            session.close();
        }
    }
}