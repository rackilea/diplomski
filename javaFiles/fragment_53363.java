List<Map<String, Object>> filteredListUser = new ArrayList<>();

for(Map<String, Object> m : listUser) {
        if(listId.contains(m.get("USER_ID"))) {
            filteredListUser.add(m);
        }
    }