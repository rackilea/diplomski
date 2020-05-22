class Response
  List<PlacesTextSearch> results;

class PlacesTextSearch
  String formatted_address;
  Geometry geometry;
  String icon;
  String id;
  String name;
  List<String> types;

class Geometry
  Location location;

class Location
  long lat;
  long lng;