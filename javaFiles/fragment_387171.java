String url = "http://www.thomas-bayer.com/sqlrest/CUSTOMER/";
        HttpClient client = HttpClientBuilder.create().build();
        HttpPost post = new HttpPost(url);

        String xml = "<resource>";
        xml += "<ID>102</ID>";
        xml += "<FIRSTNAME>Apex</FIRSTNAME>";
        xml += "<LASTNAME>Consultancy</LASTNAME>";
        xml += "<STREET>Shell Blvd</STREET>";
        xml += "<CITY>Fremont</CITY>";
        xml += "</resource>";

        post.setEntity(new StringEntity(xml));
        HttpResponse response = client.execute(post);

        System.out.println(response.getStatusLine().getStatusCode());
        System.out.println("Response Code: " + response);
        System.out.println(response.getStatusLine().getReasonPhrase());