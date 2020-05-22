Iterator<CmisObject> it = folder.getChildren().iterator();

while(it.hasNext()) {
  CmisObject object = it.next();

  // Do something with the child object
}