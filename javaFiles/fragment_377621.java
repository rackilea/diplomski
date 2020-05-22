List<Fruit> fruits= new ArrayList<Fruit>();

Fruit fruit;
for(int i = 0; i < 100; i++)
{
  fruit = new Fruit();
  fruit.setname(...);
  fruits.add(fruit);
}

// Sorting
Collections.sort(fruits, new Comparator<Fruit>() {
        @Override
        public int compare(Fruit fruit2, Fruit fruit1)
        {

            return  fruit1.fruitName.compareTo(fruit2.fruitName);
        }
    });