import javax.xml.bind.annotation.adapters.XmlAdapter;

public class EnumAdapter extends XmlAdapter<String, FeFiFo>
{

    public FeFiFo unmarshal(String value) {
        //if()
        //else if()
        //else

        return FeFiFo.FE;
    }

    public String marshal(FeFiFo value) {
        //if()
        //else if()
        //else
        return "0";
    }

}