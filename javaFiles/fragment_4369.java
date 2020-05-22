Client client = ClientFactory.newClient();
            WebTarget target = client.target("http://foo.com/resource");
            Response response = target.request().get();
            String value = response.readEntity(String.class);
            response.close();  // You should close connections!
return value;