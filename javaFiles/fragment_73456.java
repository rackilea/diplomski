public MyService undecorate(MyService service) {
    if (service instanceof MyServiceDelegate) {
        return undecorate(((MyServiceDelegate) service).getDecoratedService());
    }
    else {
        return service;
    }
}