private void persist(){
    synchronized(this){
        JPA.em().getTransaction().begin();
        <nameObject>.save();
        JPA.em().getTransaction().commit();
    }
}