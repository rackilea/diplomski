class MyObject implements Comparable<MyObject> {
    public int compareTo(MyObject a) {
       //return either 1, 0, or -1
       //that you compare between this object and object a
  ``}
}

//and in your logic write this line
Collections.sort(myVector);