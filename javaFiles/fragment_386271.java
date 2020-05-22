class Factory {
    public static List<Hotel> createHotels(List<DummyInfo> dummyInfos){
        ...
    }
}
...
page.setHotels(Factory.createHotels(dummyInfos));