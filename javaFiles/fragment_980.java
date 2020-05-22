BufferedReader br = new BufferedReader(new InputStreamReader(file));
                while (true)
                {

                    strLine = br.readLine();
                    if(strLine!=null)
                    {
                        System.out.println(strLine);
                    }else{
                        Thread.sleep(100);
                    }
                }