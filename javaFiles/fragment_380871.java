// Input list
List<String> name = new ArrayList<String>();


    final String[] specialChars = { "_", ">" }; 
    List<String> specCharList = new ArrayList<String>();
    List<String> strList = new ArrayList<String>();
    List<String> finalList = new ArrayList<String>();
    String rules = "< '_' < '>' ";

    boolean isSpec = false ;
    for(String names : name) {
        isSpec = false ;
        for(int i=0;i<specialChars.length;i++) {
            if(names.startsWith(specialChars[i])) {
                // System.out.println("Name : "+names);
                isSpec = true ;
            }
        }  
      // to sort special char list and normal list
       if(isSpec) {
           specCharList.add(names);
       } else {
           strList.add(names);
       }
    }


    try {
        // To sort special character list
        Collections.sort(specCharList, new RuleBasedCollator(rules));
        // Add the sorted list to finallist
        finalList.addAll(specCharList);

        // to sort other list
        Collections.sort(strList, String.CASE_INSENSITIVE_ORDER);
        // Add the sorted list to finallist
        finalList.addAll(strList);

    } catch (ParseException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
    }

    System.out.println("Final Output List --------");
    for(String names : finalList) {
        System.out.println(names);
    }