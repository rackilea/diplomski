ArrayList<Integer> first = userRatings.get(e1);
ArrayList<Integer> second = userRatings.get(e2);

//Taking the smallest size will ensure that we don't get IndexOutOfBoundsException.

int length = first.size() < second.size() ? first.size() : second.size();

for(int iDx = 0; iDx < legth; iDx++){
   //compare content
}