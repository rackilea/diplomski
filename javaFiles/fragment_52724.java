public class LdifUtils {
    /**
     * Reads an LDIF file and returns its entries as a collection 
     * of <code>LdapAttributes</code> (LDAP entries).
     * <br>
     * Note: This method is not for huge files, 
     * as the content is loaded completely into memory.
     *
     * @param pathToLdifFile the <code>Path</code> to the LDAP Data Interchange Format file
     * @return a <code>Collection</code> of <code>LdapAttributes</code> (LDAP entries)
     * @throws IOException if reading the file fails
     */
    public static Collection<LdapAttributes> read(final Path pathToLdifFile) throws IOException {
        final LdifParser ldifParser = new LdifParser(pathToLdifFile.toFile());
        ldifParser.open();
        final Collection<LdapAttributes> c = new LinkedList<>();
        while (ldifParser.hasMoreRecords()){
            c.add(ldifParser.getRecord());
        }
        ldifParser.close();
        return c;
    }
}