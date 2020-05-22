@SqlResultSetMapping(name="CustomerDetailsResult",
    classes={
        @ConstructorResult(targetClass=com.acme.CustomerDetails.class,
            columns={
                @ColumnResult(name="id"),
                @ColumnResult(name="name"),
                @ColumnResult(name="orderCount"),
                @ColumnResult(name="avgOrder", type=Double.class)})
})