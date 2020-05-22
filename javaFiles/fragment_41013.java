if (stringAry.size() >= 3) // Make sure you really have 3 elements
{
    List<String> array = new ArrayList<String>();
    array.add(stringAry.get(stringAry.size()-1)); // The last
    array.add(stringAry.get(stringAry.size()-2)); // The one before the last
    array.add(stringAry.get(stringAry.size()-3)); // The one before the one before the last

    System.out.println(array);
}