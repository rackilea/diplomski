@Timeout
    public void timeout(Timer timer) {
        System.out.println("Timeout occurred");

    for(File fileToDelete : Fileutility.files){

        if(fileToDelete.exists()) {
            fileToDelete.delete();
        }
    }
}