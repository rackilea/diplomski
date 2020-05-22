try {
            String line = null;
            FileInputStream fi = (FileInputStream) your_class_name.class.getResourceAsStream("/pom.xml");
            BufferedReader bf = new BufferedReader(new InputStreamReader(fi));
            while((line = bf.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }