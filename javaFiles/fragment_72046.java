HashMap<Integer,HashSet<Integer>> values = new HashMap<Integer, HashSet<Integer>>();

//now put in the accepted values for one
HashSet<Integer> oneValues = new HashSet<Integer>();
oneValues.put(1);
oneValues.put(2);
oneValues.put(4);
values.put(1, oneValues);

//put in 2 values
......