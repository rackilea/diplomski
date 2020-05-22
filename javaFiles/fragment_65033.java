public final class SampleBusinessProcess {

    @PrePersist
    private void preperist(final MyObject obj) {
      entityManager.store(new Object2());
    }

 }