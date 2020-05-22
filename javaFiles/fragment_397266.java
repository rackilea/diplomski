String[] csv = {"   jimmy   ,johnson,jjohnson@gmail.com",
        "Joe,Donald,Joe_Donald@donald.org",
        "ARTHUR,THOMPSON,ARTHUR@thompson.org"};

Customer[] customs = new Customer[csv.length];

for (int i = 0; i < csv.length ; i++) {
    String[] customerDetails = csv[i].split(",");
    customs[i] = new Customer(customerDetails[0].trim(), customerDetails[1].trim(), customerDetails[2].trim());
}

System.out.println(customs[0].getFirst_name()));
System.out.println(customs[0].getLast_name());
System.out.println(customs[0].getEmail());