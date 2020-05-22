package forum14045961;

import javax.xml.bind.annotation.adapters.XmlAdapter;

public class DoubleValueAdapter extends XmlAdapter<DoubleValueAdapter.AdaptedDoubleValue, Double>{

    public static class AdaptedDoubleValue {
        public double value;
    }

    @Override
    public AdaptedDoubleValue marshal(Double value) throws Exception {
        AdaptedDoubleValue adaptedDoubleValue = new AdaptedDoubleValue();
        adaptedDoubleValue.value = value;
        return adaptedDoubleValue;
    }

    @Override
    public Double unmarshal(AdaptedDoubleValue adaptedDoubleValue) throws Exception {
        return adaptedDoubleValue.value;
    }

}