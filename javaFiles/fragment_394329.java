@GetMapping("vendor/{vendorID}")
  public ResponseEntity<Set<DeviceDto>> findDevicesByVendor(@PathVariable String vendorID) {
    return ResponseEntity.ok(deviceService.findAllDevicesByVendor(vendorID));
  }

  @GetMapping("model/{modelID}")
  public ResponseEntity<Set<DeviceDto>> findDevicesByModel(@PathVariable String modelID) {
    return ResponseEntity.ok(deviceService.findAllDevicesByModel(modelID));
  }