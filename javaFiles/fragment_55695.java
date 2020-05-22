ReaderUtil<String, PackageLog> reader = new ReaderUtil<String, PackageLog>(){
    protected Map<String, PackageLog> newMap() { 
        return new HashMap<String, PackageLog>(); 
    }
    protected void doThings(String data, Map<String, PackageLog> resultmap){
        PackageLog pl = new PackageLog(data);
        if(!pl.getPdfName().equals("")){
            resultMap.put(pl.getPdfName(), pl);
        }
    }
};
Map<String, PackageLog> myMap = reader.readAllLogsIntoMap();