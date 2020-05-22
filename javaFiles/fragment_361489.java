String accountName = "<your-storage-account-name>";
String accountKey = "<your-storage-account-key>";
String storageConnectionString = "DefaultEndpointsProtocol=https;AccountName=%s;AccountKey=%s";
String connectionString = String.format(storageConnectionString, accountName, accountKey);
CloudStorageAccount account = CloudStorageAccount.parse(connectionString);
CloudBlobClient client = account.createCloudBlobClient();
// List all containers of a storage account
Iterable<CloudBlobContainer> containers = client.listContainers();
String prefix = null;
boolean useFlatBlobListing = true;
// Specify the blob list which include snapshot blob
EnumSet<BlobListingDetails> listingDetails = EnumSet.of(BlobListingDetails.SNAPSHOTS);
BlobRequestOptions options = null;
OperationContext opContext = null;
for (CloudBlobContainer container : containers) {
    Iterable<ListBlobItem> blobItems = container.listBlobs(prefix, useFlatBlobListing, listingDetails, options,
                    opContext);
    for (ListBlobItem blobItem : blobItems) {
        if (blobItem instanceof CloudBlob) {
            CloudBlob blob = (CloudBlob) blobItem;
            // Check a blob whether be a snapshot blob
            if (blob.isSnapshot()) {
                System.out.println(blobItem.getStorageUri());
            }
        }
    }
}