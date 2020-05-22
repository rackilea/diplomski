try {
            File f=new File("test.xml");
            BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(f)));
            String content=null;

            while((content=reader.readLine())!=null)
            {
                content = content.replaceFirst("some text", "new text");
                System.out.println(content);
            }

        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }