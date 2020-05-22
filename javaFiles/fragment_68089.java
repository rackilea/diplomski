try { 
        URL url = new URL(URI);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setDoOutput(true);
        connection.setInstanceFollowRedirects(false);
        connection.setRequestMethod("POST");
        connection.setRequestProperty("Content-Type", "application/xml");

        OutputStream os = connection.getOutputStream();
        // Write your XML to the OutputStream (JAXB is used in this example)
        jaxbContext.createMarshaller().marshal(customer, os);
        os.flush();
        connection.getResponseCode();
        connection.disconnect();
    } catch(Exception e) {
        throw new RuntimeException(e);
    }