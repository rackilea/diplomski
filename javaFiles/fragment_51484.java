String site_inclusion = "0;100";

for (String inc: site_inclusion.split(";")) {
    String temp = String.valueOf(record.getAttrs().get(new PdsxAttrKey("SiteId")).getValue());
    if(!inc.equals(temp)) {
        System.out.println(inc + " != " + temp);
        continue;
    }
    System.out.println(inc + " == " + temp);
}