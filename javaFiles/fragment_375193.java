for (Future<String> r : returns) {
    try {
        String temp = r.get();
        System.out.println("returned " + temp);
    } catch (InterruptedException e) {
        System.out.println("Interrupted Exception catch");
        e.printStackTrace();
    } catch (ExecutionException e) {
        System.out.println("Execution Exception catch");
        e.printStackTrace();
    }
}