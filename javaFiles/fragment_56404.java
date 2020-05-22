ApnsService service = null;

        service = APNS.newService()
                .withCert(certificatePath, certificatePassword)
                .withProductionDestination()
                .asPool(threadCount)
                .build();


        service.start();