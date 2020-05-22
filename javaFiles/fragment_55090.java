private String name;
//changed bannerID to long to match input from code example
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