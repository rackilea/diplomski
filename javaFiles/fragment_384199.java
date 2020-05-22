public List<? extends User> getParents() {
        if (parents == null) {
            parents = new ArrayList<User>();
        }
        return this.parents;
    }