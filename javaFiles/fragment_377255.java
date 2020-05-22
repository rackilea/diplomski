public void createFolderSignature(){

    File signaturePointFolder = new File(Environment.getExternalStorageDirectory()+ File.separator + "tour_"+this.point.getId_tour() + File.separator + "point_"+this.point.getId());            
    Log.i("PATH : " , signaturePointFolder.getPath());
    if (!signaturePointFolder.exists()){
           Log.i("signaturePointFolder","CREATED");
           signaturePointFolder.mkdirs();
       }else{
           Log.i("signaturePointFolder","ALREADY CREATED");
       }
}