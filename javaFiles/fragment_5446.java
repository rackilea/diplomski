public void roleIsStale(String roleName, Date snapshotDate) {
    Date updateDate = map.get(roleName)) {
    if (updateDate == null) {
        // role was not changed by admin, it's not stale
        return false;
    }
    return updateDate.after(snapshotDate);
}