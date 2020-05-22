import com.example.client.Mac;
  import com.example.client.compMac;


  public class DbConnect {

private Connection con;

public DbConnect(){

    try{
        Class.forName("com.mysql.jdbc.Driver").newInstance();
        con = DriverManager.getConnection("jdbc:mysql://melucio.no-ip.biz:3306/TOC","XXXXX","XXXXXXX");


    }catch(Exception ex){
        System.out.println("Error: "+ex);
    }
}






/*This method returns the x coor. of mac address*/
    public String getCoorX(String mac){
    String cX = "";
    try{
        String query = "SELECT * FROM coordinate";
        Statement st = con.createStatement();
        ResultSet rs = st.executeQuery(query);
        while(rs.next()){
            if(rs.getString("mac").equals(mac)){
                return rs.getString("coorX");
            }
        }
        rs.close();
        st.close();
    }
    catch(Exception e){}

    return cX;

}

    /*This method returns the y coor. of mac address*/
    public String getCoorY(String mac){
    String cY = "";
    try{
        String query = "SELECT * FROM coordinate";
        Statement st = con.createStatement();
        ResultSet rs = st.executeQuery(query);
        while(rs.next()){
            if(rs.getString("mac").equals(mac)){
                return rs.getString("coorY");
            }
        }
        rs.close();
        st.close();

    }
    catch(Exception e){}
    return cY;

}   public String getBuilding(String mac){
        String buil = "";
        try{
            String query = "SELECT * FROM coordinate";
            Statement st = con.createStatement();
        ResultSet rs = st.executeQuery(query);
            while(rs.next()){
                if(rs.getString("mac").equals(mac)){
                    return rs.getString("building");
                }
            }
        rs.close();
        st.close();

        }
        catch(Exception e){}
        return buil;

    }

    public String getFloor(String mac){
        String fl = "";
        try{
            String query = "SELECT * FROM coordinate";
            Statement st = con.createStatement();
        ResultSet rs = st.executeQuery(query);
            while(rs.next()){
                if(rs.getString("mac").equals(mac)){
                    return rs.getString("floor");
                }
            }
        rs.close();
        st.close();
      }
        catch(Exception e){}
        return fl;

    }



/*Update the location table*/
public void updateLocation(String userNN,String location){//,long time){

    long time = System.currentTimeMillis();
    if(!isOnline(userNN))
    {System.out.println("not online");
        setOnline(userNN,location);}
    else{
        try{
            //String query ="UPDATE online SET location = '" +location +"' WHERE nickname='" +userNN +"'";
            String query ="UPDATE online SET location = '" +location +"', lastSeen = "+time +"  WHERE nickname='" +userNN +"'";

            st.executeUpdate(query);

        }   
        catch(Exception e){System.out.println("ayayaya");}  
    }
}


public LinkedList<compMac> getArray()
{
    LinkedList<compMac> locArray = new LinkedList<compMac>();
    try{
        String query = "SELECT * FROM online";
        Statement st = con.createStatement();
        ResultSet rs = st.executeQuery(query);
        while(rs.next()){
            String nn = rs.getString("nickname");
            String loc = rs.getString("location");//mac addresses
            String cX=getCoorX(loc);
            String cY=getCoorY(loc);
            String building=getBuilding(loc);
            String floor=getFloor(loc);

            locArray.add(new compMac(nn,loc,cX,cY,building,floor));

            }
        rs.close();
        st.close();
  }
    catch(Exception e){e.printStackTrace();}
    return locArray;

}

public void clean()
{
    long currentTime = System.currentTimeMillis();
    long acceptableTime = currentTime-120000;
    try{
        String query = "SELECT * FROM online";
        Statement st = con.createStatement(); 
       ResultSet rs = st.executeQuery(query);
        while(rs.next()){
            String nn = rs.getString("nickname");
            Long ls = rs.getLong("lastSeen");
            if(ls<acceptableTime)//{}
            {stClean.executeUpdate("DELETE FROM online WHERE     nickname='"+nn+"'");} 

        }
    }
    catch(Exception e){e.printStackTrace();}

}