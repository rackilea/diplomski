List<DataObject> list = new ArrayList<DataObject>();

while (dealerRS.next()) {
        DataObject obj = new DataObject();
        obj.setDealerID(dealerRS.getInt("DealerID"));
        obj.setStandardID(dealerRS.getInt("StandardID"));
        obj.setAchieved(dealerRS.getString("Achieved"));
        obj.setNSCWaiver(dealerRS.getString("NSC_Waiver"));
        obj.setOverride(dealerRS.getString("Override"));
        obj.setQuarter(dealerRS.getInt("Quarter"));
        obj.setYear(dealerRS.getInt("Year"));
        list.add(obj);
 }