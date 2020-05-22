ArrayList<Integer> numberList = myMap.get(mod);

if (numberList == null)
{
    numberList = new LinkedList<>();
}

num.add(number);

myMap.put(mod, num);