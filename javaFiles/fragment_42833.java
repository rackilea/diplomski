/**
 * Creates a new key ring with the given id.
 */
public static KeyRing createKeyRing(String projectId, String locationId, String keyRingId)
    throws IOException {
  // Create the Cloud KMS client.
  try (KeyManagementServiceClient client = KeyManagementServiceClient.create()) {

    // The resource name of the location associated with the KeyRing.
    String parent = LocationName.format(projectId, locationId);

    // Create the KeyRing for your project.
    KeyRing keyRing = client.createKeyRing(parent, keyRingId, KeyRing.newBuilder().build());

    return keyRing;
  }
}