rs=st.executeQuery("select Username,Password from AllUsers");

        while(rs.next()){
            String compareUser=rs.getString(1);
            String comparePass=rs.getString(2);

            if(TheUser.equals(compareUser)||ThePass.equals(comparePass)){

                out.println("<p>You are logged in as " +compareUser+"</p>");
                rs.close();
                st.close();
                con.close();


            }
            else{

                out.println("<p>Wrong Combination</p>");
                out.println("</br><a href='log.html'>Login</a></p>");

                rs.close();
                st.close();
                con.close();
            }
        }    

        }catch(Exception e){
            e.printStackTrace();
        }