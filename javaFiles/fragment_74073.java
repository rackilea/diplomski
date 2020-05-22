@Inject
public MyObject(Map<String, Provider<Snack>> snackProviderMap, Properties properties) {
  String snackType = (String) properties.get("snackType");
  Provider<Snack> = snackProviderMap.get(property);

  // etc.
}