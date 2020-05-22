int max = added_items.length > deleted_items.length ? added_items.length : deleted_items.length;
    for (int i = 0; i < max; i++) {
        Integer added = (i < added_items.length) ? added_items[i] : null;
        Integer deleted = (i < deleted_items.length) ? deleted_items[i] : null;
        pairs.add(new Pair(added, deleted));
    }