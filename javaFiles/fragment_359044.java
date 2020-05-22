static InputStream is = null;


            try {

                BufferedReader reader = new BufferedReader(new InputStreamReader(
                        is, "iso-8859-1"), 8);

                StringBuilder sb = new StringBuilder();

                String line = null;

                while ((line = reader.readLine()) != null) {

                    sb.append(line + "\n");

                }

                is.close();

                json = sb.toString();

            } catch (Exception e) {

                e.printStackTrace();
            }