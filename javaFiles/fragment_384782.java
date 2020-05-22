import java.sql.PreparedStatement;
import java.sql.ResultSet;


public class User{

    private String      id;
    private String      name;
    private String      mail;

    private static String db_table = "db_user";
    public User(String id, String name, String mail) {
        this.id = id;
        this.name = name;
        this.mail = mail;
    }
    public boolean doUpdate(boolean commit, boolean close){     
        try {           
            DBM dbm = new DBM();
            User.clientUpdate(dbm, this, close, commit);
            return true;
        } catch (Exception e) {
            return false;
        }
    }


    public static User getById(DBM dbm, String id, boolean close) throws Exception{
        User o                 = null;
        PreparedStatement preState = null;
        ResultSet resultSet        = null;
        try {
            String sql = "SELECT * FROM "+db_table+" WHERE _ID=?";
            preState   = dbm.initConnection().prepareStatement(sql); 
            preState.setString(1, id);
            resultSet  = preState.executeQuery();
            while (resultSet.next()) {
            // the numbers 1 means the first column in your db tableshould be in my case here the id
           // 2 means the second col is the name ...etc, change this to me
                o = new User(resultSet.getString(1),resultSet.getString(2),resultSet.getString(3));
            }
        }catch (Exception e) {
            e.printStackTrace();
        }finally{
            if( preState != null )
                preState.close();
            if( close && dbm.connection != null )
                dbm.connection.close();         
        }
        return o;
    }

    public static boolean clientUpdate(DBM dbm, User o, boolean close, boolean commit) throws Exception{        
        boolean returnValue = true;
        PreparedStatement preState = null;
        try {
            User dbo = getById(dbm,o.getId(), false);           
            if(dbo==null){
                String sql = null;
               // 1st ? is the fisrt db table col  = 1 in setString(2)
               // 2nd ? is the secone db table col = 2 ...etc


                sql = "INSERT INTO "+db_table+" VALUES(?,?,?)";
                preState = dbm.initConnection().prepareStatement(sql); 
                preState.setString(1, o.getId());
                preState.setString(2, o.getName());
                preState.setString(3, o.getMail());
                preState.executeUpdate();
            }else{              
                String sql = null;
                sql = "UPDATE  "+db_table+" set _NAME=?,_MAIL=?  WHERE _ID=?";
                preState = dbm.initConnection().prepareStatement(sql); 
                      // 1 = first ?, 2 = second ? , ...etc
                preState.setString(1, o.getName());
                preState.setString(2, o.getMail());
                preState.setString(3, o.getId());
                preState.executeUpdate();
            }
        }catch (Exception e) {
            returnValue = false; 
            e.printStackTrace();
        }finally{
            if( preState != null )
                preState.close();
            if( dbm.connection != null ){
                if( commit ){
                    if( returnValue )
                        dbm.connection.commit();
                    else
                        dbm.connection.rollback();
                }
                if( close )
                    dbm.connection.close();
            }
        }
        return returnValue;
    }



    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getMail() {
        return mail;
    }
    public void setMail(String mail) {
        this.mail = mail;
    }

    @Override
    public String toString(){
        return this.getName();
    }

}