if (rs.next())
            {

                anyResults = true;

                Blob blob = rs.getBlob("image");

                id = rs.getInt("id");

                System.out.println(id);
                System.out.println(blob);
                System.out.println(blob.length());


                InputStream in = blob.getBinaryStream(1, blob.length());