int lightestIndex = 0;
 int heaviestIndex = 0;

for (int i = 0; i< dogs.size(); i++)
{
   if(dogs.get(i).getWeight() <= dogs.get(lightestIndex).getWeight()){
      lightestIndex = i;
   } 

   if(dogs.get(i).getWeight() >= dogs.get(heaviestIndex).getWeight()){
      heaviestIndex = i;
   }        
}


 System.out.println("The Lightest dog is " + dogs.get(lightestIndex).toString());
 System.out.println("The Heaviest dog is " + dogs.get(heaviestIndex).toString());