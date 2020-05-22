public void actual(Object object) {
    before();
    doActual(object);
    after();
}

protected abstract void doActual(Object object);