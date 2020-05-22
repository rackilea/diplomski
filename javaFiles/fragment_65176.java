public static void main(String[] args) throws java.lang.Exception{


        ContainerURL containerURL;

        // Creating a sample file to use in the sample
        File sampleFile = null;

        try {
            sampleFile = File.createTempFile("downloadedFile", ".txt");

            // Retrieve the credentials and initialize SharedKeyCredentials
            String accountName = "xxxxxx";
            String accountKey = "xxxxxxx";

            // Create a ServiceURL to call the Blob service. We will also use this to construct the ContainerURL
            SharedKeyCredentials creds = new SharedKeyCredentials(accountName, accountKey);
            // We are using a default pipeline here, you can learn more about it at https://github.com/Azure/azure-storage-java/wiki/Azure-Storage-Java-V10-Overview
            final ServiceURL serviceURL = new ServiceURL(new URL("https://" + accountName + ".blob.core.windows.net"), StorageURL.createPipeline(creds, new PipelineOptions()));

            // Let's create a container using a blocking call to Azure Storage
            // If container exists, we'll catch and continue
            containerURL = serviceURL.createContainerURL("quickstart");

            try {
                ContainerCreateResponse response = containerURL.create(null, null, null).blockingGet();
                System.out.println("Container Create Response was " + response.statusCode());
            } catch (RestException e){
                if (e instanceof RestException && ((RestException)e).response().statusCode() != 409) {
                    throw e;
                } else {
                    System.out.println("quickstart container already exists, resuming...");
                }
            }

            // Create a BlockBlobURL to run operations on Blobs
            final BlockBlobURL blobURL = containerURL.createBlockBlobURL("SampleBlob.txt");

            System.out.println("Uploading the sample file into the container: " + containerURL );
            AsynchronousFileChannel fileChannel = AsynchronousFileChannel.open(sampleFile.toPath());


            // Uploading a file to the blobURL using the high-level methods available in TransferManager class
            // Alternatively call the PutBlob/PutBlock low-level methods from BlockBlobURL type
            TransferManager.uploadFileToBlockBlob(fileChannel, blobURL, 8*1024*1024, null, null)
                    .subscribe(response-> {
                        System.out.println("Completed upload request.");
                        System.out.println(response.response().statusCode());
                    });

            Thread.sleep(2000);

        } catch (InvalidKeyException e) {
            System.out.println("Invalid Storage account name/key provided");
        } catch (MalformedURLException e) {
            System.out.println("Invalid URI provided");
        } catch (RestException e){
            System.out.println("Service error returned: " + e.response().statusCode() );
        } catch (IOException e) {
            e.printStackTrace();
            System.exit(-1);
        }
    }