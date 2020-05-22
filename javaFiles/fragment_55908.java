String text = "{ 'OTH', 'REJ', 'RSTO', 'RSTOS0', 'RSTR', 'S0', 'S1', 'S2', 'S3', 'SF', 'SH' }";
List<String> tokens = new ArrayList<>();

Scanner sc = new Scanner(text);
sc.useDelimiter("\\W+");// one or more non-word character
while(sc.hasNext())
    tokens.add(sc.next());

System.out.println(tokens);//[OTH, REJ, RSTO, RSTOS0, RSTR, S0, S1, S2, S3, SF, SH]
sc.close();