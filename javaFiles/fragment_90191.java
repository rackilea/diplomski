public class MyResultTransformer extends BasicTransformerAdapter {

 public final static MyResultTransformer INSTANCE;
 static {
  INSTANCE = new MyResultTransformer();
 }

 private MyResultTransformer() {

 }
 private static final long serialVersionUID = 1L;

 @Override
 public Object transformTuple(Object[] tuple, String[] aliases) {
  Map<String, Object> map = new HashMap<String, Object>();
  for (int i = 0; i < aliases.length; i++) {
   Object t = tuple[i];
   if (t != null && t instanceof Clob) {
    Clob c = (Clob) tuple[i];
    try {
     ByteArrayOutputStream bos = new ByteArrayOutputStream();
     IOUtils.copy(c.getAsciiStream(), bos);
     t = new String(bos.toByteArray());
    } catch (SQLException e) {
     e.printStackTrace();
    } catch (IOException e) {
     e.printStackTrace();
    }
   }
   map.put(aliases[i], t);
  }
  return map;
 }
}