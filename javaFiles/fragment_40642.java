enum CrimeCategory {
  ASBO("Anti Social Behaviour"),
  BURG("Burglary"),
  CRIMDAM("Criminal Damage And Arson"),
  DRUGS("Drugs"),
  OTHTHEFT("Other Theft"),
  PUPDISOR("Public Disorder And Weapons"),
  ROBBERY("Robbery"),
  SHOPLIF("Shoplifting"),
  VEHICLE("Vehicle Crime"),
  VIOLENT("Violent Crime"),
  OTHER("Other Crime");

  private static final Map<String, CrimeCategory> map = new HashMap<>(values().length, 1);

  static {
    for (CrimeCategory c : values()) map.put(c.category, c);
  }

  private final String category;

  private CrimeCategory(String category) {
    this.category = category;
  }

  public static CrimeCategory of(String name) {
    CrimeCategory result = map.get(name);
    if (result == null) {
      throw new IllegalArgumentException("Invalid category name: " + name);
    }
    return result;
  }
}