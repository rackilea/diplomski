SharedAccessBlobPolicy sp = createSharedAccessPolicy(
                EnumSet.of(SharedAccessBlobPermissions.READ, SharedAccessBlobPermissions.LIST), 300);
        BlobContainerPermissions perms = new BlobContainerPermissions();

        perms.getSharedAccessPolicies().put("readperm", sp);
        this.container.uploadPermissions(perms);
        Thread.sleep(30000);

        CloudBlockBlob sasBlob = new CloudBlockBlob(new URI(this.blob.getUri().toString() + "?"
                + this.blob.generateSharedAccessSignature(null, "readperm")));