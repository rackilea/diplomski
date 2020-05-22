public **YOUR_RETURN_TYPE** parseObject(SoapObject soapObject)  throws SocketException,SocketTimeoutException,IOException{
        SoapObject _temp = soapObject;

        SoapObject diffgramObject = (SoapObject) _temp.getProperty("diffgram");     
        SoapObject newDataSetObject = (SoapObject) diffgramObject
                .getProperty("NewDataSet");

        if(diffgramObject.hasProperty("NewDataSet"))
        {
            for (int i = 0; i < newDataSetObject.getPropertyCount(); i++) {
                CategoryBean categoryBean = new CategoryBean();

                SoapObject tableObject = (SoapObject) newDataSetObject
                        .getProperty(i);
                SoapPrimitive catId = (SoapPrimitive) tableObject
                        .getProperty("MobileAppUserID");
                categoryBean.setCatId(Integer.valueOf(catId.toString()));
                SoapPrimitive propertyId = (SoapPrimitive) tableObject
                        .getProperty("UserName");
                categoryBean.setPropertyId(Integer.valueOf(propertyId.toString()));         
                SoapPrimitive categoryName = (SoapPrimitive) tableObject
                        .getProperty("Password");
                categoryBean.setCategoryName(categoryName.toString());

                ...........

                //SET DATA TO YOUR COLLECTION OBJECT

            }
            return YOUR_COLLECTION_OBJECT;
        }

    }