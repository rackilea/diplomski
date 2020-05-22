//Asumming your values are these:
        List<String> datesList = new ArrayList<String>();
        List<Double> dataList = new ArrayList<Double>();
        //You must fill your data of course...
        //I use a buffer to put in order my data

        StringBuffer stringAppender = new StringBuffer();       
        for (int i = 0; i < dataList.size(); i++) {
            stringAppender.append(dataList.get(i));
            stringAppender.append(",");
            stringAppender.append(datesList.get(i));
            if (i != dataList.size()-1) {
                stringAppender.append("\n");
            }
        }
        //I use the Buffered Writer and then save all the data ordered in one single String.
        BufferedWriter bw = new BufferedWriter(new FileWriter(new File("/home/mtataje/saved.txt")));        
        bw.write(stringAppender.toString());
        bw.close();