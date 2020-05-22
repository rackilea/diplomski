class Student {
    private String name;
    private long bannerID;
    public Student(String name){
        setName(name);
    }
    public Student(long bannerID){
        setBannerID(bannerID);
    }
    public Student(String name, long bannerID){
        setName(name);
        setBannerID(bannerID);
    }
    public Student(){}
    public String getNameBanID(){

        return bannerID + name;
    }
    public String getName(){

        return name;
    }
    public long getBannerID(){
        return bannerID;
    }
    public void setBannerID(long bannerID){

        this.bannerID = bannerID;
    }
    public void setName(String name){

        this.name = name;
    }
}