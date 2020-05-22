{
    // ...
    String[] roles = new String[resultList.size()];
    int i=0;
    for (Iterator<String> iter = resultList.iterator(); iter.hasNext();) {            
        roles[i] = iter.next();
        i++;
    }
    return roles;
}