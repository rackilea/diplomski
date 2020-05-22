@SqlResultSetMapping(
    name="transactionsMapping",
    classes={
        @ConstructorResult(
            targetClass=ConsolidateResDB.class,
            columns={
                @ColumnResult(name="transdate"),
                @ColumnResult(name="orderreqid")
                // further mappings ...
            }
        )
    }
)