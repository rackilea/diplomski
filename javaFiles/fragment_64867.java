LinkedHashSet<UserItem> set = new LinkedHashSet<UserItem>();
  ...

    Iterator<UserItem> iter = set.iterator();
    UserItem item = null;
    while (item == null && iter.hasNext()) {
        UserItem local = iter.next();
        if (local.getId() == id) {
            item = local;
        }
    }