FindIterable<Document> iterable = db.getCollection("questions").find( "{ $or : [user_id: '/bc/' ,user_name:'/bc/',age:'/2/'] }" );

iterable.forEach(new Block<Document>() {
    @Override
    public void apply(final Document document) {
        System.out.println(document);
    }
});