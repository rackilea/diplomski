// DRL code
query "eligInqs" 
    eligInq : EligibilityInquiry()
end

// after return from fireAllRules
QueryResults results = workingMemory.getQueryResults( "eligInqs" );
for ( QueryResultsRow row : results ) {
    Object eligInqObj = row.get( "eligInq" );
    System.out.println( eligInqClass.cast( eligInqObj ) );
}