dslContext
    .insertInto(
        table("repository.buffer"),
        field("b_external_id", String.class), // Change here
        field("b_buffer_type_id"),
        field("b_entrypoints", Object.class), // Change here
        field("b_site_id"),
        field("b_state", String.class), // Change here
        field("b_uri", String.class)) // Change here
    .select(select(
            inline(null, String.class),
            field("bt_id"),
            inline(null, Object.class),
            field("s_id"),
            inline(null, String.class),
            inline(null, String.class))
            .from(table("repository.site"), table("repository.buffer_type"))
            .where(field("s_name").eq(cast(null, String.class)))
            .and(field("bt_external_id").eq(cast(null, Integer.class))))
        .onConflict().doNothing()
    .getSQL();