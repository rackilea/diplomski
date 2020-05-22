import javax.xml.bind.annotation.adapters.XmlAdapter;

public class BodyAdapter extends XmlAdapter<Body, Object>{

    @Override
    public Object unmarshal(Body v) throws Exception {
        return v.getValue();
    }

    @Override
    public Body marshal(Object v) throws Exception {
        Body body = new Body();
        body.setValue(v);
        return body;
    }

}