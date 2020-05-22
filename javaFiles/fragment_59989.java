@Override
public int compareTo(Pracownicy o) {    
    int firstNameEqual = this.imie.compareTo(o.imie);
    // if first name is equal then compare on surname
    if(firstNameEqual==0){
         return this.nazwisko.compareTo(o.nazwisko);
    }else{
         return firstNameEqual;
    }
}