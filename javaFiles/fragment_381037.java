while (!operation.getStatus().equals("DONE")) {
   RegionOperations.Get getOperation = compute.regionOperations().get(
              PROJECT_ID, REGION_NAME, operation.getName());
   operation = getOperation.execute();
}
if (operation.getError() == null) {
  // targetPools has been successfully created
}