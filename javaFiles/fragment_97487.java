public static void main( String[] args )
    {
        ApplicationContext appContext = 
           new ClassPathXmlApplicationContext(new String[] {"If-you-have-any.xml"});

        Resource resource = 
           appContext.getResource("http://www.common/testing.txt");

    try{
          InputStream is = resource.getInputStream();
          BufferedReader br = new BufferedReader(new InputStreamReader(is));

          String line;
          while ((line = br.readLine()) != null) {
             System.out.println(line);
          } 
          br.close();

        }catch(IOException e){
            e.printStackTrace();
        }

    }