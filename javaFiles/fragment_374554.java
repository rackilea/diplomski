import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Map;
import java.util.List;

List<Map<String, String>> info = new ArrayList<Map<String, String>>();

while (rs.next()) {
    Map<String, String> e = new Hashtable<String, String>();
    e.clear();
    for (String a : dados) {
        e.put(a, rs.getString(a));
    }
    info.add(e);
}