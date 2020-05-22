try {
        URL url = new URL(server);

        HttpURLConnection con;
        con=(HttpURLConnection) url.openConnection();
        con.setRequestProperty("Content-type", "text/xml; charset=UTF-8");
        con.setRequestMethod("POST");
        con.setDoOutput(true);
        con.setDoInput(true);


        OutputStream out = con.getOutputStream();
        Writer writer = new OutputStreamWriter(out, "UTF-8");

        writer.write(xml);



        writer.flush();
        writer.close();

        InputStream is= con.getInputStream();

//This gets sent to the client
            return set_courses(is);


    } catch (Exception e){
        e.printStackTrace();
        status_message= "Custom 1: "+e.getMessage();
        return false;
    }