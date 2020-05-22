@GetMapping("/kotizacije_cjenovnik/{id}")
@Timed
public List<KotizacijeCjenovnik> getKotizacijeByKotizacijaId(@PathVariable BigInteger id) {
    log.debug("REST request to get Kotizacija : {}", id);
    Kotizacija kotizacija = new Kotizacija();
    kotizacija.setId(id);
    List<KotizacijeCjenovnik> kotizacija_cjenovnik = kotizacijaCjenovnik.getKotizacijeByKotizacija(kotizacija);
    return kotizacija_cjenovnik;
}