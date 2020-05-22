for (Integer i : myMap.keySet()) {
    System.out.print(i + ": ");
    StringBuilder sb = new StringBuilder();
    for (User u: myMap.get(i))
       sb.append("," + u.name);
    System.out.println(sb.toString().substring(1)); // Remove the first comma
}