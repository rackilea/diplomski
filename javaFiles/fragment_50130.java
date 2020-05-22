public class QueryBuilder extends AbstractMessageTransformer {

@Override
public Object transformMessage(MuleMessage message, String outputEncoding)
        throws TransformerException {

    System.out.println("Query Params : "
            + message.getInboundProperty("http.query.params").getClass()
                    .getName());

    Map<?, ?> map = message.getInboundProperty("http.query.params");

    System.out.println("Map keys : " + map.keySet());
    String where = "";
    for (Map.Entry<?, ?> entry : map.entrySet()) {
        System.out.println(entry.getKey() + "/" + entry.getValue());
        where = where+" "+entry.getKey()+"="+"'"+entry.getValue()+"'"+" and";
    }
    String whereCondition = where.substring(0, where.lastIndexOf(" "));
    System.out.println("Where condition is : "+ where.substring(0, where.lastIndexOf(" ")));
    return whereCondition;
}}