public class car{
    private int doorsOpened;

    @JsonProperty(value="doorsOpened")
    public boolean doorsOpened(){
        return this.doorsOpened != 0; 
    }

}