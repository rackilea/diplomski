public int newMethod(){
if (m.needsToRead(Constantes.VINCULACION)){
 ReadVinculacion();
}
//... DO MORE
}

public void readVinculacion(){
//.. Do DB operations to read Vinculacion variables.
m.markAsRead(VINCULACION);
}