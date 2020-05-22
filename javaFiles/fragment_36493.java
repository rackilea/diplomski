for (int i = 0; i < 10; i++) {
    Future f = service.submit(() -> manager.incrementAndReport());
    try {
        System.out.println (f.get ());
    }
    catch (ExecutionException exex) {
        System.out.println (exex);
    }
    catch (InterruptedException intEx) {
        System.out.println (intEx);
    }
}