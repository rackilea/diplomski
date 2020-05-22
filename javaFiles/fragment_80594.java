String[] newXml = xml.split("\\<\\?");
    ArrayList<String> xmlList = new ArrayList<>(Arrays.asList(newXml));
    for(int i = 0; i<xmlList.size();i++){
        if(!xmlList.get(i).contains("xml version=\"1.0\" encoding=\"UTF-8\"")){
            xmlList.remove(i);
        }

    }
    for(int j = 0;j<xmlList.size();j++){
        xmlList.set(j, "<?"+xmlList.get(j));
        xmlList.set(j,xmlList.get(j).split("\\#")[0]);
    }


    return xmlList;