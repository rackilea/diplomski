for (int i = 0; i < pl.size(); i++) {
    String id = pl.get(i).getId();

    if (id.startsWith(nameCaps)) {
        found = true;
        System.out.println(pl.get(i).toString());
    }
}