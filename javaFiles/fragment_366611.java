final JSONObject startLocation = step.getJSONObject("start_location");
final double startLat = startLocation.getDouble("lat");
final double startLng = startLocation.getDouble("lng");

final JSONObject endLocation = step.getJSONObject("end_location");
final double endLat = endLocation.getDouble("lat");
final double endLng = endLocation.getDouble("lng");