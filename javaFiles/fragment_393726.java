import javax.xml.bind.annotation.adapters.XmlAdapter;

public class FieldsAdapter extends XmlAdapter<AdaptedField, Field> {

    @Override
    public Field unmarshal(AdaptedField v) throws Exception {
        return v.getField();
    }

    @Override
    public AdaptedField marshal(Field v) throws Exception {
        AdaptedField adaptedField = new AdaptedField();
        adaptedField.setField(v);
        return adaptedField;
    }

}