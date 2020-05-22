@ConfigurationProperties("foo")
class ConfProps {

    private List<SomePojo> differentlyNamedList = new ArrayList<>();

    // getter, setter

    public void setBar(List<SomePojo> bar){
       this.differentlyNamedList = bar;
    }
}