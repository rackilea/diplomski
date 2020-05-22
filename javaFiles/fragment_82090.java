int min = 0;
int max = 13;  
List<Integer> list = new ArrayList<Integer>();

for(int i = min; i <max;)
{
int rand = ((int)(Math.random() * max)) + 1;
if(!list.contains(rand))
{
    list.add(rand); // it will be added only if not in list
    i++;
}
}