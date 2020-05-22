for(int i = 0;i < serviceDetails.size(); i++){
        for (int j=0; j<documentIdArray.size();j++){
            if(serviceDetails.get(i).equalsIgnoreCase(documentIdArray.get(j))){
                servicesArray.add(serviceListArray[j]);
            }
        }
    }