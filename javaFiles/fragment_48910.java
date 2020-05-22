public List<String> findByName(String Name) {
LdapQuery query = query().where("objectclass").is("top")
        .and("Name").like(Name + "*");

return ldapTemplate.search(query, new NameAttributesMapper());
}