if (hm.containsKey(l)
    System.out.println("Country Code: " + l + "\nCountry Name: " + hm.get(l) );
else
    System.out.println("Missing key for " + l);
System.out.println("Printing hashmap");
for(Entry<String, String> entry : hm.entrySet()) {
{
    System.out.println(entry.getKey());
    System.out.println(entry.getValue());   
}