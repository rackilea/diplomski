import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.adapters.XmlAdapter;

public class BooleanAdapter extends XmlAdapter<BooleanAdapter.AdaptedBoolean, Boolean> {

    public static class AdaptedBoolean {

        @XmlAttribute
        public boolean value;

    }

    @Override
    public Boolean unmarshal(AdaptedBoolean adaptedBoolean) throws Exception {
        return adaptedBoolean.value;
    }

    @Override
    public AdaptedBoolean marshal(Boolean v) throws Exception {
        AdaptedBoolean adaptedBoolean = new AdaptedBoolean();
        adaptedBoolean.value = v;
        return adaptedBoolean;
    }

}