// chromosomes
String s1;
String s2;

// crossovers
String c1;
String c2;

Random r = new Random();

// get 2 random indices
int ind1 = r.nextInt(s1.length());
int ind2 = r.nextInt(s1.length());
// make sure ind2 > ind1... leaving this part out;

// break both strings into parts like in your picture
String s1part1 = s1.substring(0, ind1);
String s1part2 = s1.substring(ind1, ind2);
String s1part3 = s1.substring(ind2);

String s2part1 = s2.substring(0, ind1);
String s2part2 = s2.substring(ind1, ind2);
String s2part3 = s2.substring(ind2);

// combine the parts
c1 = s1part1 + s2part2 + s1part3;
c2 = s2part1 + s1part2 + s2part3;