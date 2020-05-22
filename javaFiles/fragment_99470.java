interface Client {

  //Clients extend this interface

  void useDeprecated(boolean deprecated);

  default boolean isDeprecated(int serverVersion, int clientVersion) {
    // you can string for representing versions as well.
    // complicated logic of deprecation here
    return result;
  }

  boolean isAllowedToUseDeprecated();

  default Object getData() {
    if(isDeprecated(serverVersion, clientVersion)) {
      if(isAllowedToUseDeprecated()) {
        return getDataFromServer();
      } else {
        throw new DeprecatedException(expectedVersion, actualVersion, message);
      }
    } else {
      return getDataFromServer();
    }

  }

  Object getDataFromServer(); //Clients implement this
}