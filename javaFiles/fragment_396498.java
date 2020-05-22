private static String getNumOfteams(String team, List<String> imps, Map<ticket, Integer> count) {
    StringBuilder builder = new StringBuilder();

    for (String v : imps){               
        Integer cnt = count.get(new ticket(team, v));
        if (cnt == null) {
            cnt = 0;
        }
        builder.append(cnt + "\t");
    }
    return builder.toString();
}