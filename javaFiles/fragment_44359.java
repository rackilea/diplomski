public class ChildAdapter extends XmlAdapter<String, Object> {

    @Override
    public Object unmarshall(String v) {
         List<Integer> result = new ArrayList<>();
         ...Tokenize your String v and add them to result...
         return result;
    }


    @Override
    public String marshall(Object v) {
         List<Integer> l = (List<Integer)v;
         StringBuilder b = new StringBuilder();
         ...Loop l and append b...
         return b.toString();
    }
}