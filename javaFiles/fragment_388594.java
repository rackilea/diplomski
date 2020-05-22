if (l_check2) {
        query = mFirestore.collection("Places").whereEqualTo("colour", "red").whereEqualTo("size", "big");
} 
else if (l_check1) {
        query = mFirestore.collection("Places").whereEqualTo("colour", "red");
}
else if (l_check3) {
        query = mFirestore.collection("Places").whereEqualTo("size", "big");
}