for (Object object : extras) {
   //... check for other types here
   } else if (object instanceof List) {
     parcel.writeList(object); // This what happens in your case and will be unparcelled into arraylist
   } else if (object instanceof Serializable) {
     parcel.writeSerializable(object); // What you really want, but percelling never will get here
   }
}