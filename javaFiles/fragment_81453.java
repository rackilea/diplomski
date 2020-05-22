while(rs.next()){
    if(dosageTime.equalsIgnoreCase("morning")){
        if(rs.getInt("morningtaken")==0){
            //...

            // You never create a new "data" object...
            // setting the information
            data.setElderBed(rs.getInt("bed"));
            data.setElderName(rs.getString("name"));
            data.setElderAge(ElderData.getAge(year,month,day));
            data.setElderGender(rs.getString("gender"));
            DosageList.add(data);   
            numofElder++;
        }
    }