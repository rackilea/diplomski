String line = "N001";"2014-08-12-07.11.37.352000";"         ";"some@email.com        ";4847       ;"street";"NAME        SURNAME                 ";26  ;"CALIFORNIA                      ";21  
StringTokenizer st1 = new StringTokenizer(line, ";");

while(st2.hasMoreTokens()) {
    System.out.println(st2.nextToken().replaceAll("\"",""));
}