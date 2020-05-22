@Autowire
public VaadinMainUI(BewohnerRepository bewohnerRepository) {
Grid<Bewohner> grid = new Grid<Bewohner>(Bewohner.class);
        Iterable<Bewohner> bewohnerList = bewohnerRepository.findAll();
        grid.setItems((Collection<Bewohner>) bewohnerList);
        add(grid);
}