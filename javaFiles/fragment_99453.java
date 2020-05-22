@Deprecated
public Map<String, LocalDate> getPlatforms(){
  Map<String,LocalDate> ret = new HashMap<>();

  gamePlatforms.stream().forEach(gamePlatform -> {
    ret.put(gamePlatform.getPlatform().getName(), gamePlatform.getReleaseDate());
  });

  return ret;
}