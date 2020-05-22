Class Address {
   City city; // HAS-A
}

Class Business {}

Class City {
   List<Business> business; // HAS-A
}

Class Restaurant extends Business{ // IS-A
    Address address; // HAS-A
}

Class Theater extends Business { // IS-A
    Address address;  // HAS-A
}