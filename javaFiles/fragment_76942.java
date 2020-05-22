public Zone cherche_chemin(List<List<Zone>> chemins, List<Zone> zones_exclues, Zone zone_arrivee) {
    boolean new_way = false;
    for (Iterator<List<Zone>> chemin = chemins.iterator(); chemin.hasNext();) {
        List<Zone> cheminList = chemin.next();
        List<Zone> zones = cheminList .get(chemins.size() - 1).getVoisinsAccessible(zones_exclues);
        for (Zone test_zone : zones) {
            new_way = true;
            if (test_zone == zone_arrivee) {
                return cheminList.get(1);
            } else {
                List<Zone> new_chemin = new ArrayList<>();
                enw_chemin.addAll(cheminList);          // THIS LINE
                new_chemin.add(test_zone);
                chemins.add(new_chemin);
                zones_exclues.add(test_zone);
            }
        }
        chemin.remove();
    }
    if (new_way) {
        return cherche_chemin(chemins, zones_exclues, zone_arrivee);
    } else {
        return null;
    }
}