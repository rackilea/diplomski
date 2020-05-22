public ResponseEntity<DeviceResource> getDeviceById(
@ApiParam(value = "ID of the device", required = true)
@PathVariable String id,
HttpServletRequest request
) {
String auth = request.getHeader("X-NANO-APIKEY");
}