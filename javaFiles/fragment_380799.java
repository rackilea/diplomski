import javax.xml.bind.annotation.adapters.XmlAdapter;

public class BrandDataAdapter extends XmlAdapter<Integer, BrandData> {

    @Override
    public Integer marshal(BrandData arg0) throws Exception {
        return arg0.getPkId();
    }

    @Override
    public BrandData unmarshal(Integer arg0) throws Exception {
        return new BrandData(arg0);
    }

}