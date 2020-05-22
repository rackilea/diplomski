List<Integer> positiveResults = new ArrayList<Integer>();
List<Integer> negativeResults = new ArrayList<Integer>();

for (int i = 1; i < 10; i++)
{
    if (someCondition)
        positiveResults.add(i);
    else
        negativeResults.add(i);
}