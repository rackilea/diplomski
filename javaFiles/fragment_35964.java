public void registerListener(Updateable listener){
  if (!listeners.contains(listener)) {
     listeners.add(listener);
  }
}

public void unregisterListener(Updateable listener){
  if (listener != null && listeners.contains(listener)){
     listeners.remove(listeners.indexOf(listener));
  }
}