@Override
public boolean equals(Object other){
    if (other == null) return false;
    if (other == this) return true;
    if (!(other instanceof IPAddress))return false;
    IPAddress otherIPAddress = (IPAddress)other;
     //match other properties and return result
     return otherIPAddress.oct_1 == this.oct_1 && otherIPAddress.oct_2 == this.oct_2 && otherIPAddress.oct_3 == this.oct_3 && otherIPAddress.oct_4 == this.oct_4;
}