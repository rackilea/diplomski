@Transactional
private void persist(){
    synchronized(this){
        <nameObject>.save();
    }
}