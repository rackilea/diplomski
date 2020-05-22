Uri uri = data.getData();    
            BufferedReader mBufferedReader = null;
            String line;

             try
                {
                    InputStream inputStream = getContentResolver().openInputStream(uri);
                    mBufferedReader = new BufferedReader(new InputStreamReader(inputStream));
                    while ((line = mBufferedReader.readLine()) != null)
                    {
                        System.out.println("LLLLL: "+ line);
                    }
                    mBufferedReader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }