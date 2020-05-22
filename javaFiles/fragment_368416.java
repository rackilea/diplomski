@RestController
@ExposesResourceFor(Booleans.class)
@RequestMapping("/booleans")
public class BooleansController {

    public static final String TRUE = "true";
    public static final String FALSE = "false";
    public static final String TRUEFALSE = "truefalse";

    @Autowired
    private EntityLinks entityLinks;

    @RequestMapping(value = "/{booleansId}",
            produces = { "application/hal+json", "application/json" },
            method = RequestMethod.GET)
    public ResponseEntity<Booleans> getBooleans(@PathVariable("booleansId") String booleansId) {
        return getResource(booleansId)
                .map(r -> new ResponseEntity<>(r, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    private Optional<Booleans> getResource(String id)  {
        switch (id) {
            case TRUE:
                final Booleans trueInstance = new Booleans().addValuesItem(true);
                trueInstance.add(entityLinks.linkToSingleResource(Booleans.class, TRUE));
                return Optional.of(trueInstance);
            case FALSE:
                final Booleans falseInstance = new Booleans().addValuesItem(false);
                falseInstance.add(entityLinks.linkToSingleResource(Booleans.class, FALSE));
                return Optional.of(falseInstance);
            case TRUEFALSE:
                final Booleans truefalseInstance = new Booleans().addValuesItem(true).addValuesItem(false);
                truefalseInstance.add(entityLinks.linkToSingleResource(Booleans.class, TRUEFALSE));
                return Optional.of(truefalseInstance);
            default:
                return Optional.empty();
        }
    }

}