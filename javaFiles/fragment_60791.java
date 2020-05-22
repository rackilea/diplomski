PrettyTime p = new PrettyTime();
System.out.println(p.format(new Date()));
//prints: “right now”

System.out.println(p.format(new Date(1000*60*10)));
//prints: “10 minutes from now”