import java.util.ArrayList;
import java.util.Collections;

ids = new ArrayList();
idCount = Integer.parseInt(vars.get("custID_matchNr"));
for (int i=0; i<idCount; i++){
  ids.add(vars.get("custID_" + String.valueOf(i+1)));
}

Collections.shuffle(ids);

builder = new StringBuilder();
for (String id: ids){
  builder.append(id);
  builder.append(",");
}
builder.deleteCharAt(builder.length()-1);
vars.put("custPref", builder.toString());