csvWriter = new CSVWriter(new    FileWriter(outFile),CSVWriter.DEFAULT_SEPARATOR,CSVWriter.NO_QUOTE_CHARACTER);
    csvReader = new CSVReader(new InputStreamReader(new FileInputStream(csvFilename), "UTF-8"), ' ');
    String header = "NW,MSC,BSC,CELL,CELL_0";
    List<String> headerList = new ArrayList<String>();
    headerList.add(header);
    csvWriter.writeNext(headerList.toArray(new String[headerList.size()]));
    while ((nextLine = csvReader.readNext()) != null) {
        // nextLine[] is an array of values from the line

        for(int j=0;j< nextLine.length;j++){
            // System.out.println("next " +nextLine[1]+" "+nextLine [2]+ " "+nextLine [2]);
            if(nextLine[j].contains("cell")|| 
                    nextLine[j].equalsIgnoreCase("NW") ||
                    nextLine[j].equalsIgnoreCase("MSC") ||
                    nextLine[j].equalsIgnoreCase("BSC") ||
                    nextLine[j].equalsIgnoreCase("CELL")){
                hm.put(nextLine[j], j);
            }

        }

        break;
    }

    String[] out=null;

    while ((row = csvReader.readNext()) != null) {

        String [] arr=new String[4];

        outList = new ArrayList<>();
        innerList = new ArrayList<>();
        finalList=new ArrayList<String[]>();
        String[] str=null;

        int x=4;
        for(int y=0; y<hm.size()-10;y++){               

            if(!row[x].equalsIgnoreCase("NULL")|| !row[x].equals(" ")){
                System.out.println("x "+x);
                str=new String[]{row[0],row[1],row[2],row[3],row[x]};
            }

            finalList.add(str);;

            x=x+3;

        }
        csvWriter.writeAll(finalList);

        break;


    }

    csvReader.close();
    csvWriter.close();


}