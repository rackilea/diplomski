Comparator<Book> dateComparator = new Comparator<Book>() {
    @Override
    public int compare(Book o1, Book o2) {
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        Date o1PublishDate = null;
        Date o2PublishDate = null;
        try {
            o1PublishDate = formatter.parse(o1.publishDate);
            o2PublishDate = formatter.parse(o2.publishDate);
        } catch (ParseException pe) {
            pe.printStackTrace();
        }

        return o1PublishDate.compareTo(o2PublishDate);

    }
};