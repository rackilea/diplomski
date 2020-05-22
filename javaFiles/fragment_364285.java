List<String> listA = Arrays.asList("1,a,tf", "2,b,tf", "3,c,tf");
List<String> listB = Arrays.asList("b,true", "a,false", "c,true");
List<String> listC = new ArrayList<>();

for(String a : listA)
{
    for (String b : listB)
    {
        if (String.valueOf(a).split(",")[1].equals( String.valueOf(b).split(",")[0] ) )
        {
            listC.add(String.valueOf(a).replaceAll("tf", String.valueOf(b).split(",")[1]));
        }
    }
}

System.out.println(listC.toString());