public void storeInsuranceInformationToDataBase(int patientId) throws SQLException
{
    //It gives arrayList of isuranceIds which are already in the data base.
    ArrayList<Integer> insuranceIdsListInDatabase = getInsuranceIdsListInDatabase();  

    //It returns HashMap of insurance ids for given patient id. 
    HashMap<Integer, InsuranceInfo> insuranceMap = getInsuranceDetails(patientId);   
    Map<Integer, InsuranceInfo> tempInsuranceMap = new HashMap<>();
    Set<Integer> insuranceIdsInHashMap = insuranceMap.keySet();

    //Here I am getting ConcurrentModificationException
    for (int insuranceIdInHashMap : insuranceIdsInHashMap)
    {
        //Here I am comparing the both ids..
        if (insuranceIdsListInDatabase.contains(insuranceIdInHashMap))  
        {
            String updateInsuranceQuery = "UPDATE jp_InsuranceInfo SET  typeOfPolicy='" + insuranceMap.get(insuranceIdInHashMap).getTypeOfPolicy() + "', amount=" + insuranceMap.get(insuranceIdInHashMap).getAmount() + ", duration=" + insuranceMap.get(insuranceIdInHashMap).getDuration()
                    + ", companyName='" + insuranceMap.get(insuranceIdInHashMap).getCompanyName() + "' WHERE insuranceId=" + insuranceIdInHashMap + ";";

            getDataBase().getStatement().executeUpdate(updateInsuranceQuery);
        }
        else
        {
            String insertInsuranceQuery = "INSERT INTO jp_InsuranceInfo VALUES(" + insuranceMap.get(insuranceIdInHashMap).getPatientId() + ",'" + insuranceMap.get(insuranceIdInHashMap).getTypeOfPolicy() + "'," + insuranceMap.get(insuranceIdInHashMap).getAmount() + ","
                    + insuranceMap.get(insuranceIdInHashMap).getDuration() + ",'" + insuranceMap.get(insuranceIdInHashMap).getCompanyName() + "')";

            getDataBase().getStatement().executeUpdate(insertInsuranceQuery);

            ResultSet generatedInsuranceId = getDataBase().getStatement().executeQuery("SELECT SCOPE_IDENTITY()");
            int newInsuranceId = 0;
            if (generatedInsuranceId.next())
            {
                newInsuranceId = generatedInsuranceId.getInt(1);
            }

            //Here it returns an insurance object which contains insurance details
            InsuranceInfo insuranceObject = insuranceMap.get(insuranceIdInHashMap); 
            insuranceObject.setInsuranceId(newInsuranceId);
            //Here I am trying to store the newly inserted insurance object into main hashmap
            storeInsuranceInfoToHashMap(patientId, insuranceObject); <-- make this function to save those information into the temporary map

            //I am removing previous insurance object with temporary insurance id
            getInsuranceMap().get(patientId).remove(insuranceIdInHashMap);

            // Adding newly generated insurance id to array list
            getInsuranceIdsListInDatabase().add(newInsuranceId);
        }
    }
    insuranceMap.putAll(tempInsuranceMap);
}