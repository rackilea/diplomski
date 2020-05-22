import javax.xml.bind.annotation.adapters.XmlAdapter;

public class SomeValueAdapter extends XmlAdapter<AdaptedField, Boolean> {

    @Override
    public Boolean unmarshal(AdaptedField v) throws Exception {
        String value = v.getField().getValue();
        return Boolean.valueOf(value);
    }

    @Override
    public AdaptedField marshal(Boolean v) throws Exception {
        AdaptedField adaptedField = new AdaptedField();
        Field field = new Field();
        field.setName("someValue");
        field.setValue(String.valueOf(v));
        adaptedField.setField(field);
        return adaptedField;
    }

}