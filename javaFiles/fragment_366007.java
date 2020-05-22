public double calRoomCharges(int cusId)
{
    String totRoom = "";
    double totalCharge = 0.0;

    try
    {
        //Get Rates
        String sql="SELECT nights FROM reservation where cus_id ='"+cusId+"'";
        pst=conn.prepareStatement(sql);
        rs=pst.executeQuery();
        int roomRates = 0;
            if(!rs.next())
            {
                //handle no result
            } 
            else 
            {
                roomRates = rs.getInt("nights") ;
                totalCharge = roomRates; // calculate total charge
                String totRoom = String.valueOf(totalCharge);
                rc.setText(totRoom);

            }

    }
    catch(Exception e){
        System.out.prtintln(e.getMessage());
    }

    return totalCharge;
 }