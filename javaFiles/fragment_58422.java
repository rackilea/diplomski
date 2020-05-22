final Object[] stringPermutations = combine(permutations(getInputs(field))).toArray();
try (final Connection con = getConnection()) {
    try (final PreparedStatement st1 = con.prepareStatement("SELECT * FROM SHOP WHERE DRINKS IN (?)")) {
        Array array = con.createArrayOf("VARCHAR", stringPermutations);
        st1.setArray(1, array);
        try (final ResultSet rs = st1.executeQuery()) {
            //do stufd
        }
    }
}