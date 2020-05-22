import javax.xml.bind.annotation.adapters.XmlAdapter;

public class AuthCodeAdapter extends XmlAdapter<SubXml, String> {

    @Override
    public String unmarshal(SubXml v) throws Exception {
        return v.getAuthCode();
    }

    @Override
    public SubXml marshal(String v) throws Exception {
        SubXml subXml = new SubXml();
        subXml.setAuthCode(v);
        return subXml;
    }

}