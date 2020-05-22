//suppose we have a List<Integer> primeList (populated by previous execution loops)
// and Integer numberTested as the number under testing

for(int i=0; i<primeList.size();i++) {
    if(numberTested%primeList.get(i)==0) {
        //divider found, not prime
        break;
    }        

    if(primeList.get(i)>Math.sqrt(numberTested)) {
        //still not found a divider -- we found a prime
        primeList.add(numberTested);
        break;
    }
}