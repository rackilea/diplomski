List <ElvisLicense> ellicenses = new ArrayList <> (10);
Customer customer = customerMap.get("TestCompany");
if (customer != null) {
    ElvisLicense license = new ElvisLicense(customer,"VendorA",1234,"1234-A","Solutions Server gold","1234-dtbk-87654-nlof",10, true , true));
    ellicenses.add(license);
} else {
   //If the customer isn't found you need some kind of error handling, better than below :)
   System.out.println("Can't create a license, no customer found");
}