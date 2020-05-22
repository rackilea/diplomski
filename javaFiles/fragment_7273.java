private CustomerData fillCustomerDataFromMap(List<Map<String, Object>> customerDataList){
            CustomerData customerData = new CustomerData();

            for(Map<String, Object> map: customerDataList ){

               customerData.setColumn(map.get("columnName"));
               customerData.setColumn(map.get("columnName"));
               customerData.setColumn(map.get("columnName"));
               customerData.setColumn(map.get("columnName"));

.........
.........
.........
           }
        return customerData;
    }