future.stream().filter(i -> {
    try {
        return i.get().get("success").equals(Boolean.FALSE);
    } catch (InterruptedException e) {
        e.printStackTrace();
    } catch (ExecutionException e) {
        e.printStackTrace();
    }
    return false; // depending on what you wish to return in case of exception
}).findAny().get().get();