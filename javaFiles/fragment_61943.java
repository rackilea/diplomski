Class MyParent {

    @OneToMany(cascade=CascadeType.ALL)
    Set<MyObject> myObjects;

}