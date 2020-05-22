FileInputStream streamIn = openFileInput(FILENAME);
ObjectInputStream ois = new ObjectInputStream(streamIn);
ToDoObject tmp = (ArrayList<ToDoObject>) ois.readObject();
ois.close();
if(tmp != null) {
    toDos = tmp;
}