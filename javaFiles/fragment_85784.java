public void readCSVFile(String csvFile) {
            int currRow = 0;
            int currCol = 0;
            try {
                bufferedReader = new BufferedReader(new FileReader(csvFile));

                String[] dataFromCSV = null;
                while((line = bufferedReader.readLine()) != null) {
                    currRow++;
                    dataFromCSV = line.split(",");
                    for(String dataFromCSV1 : dataFromCSV) {
                        currCol++;
                        numData = Integer.parseInt(dataFromCSV1); //parse data
                        System.out.print(numData + ",");
                        data[currRow][currCol] = numData; //store numData
                    }
                    System.out.println();
                }

            } catch(IOException | NumberFormatException ex) {
                ex.printStackTrace();
            }

        }