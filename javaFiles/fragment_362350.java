import com.avaje.ebean.ExpressionList;
import static com.avaje.ebean.Expr.eq;

// ...

public static List<Item> findByNameAndAttr(String name, String attr) {

    ExpressionList<Item> myQuery = find.where();

    if (name != null) myQuery.add(eq("name", name));
    if (attr != null) myQuery.add(eq("attr", attr));

    return myQuery.findList();
}