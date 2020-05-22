int add( int x, int y ) {
    throw notImplemented();
}

Exception notImplemented() {
    ... some stuff here (generally logging, sometimes recovery, etc)
    return new NotImplementedException();
}