public class BigDecimalXmlAdapter extends XmlAdapter{

    @Override
    public String marshal(BigDecimal bigDecimal) throws Exception {
        if (bigDecimal != null){
            return bigDecimal.toString();
        }
        else {
            return null;
        }
    }

    @Override
    public BigDecimal unmarshal(String s) throws Exception {
        try {
            return new BigDecimal(s);
        } catch (NumberFormatException e) {
            return null;
        }
    }
}