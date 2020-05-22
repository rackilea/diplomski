SoapObject request = new SoapObject(NAMESPACE, METHOD_NAME);
        PropertyInfo pi = new PropertyInfo();
        pi.setName("cusDetails");
        pi.setValue(new SoapObject(NAMESPACE, "Customer")
                .addProperty("FirstName", fname)
                .addProperty("LastName", lname)
                .addProperty("EmailID", email)
                .addProperty("AddLine1", add1)
                .addProperty("AddLine2", add2).addProperty("ZipCode", zip)
                .addProperty("City", city).addProperty("StateCode", state)
                .addProperty("PhoneNumber", phoneno)
                .addProperty("Username", email)
                .addProperty("Password", pwd)
                .addProperty("BrandID", brandid)
                .addProperty("DiscAgree", flag)
                .addProperty("Latitude", "11.2")
                .addProperty("Longitude", "11.2"));

        request.addProperty(pi);
        Log.e("req", brandid);
        SoapSerializationEnvelope envelope = new SoapSerializationEnvelope(
                SoapEnvelope.VER11);
        envelope.dotNet = true;
        envelope.setOutputSoapObject(request);
        AndroidHttpTransport androidHttpTransport = new AndroidHttpTransport(
                URL);