Racer racerLists[] = new Racer[4];
racerLists[0] = new Motorcycle();
racerLists[1] = new Car();
racerLists[2] = new Bike();
racerLists[4] = new Runner();

for(int i=0; i<racerLists.length; i++)
{
    racerLists[i].move();
}