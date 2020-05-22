String json = "[{\"subscriptiontypecode\":\"ELEC\",\"subscriptiontypename\":\"Electricity Billing\",\"billgroupcode\":\"ELEC\",\"billgroupname\":\"Default\",\"billcyclecode\":\"201308\",\"billcyclename\":\"August,2013\",\"unitcode\":\"VGU0000100\",\"unitname\":\"T1/001\",\"totalcharge\":\"2809.00\",\"charge_DHBVNENERGY\":\"1720.00\",\"charge_DGENERGY\":\"233.00\",\"charge_DHBVNMMC\":\"0.00\",\"charge_CAECHARGES\":\"856.00\",\"charge_INTEREST\":\"0.00\",\"charge_ARREARS\":\"0.00\"},{\"subscriptiontypecode\":\"ELEC\",\"subscriptiontypename\":\"Electricity Billing\",\"billgroupcode\":\"ELEC\",\"billgroupname\":\"Default\",\"billcyclecode\":\"201307\",\"billcyclename\":\"July,2013\",\"unitcode\":\"VGU0000100\",\"unitname\":\"T1/001\",\"totalcharge\":\"2566.00\",\"charge_DHBVNENERGY\":\"1699.00\",\"charge_DGENERGY\":\"274.00\",\"charge_DHBVNMMC\":\"0.00\",\"charge_CAECHARGES\":\"593.00\",\"charge_INTEREST\":\"0.00\",\"charge_ARREARS\":\"0.00\"}]\n";


   JSONArray jsonArray =  JSONArray.fromObject( json);
   Collection<Map<String,String>> collection = JSONArray.toCollection(jsonArray, HashMap.class);                          
   for (Iterator iterator = collection.iterator(); iterator.hasNext();) {
          Map<String, String> mapObject = (Map<String,String>) iterator.next();
          System.out.println("------------Starting one record------");
          System.out.println("--------------------------------------");
          for (Map.Entry<String, String> entry:mapObject.entrySet()) {
                System.out.println(entry.getKey() +" =  " +entry.getValue());
          }
          System.out.println("--------------------------------------");
    }