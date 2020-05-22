private void saveQueue(List<SeedNumber> detachedSeeds) {
    Queue queue = queueDAO.find("DEFAULT");

    SeedNumber sn = new SeedNumber();
    sn.setPhoneNumber("123456");
    sn.setQueue(q);
    seedNumberDao.saveSeed(sn);
    for (SeedNumber seed : detachedSeeds) {
        seed.setQueue(queue);
        seedNumberDao.saveSeed(seed);
    }
}