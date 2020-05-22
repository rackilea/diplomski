@ColumnTransformer(
    read =  "pgp_sym_decrypt(" +
            "    test, " +
            "    current_setting('encrypt.key')" +
            ")",
    write = "pgp_sym_encrypt( " +
            "    ?, " +
            "    current_setting('encrypt.key')" +
            ") "
)
@Column(columnDefinition = "bytea")
private String test;