String filename = "myfile";
            File file= null;

//          Check if directory exists
            File directory = new File("D:\\testFolder\\");
            if (directory.exists() && directory.isDirectory()) {
                //create your file
                file =  new File(directory +"\\"+ filename); 
            } else {
                // Create directory
                directory = new File("C:\\testFolder\\");

                if(directory.mkdir()) {
                    System.out.println("Directory Created");
                    file =  new File(directory +"\\"+ filename); 

                } else {
                    System.out.println("Directory is not created");
                }

                // Create file
            }

            FileWriter writer = null;
            try {
                writer = new FileWriter(file, true);
                writer.write(builder.toString());
                writer.close();
                System.out.println("done!");
                statusText.setText("Information successfully saved!");
                statusText.setForeground(Color.BLACK);
            } catch (IOException e) {
                e.printStackTrace();
            }