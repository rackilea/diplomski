CREATE FUNCTION state_group_and_total( state map<text, double>, type text, amount double )
CALLED ON NULL INPUT
RETURNS map<text, double>
LANGUAGE java AS '
     Double count = (Double) state.get(type);
     if (count == null)
         count = amount;
     else
         count = count + amount;
     state.put(type, count);
     return state;
';