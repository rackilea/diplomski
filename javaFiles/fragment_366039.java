public class dids { //classes start with an upper case letter (Dids not dids)

char letters[];

public dids(String thing)
{

letters= new char[thing.length()];  //No null check can throw NPE
for(char x:letters){ //letters is an empty array.  
    letters[x] = thing.charAt(x);  
}
for(int i=thing.length();i>0;i--){//style is to count up
    String retval += letters[i]; //retval is recreated every time

}

}

}