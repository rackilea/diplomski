int oldItems[] = new int[10];
for (int i=0; i<10; i++) {
  oldItems[i] = i+10;
}
int newItems[] = new int[20];
System.arraycopy(oldItems, 0, newItems, 0, 10);
oldItems = newItems;