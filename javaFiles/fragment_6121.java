public class BetriebspunktExtractor extends ValueExtractor<Betriebspunkt, String> implements Serializable {
  @Override
  public void extract(final Betriebspunkt betriebspunkt, final String argument, final ValueCollector valueCollector) {
    betriebspunkt.getVersionen().stream()
                 .map(BetriebspunktVersion::getZusatzbetriebspunkte)
                 .flatMap(List::stream)
                 //.map(zbp -> zbp.getUicLand() + "_" + zbp.getNummer())
                 .forEach(valueCollector::addObject);
  }
}