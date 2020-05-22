Scanner sc = new Scanner(System.in);
int n = sc.nextInt();
sc.nextLine(); // Force it to consume the line break
ArrayList<String> s = new ArrayList();
for (int i = 0; i < n; i++)
{
    String st = sc.nextLine();
    s.add(st);
}

int q = sc.nextInt();
sc.nextLine(); // Force it to consume the line break
for (int i = 0; i < q; i++)
{
    int count = 0;
    String st = sc.nextLine();
    String check = "\\B" + st + "\\B";
    Pattern p = Pattern.compile(check);
    for (int j = 0; j < n; j++)
    {
       Matcher m = p.matcher(s.get(j));
       while (m.find())
       {
           count += 1;
       }
   }
   System.out.println(count); // => 3
}