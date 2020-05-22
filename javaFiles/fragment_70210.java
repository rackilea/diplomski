Set<String> parameterSet = map.get(action);                          // lookup the parameterSet
if ((parameterSet != null) && (parameterSet.contains(parameter)) {   // if it exists and contains the key
    System.out.println("Tupel already exists");
} else {                                                             // pair doesn't exist
    if (parameterSet == null) {                                      // create parameterSet if needed
        parameterSet = new HashSet<String>();
        map.put(action, parameterSet);
    }
    parameterSet.add(parameter);                                     // and add your parameter
}