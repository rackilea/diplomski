List<String> one = new ArrayList<>();
one.add("x");
one.add("y");
one.add("y");
one.add("z");
List<String> two = new ArrayList<>();
two.add("x");
two.add("y");

for (String s : two)
{
    one.remove(s);
}

System.out.println("one : " + one);