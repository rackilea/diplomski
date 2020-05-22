public class TVSerie {

private String titel;
private String description;
private LocalDate releaseDate;
private List<Episode> listeWithEpisods;

public TVSerie(){
    listeWithEpisods = new ArrayList<>();
}

public void addEpisode(Episode theEpisode) {
    listeWithEpisods.add(theEpisode);
    System.out.println(listeWithEpisods);
}