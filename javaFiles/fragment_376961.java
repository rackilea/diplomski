String s  = "S1..R1..M1..D2..N3..S1.R1.M1.D2.N3.S1R1M1D2N3";
Pattern p = Pattern.compile("[A-Z]\\d+\\.*"); 
Matcher m = p.matcher(s);

List<String> matches = new ArrayList<String>();
while (m.find()) {
   matches.add(m.group());
}

System.out.println(matches);