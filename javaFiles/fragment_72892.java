for (String name : projectnames) {
        ArrayList<Data> pList = new ArrayList<>();
        for(Data data : allData){
            if (data.getProject().equals(name)){
                pList.add(data);
            }
        }
        seperatedData.add(pList);

}