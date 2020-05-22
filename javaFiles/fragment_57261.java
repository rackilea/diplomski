logger(clazz, "job started");

List<Domain> domains = new ArrayList<>();
domains.addAll(domManager.getActiveDoms());

for (Domain d : domains) {
    try {
        Attributes attributes = iDirC.getAttributes("dns:/" + d.getName(), new String[] { "MX" });
        Attribute attributeMX = attributes.get("MX");
        System.out.println(attributes);

    } catch (NamingException e) {
        //do somethig here like `System.out.println("error message!");`
    }
}