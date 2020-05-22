int listLength=1000;
boolean failed=false;

int[] GetPrimeData()
{
    String[] primesString=loadStrings("primes.txt");
    int[] primes=new int[primesString.length];
    for(int i=0; i<primes.length; i++) {
        primes[i]=int(primesString[i]);
    }
    return primes;
}

void setup() {
    int time=millis(); //keep track of how long it takes to do things

    //get prime data
    int[] primes = GetPrimeData();
    println("loaded primes in "+((float(millis())-time)/1000)+" seconds");

    PrintWriter output = createWriter(listLength + " prime factored.txt"); 

    //do prime factorizations
    for (int i=0; i<listLength; i++) {
        int boi=i+1;
        String newentry = boi+"=";
        int primeIndex=0;
        while (boi!=1) {
            if (primeIndex==primes.length) {
                println("ERROR: not enough primes indexed");
                boi=1; i=listLength; failed=true; 
            } else {
                if (boi%primes[primeIndex]==0) {
                    int count=1; boi/=primes[primeIndex];
                    while (boi%primes[primeIndex]==0) {
                        boi/=primes[primeIndex];
                        count++;
                    }
                    newentry += "p"+primeIndex+"^"+count+"*"; //list[i]+=primes[primeIndex]+"^"+count+"*";
                }
                primeIndex++;
            }
        }
        output.println(newentry.substring(0, newentry.length()-1));
    }

    output.close();
    println("prime factored in "+((float(millis())-time)/1000)+" seconds");

    //close program
    exit();
}