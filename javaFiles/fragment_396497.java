private static List<String> getimps(Map<ticket, Integer> count) {
    List<String> imps = new ArrayList<String>();
    for(Map.Entry<ticket, Integer> ent : count.entrySet())
        if (!imps.contains(ent.getKey().getimp())) {
            imps.add(ent.getKey().getimp());
        }
    }

    // make sure I3 is listed as imp as well:
    if (!imps.contains("I3")) {
        imps.add("I3");
    }

    return imps;
}