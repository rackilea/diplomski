public void manageException(Runnable r) {
    try {
        r.run();
    }
    catch (NestedRuntimeException nre) {
        throw new MyCustomException(444, nre);
    }
    catch (HibernateException he) {
        throw new MyCustomException(555, he);
    }
    catch (Exception e) {
        throw new MyCustomException(666, e);
    }
}