private void searchByLastNameRec(TreeNode newroot, String last_name) {
    if (newroot == null || newroot.item == null)
        return;
    if (Objects.equals(last_name, newroot.item.getLast_name()))
        q.put(newroot.item);
    searchByLastNameRec(newroot.right, last_name);
    searchByLastNameRec(newroot.left, last_name);
}