public void merge(DaoSession s) {
    s.insertOrReplace(this);

    // do this for all toMany-relations accordingly
    for (Picture p : getPictures()) {
        s.insertOrReplace(p);
        newPics.add(p.getId());
    }
    resetPictures();
}