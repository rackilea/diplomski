Object[][] array = new Object[EventAll.size()][];

int i = 0;
for (List<Object> event : EventAll) {//each list
    array[i++] = event.toArray(new Object[event.size()]);
}