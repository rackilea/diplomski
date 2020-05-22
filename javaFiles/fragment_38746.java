for (CItem c : cItems) {
    CItem r = rItemMap.get(c.getID());
    if (r != null) {
        Mismatch m = compareItems(c, r);
        if (m != null) {
            mismatches.add(m);
        }
    }
}