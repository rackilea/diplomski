if (source == null)
        throw new DataInsufficientException("billingTax object is null");

    if (dest == null)
        throw new RecordNotFoundException("billingtaxDbObject object is not found in database");

    try{
        for (Field field : source.getClass().getDeclaredFields()) {

            field.setAccessible(true);
            Object sourceValue = field.get(source);
            Object destValue=field.get(dest);

            if(sourceValue!=null && sourceValue!="" && sourceValue!="null"){

                if(sourceValue instanceof String){
                    if(!sourceValue.toString().trim().equalsIgnoreCase("null")){
                        if(!sourceValue.toString().equalsIgnoreCase(destValue.toString())){
                            field.set(dest, sourceValue);
                            System.err.println(field.getName()+" is modified:"+field.get(dest));
                        }
                    }
                }
                else{
                    if(!sourceValue.equals("null") && !sourceValue.equals(destValue)){
                        field.set(dest, sourceValue);
                        System.err.println(field.getName()+" is modified:"+field.get(dest));
                    }
                }
            }
        }
        System.out.println();
    }catch (Exception e) {
         throw e;
    }
}