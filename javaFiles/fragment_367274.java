Collections.sort(objs, new Comparator<Hello>() {

    @Override
    public int compare(Hello o1, Hello o2) {
        return o1.getCommentDate().compareTo(o2.getCommentDate());
    }
});