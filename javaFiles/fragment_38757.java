int numberOfPrimes=100000;

ArrayList<Integer>Primes = new ArrayList<>();

Primes.add(2);

int i=3;
Primes.add(i);
for(int j = 0; j < Primes.size(); j++){//Checks all previous prime numbers before the new number
if(i%Primes.get(j)==0){//Checks if prime number at j is divisible by i

if(Primes.size()>numberOfPrimes){//breaking out of loop after reaching above numberOfPrimes 

Primes.remove(Primes.size()-1);//Removes the last non prime number 
    break;
}
Primes.remove(Primes.size()-1);//Removes the non prime number
j=-1;//resets j to start from 0
i++;//next number
Primes.add(i);//adding it for next check
}
if(j==Primes.size()-2){//Another resting condition when all previous prime numbers are checked
j=-1;
i++;
 Primes.add(i);
}
}
//end

for(int j = 0; j < Primes.size(); j++){// just for printing
System.out.println(Primes.get(j));
}