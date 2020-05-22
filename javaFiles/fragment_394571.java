List<Object[]> results = em.createNativeQuery("select * from html h JOIN htmla ha ON h.id=ha.id","HtmlaHtmlbMapping").getResultList();

@SqlResultSetMapping(
    name="HtmlaHtmlbMapping",
    entities = {
            @EntityResult(
                    entityClass = HTML.class,
                    fields = {
                            @FieldResult(name="id",column = "id"),
                            @FieldResult(name = "detail", column = "detail")}),
            @EntityResult(
                    entityClass = HTMLA.class,
                    fields = {
                            @FieldResult(name="id",column = "id"),
                            @FieldResult(name = "name", column = "name")})})