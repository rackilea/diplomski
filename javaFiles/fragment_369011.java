//Pair is org.apache.commons.lang3.tuple.Pair, you could also provide your own class
Map<Pair<Date, Date>, TauxPeriodesATDto> combined = new LinkedHashMap<>();

for( TauxPeriodesATDto element : tauxPeriodesATDtos ) {
  Pair<Date, Date> key = Pair.of( element.getDateDebut(), element.getDateFin() );
  TauxPeriodesATDto existing = combined.get( key );

  if( existing != null ) {
    //duplicate already exists, so combine the two
    existing.setTauxPrimeAT( existing.getTauxPrimeAT().add( element.getTauxPrimeAT() );
  } else {
    //no duplicate yet
    combined.put( key, element );
  }      
}

//due to the use of LinkedHashMap the order of elements should be preserved
List<TauxPeriodesATDto> resultList = new ArrayList<>( combined.values() );