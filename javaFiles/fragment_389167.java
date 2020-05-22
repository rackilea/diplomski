package forum9799081;

import javax.xml.bind.annotation.adapters.XmlAdapter;

public class ThetaValueAdapter extends XmlAdapter<ThetaValueAdapter.Beta, String> {

    @Override
    public Beta marshal(String string) throws Exception {
        Beta beta = new Beta();
        beta.theta = string;
        return beta;
    }

    @Override
    public String unmarshal(Beta beta) throws Exception {
        return beta.theta;
    }

    public static class Beta {
        public String theta;
    }

}