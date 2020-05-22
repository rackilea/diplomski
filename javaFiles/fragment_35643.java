@Override
public String toString() {
    String str = "";
    double cost = 0.00;
    if (this.isFirstClass()){
        cost = 3.30;
        str = "First Class Parcel\n";
     }  // ALWAYS USE BRACES !
    else {
        cost = 2.80;
        str = "Second Class Parcel\n"; 
     }
    return str + super.toString() + "\n";