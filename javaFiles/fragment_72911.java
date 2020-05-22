@RestController
@RequestMapping("/api")
public class CardGeneratedResource {
@RequestMapping(value = "/cardGenerated/{branchCode}/{cardType}",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)
    @Timed
    public ResponseEntity<CardGenerated> get(@PathVariable("branchCode") String branchCode,
                                             @PathVariable("cardType") String cardType,
                                             HttpServletResponse response) {

        log.debug("REST request to get CardGenerated : " + branchCode + " and " + cardType);

        CardGenerated cardGenerated = cardGeneratedRepository.
                findTopByBranchCodeAndCardTypeOrderByCardNumberDesc(branchCode, cardType);

        if (cardGenerated == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(cardGenerated, HttpStatus.OK);
    }
}