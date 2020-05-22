private final EnumSet<Constantes> flagRead;

public boolean needsToRead(Constantes constantParameter) {
    return (flagRead.contains(constantParameter)  == false);
  }

public void markAsRead(Constantes constantParameter){
    flagRead.add(constantParameter);
  }