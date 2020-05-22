class Out {
     int i; void x(){}
     static class In() {
       i++; x(); // not valid instructions
     }
     class In2() {
       i++; x(); // valid instructions
     }
}