final Map<Category,List<Category>> map = new HashMap<>();
    for (Category cat : categories) {
        if (cat.parentCategory == null) continue;
        List<Category> children = map.get(cat.parentCategory);
        if (children == null) {
            children = new ArrayList<>();
            map.put(cat.parentCategory, children);
        }
        children.add(cat);
    }