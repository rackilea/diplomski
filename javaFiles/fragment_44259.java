con.setRequestMethod( "POST" );
        con.setRequestProperty("Content-Type","application/x-www-form-urlencoded");
        con.setRequestProperty( "charset", "utf-8");
        con.setRequestProperty( "Content-Length", Integer.toString( postData.length ));


        con.setDoOutput( true );

        con.setUseCaches( false );
        DataOutputStream wr = new DataOutputStream(connect2Rest.getOutputStream());
        wr.write(postData);
        wr.flush();
        wr.close();