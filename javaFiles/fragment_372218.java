@XmlRootElement
public class Tests {

    @XmlElement(name="lib-data")
    ArrayList<LibData> libData;

    public Tests()
    {
        this.libData = new ArrayList<LibData>()
    }


    public ArrayList<LibData> getLibData() {
        return this.libData;
    }

    public void setLibData(ArrayList<LibData> libData) {
        this.libData = libData;
    }
}