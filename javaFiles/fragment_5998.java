public void HeadToHead(){
        String hometeam,awayteam,result;
        int hometeamvalue,awayteamvalue;
          List<SeasonResults> allResults = new ArrayList<SeasonResults>();

        try 
        {
            //Sets up the connedtion to the database and installs drivers which are required.
            Class.forName("com.mysql.jdbc.Driver");                                                                        
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost", "username", "password");        

            String SQL = "SELECT * FROM PreviousSeasons WHERE HomeTeam=? and AwayTeam=?";
            PreparedStatement prepst;            

             prepst =  con.prepareStatement(SQL);
            prepst.setString(1,box1.getSelectedItem().toString());
            prepst.setString(2,box2.getSelectedItem().toString());
            ResultSet rs = prepst.executeQuery();

            SeasonResults seasonResults=null;
            while (rs.next()) 
            {

                //This retrieves each row of League table and adds it to an array in the League Results class.

                hometeam = rs.getString("HomeTeam");
                awayteam = rs.getString("AwayTeam");                    
                result = rs.getString("Result");                    

                seasonResults=new  SeasonResults( hometeam,  awayteam,  result) ;
                custs = (hometeam + "," + awayteam + "," + result);     // Takes all the variables containging a single customers information and puts it into a string, seperated by commas.
                allResults.add(seasonResults);
            }
        }
        catch (Exception e) 
        {
            System.out.println("Error " +e);                                                                               
        }

        System.out.println("SIze of ArrayList::"+allResults.size());
        for(SeasonResults temp:allResults)
        {
               if(temp.getResult().equals("HW")){
                    hometeamvalue = hometeamvalue + 50;
                }  
                else if(temp.getResult().equals("D")){
                    hometeamvalue = hometeamvalue + 10;
                    awayteamvalue = awayteamvalue + 10;
                }
                else{
                    if(temp.getResult().equals("AW")){
                        awayteamvalue = awayteamvalue + 50;
                    }
                }

        }

    }