public class lowestRates implements AggregationStrategy {
public Exchange aggregate(Exchange oldExchange, Exchange newExchange) {
    if (oldExchange == null) {
        return newExchange;
    }
    if (newExchange.getIn().getBody()!=null){
       Pattern p = Pattern.compile("(\\w+)\\s(\\d+)");
       String finalStr = ""; 
       String oldStr = oldExchange.getIn().getBody(String.class);
       String newStr = newExchange.getIn().getBody(String.class);
       if (oldStr!=null&&newStr!=null){
       Matcher m1 = p.matcher(oldStr);
       Matcher m2 = p.matcher(newStr);

          if(m1.group(2).equalsIgnoreCase(m2.group(2)))
            finalStr = m1.group(1) + Integer.toString(Integer.parseInt(m1.group(2)) > Integer.parseInt(m2.group(2)) ? Integer.parseInt(m2.group(2)) : Integer.parseInt(m1.group(2)));
          else
            finalStr = oldStr + "\n" + newStr;
          }

      oldExchange.getIn().setBody(finalStr);
      }
      return oldExchange;
    }
}