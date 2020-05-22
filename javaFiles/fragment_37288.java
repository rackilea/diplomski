Collections.sort(users, new Comparator<User>() {
    @Override
    public int compare(User a, User b) {
        return Integer.compare(a.getAge(), b.getAge());
    }
});