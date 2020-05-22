public void insertToCourierUploadQueue(String crp_code, String courier_name){Session session1 = sessionFactory.openSession();
        CourierUploadQueue courierUploadQueue = new CourierUploadQueue();
        courierUploadQueue.setCrp_code(crp_code);
        courierUploadQueue.setCourier_name(courier_name);
        courierUploadQueue.setLast_update(new Date());
        courierUploadQueue.setTime_created(new Date());
        courierUploadQueue.setRetry_count(0);
        courierUploadQueue.setStatus(CourierUploadQueueStatus.Status.PENDING);
        session1.save(courierUploadQueue);
        session1.close();}