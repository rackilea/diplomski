try{
    byte[] key = Decrypter.generateKey();
    String title = Decrypter.decrypt( key, note.getTitle() );
    deleteFolder( title, position );
} catch(Exception e) {
    e.printStackTrace();
}