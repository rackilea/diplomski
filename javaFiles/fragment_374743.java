try
            {
            FileInputStream fOne = openFileInput("File1");

            } 
            catch (FileNotFoundException e) 
            {
                e.printStackTrace();
            }
            Scanner scanFile = new Scanner(new DataInputStream(fOne));
            while (scanFile.hasNextLine())
            {
                countTwo = 0;
                if(scanFile.nextLine()!=null)
                {
                    count++;
                    Toast.makeText(getBaseContext(), "Count : " + count, 500).show();
                }
               FileInputStream fTwo = openFileInput("File2");
               Scanner scanFileT = new Scanner(new DataInputStream(fTwo));
                while(scanFileT.hasNextLine())
                {
                    if(scanFileT.nextLine()!=null)
                    {

                        countTwo++;
                        Toast.makeText(getBaseContext(), "CountTwo : " + countTwo, 500).show();                 
                    }
                }
              fTwo.close();
            }