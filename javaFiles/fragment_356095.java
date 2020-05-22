List<Range> newAccountRanges = account.getRanges().stream()
  .map( accountRange -> new Range( 
    accountRange.getRangeId(),
    accountRange.getRangeType(),
    findMatchingUsers( accountRange ) ) )
  .collect( Collectors.toList() );
...
List<UserDetails> findMatchingUsers( Range forAccount ) {
  resultUesrList.stream()
    .filter( user -> user.getRanges().stream()
       .anyMatch( userRange -> checkRange( forAccount, userRange ) )
    .collect( Collectors.toList() );
...
boolean checkRange( Range forAccount, Range forUser ) {
  return forAccount.getRangeId().equals( forUser.getRangeId() ) &&
    forAccount.getRangeType().equals( forUser.getRangeType() );
}