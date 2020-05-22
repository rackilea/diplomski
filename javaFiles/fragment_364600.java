List<String> countriesAvailable = new ArrayList<String>();
    countriesAvailable.add("Australia");
    countriesAvailable.add("France");

    List<String> countriesVisited = new ArrayList<String>();
    countriesVisited.add("Austria");
    countriesVisited.add("France");

    Map<String, List<String>> vars = new HashMap<String, List<String>>();
    vars.put("countriesAvailable", countriesAvailable);
    vars.put("countriesVisited", countriesVisited);

    Boolean s = (Boolean) MVEL.eval(
            "countriesAvailable.containsAll(countriesVisited)", vars);

    System.out.println("Result = " + s);