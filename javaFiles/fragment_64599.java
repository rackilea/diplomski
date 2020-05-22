public static LibraryCollection librarycollectObj1 = new LibraryCollection(10);

// Initialize the object somehow
for (int i = 0; i < 10; i++) {
    librarycollectObj1.libraryCollection[i] = new Material(i, "");
}

String search = "1"; 
// Do some null checking in production code
System.out.println(librarycollectObj1.findMaterial(search). getMaterialId());