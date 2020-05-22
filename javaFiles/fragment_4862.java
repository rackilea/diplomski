int toDelete = in.nextInt(); // assume it's between 0 and size - 1
for (int i = toDelete; i < size - 1; i++) {
    collection[i] = collection[i + 1];
} 
collection[size] = null;
size--;