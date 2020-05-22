List<String> customers = new ArrayList<>();

customers.add("Anne");
customers.add("Michelle");

for (String customer: customers) {
    bw.write(customer);
    bw.newLine();
}