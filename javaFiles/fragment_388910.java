r1=s1.executeQuery("select duration from tests where testname="+ts+"");    
       //if should be enough as you will only have 0 or 1 row per test? 
       if(r1.next())  
        {  
            time=r1.getString("duration");  
            t=Integer.parseInt(time)*60000;           
        }  else{
           logger.warn("No row found in db for test " + ts);
           //okay for debug
           out.println("<br>!! <b>No row found in db </b>for test " + ts + "<br><br><br>");  
        }
        r1.close();  
    }  
    catch(Exception e1)  
    {  
        response.setContentType("text/html");  
        out.println("<br><br> <b> ERROR</b>" + e1.toString());  
    }