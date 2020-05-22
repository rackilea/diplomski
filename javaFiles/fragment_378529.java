// Java - prior to fireAllRules
   StatefulKnowledgeSession kSession() = ruleBase.newStatefulSession();

   List<?> list = new ArrayList();
   kSession.setGlobal( "eligInqList", list );

   // DRL
   global java.util.List eligInqList;

   // in a rule
   then
       EligibilityInquiry fact0 = new EligibilityInquiry(); 
       fact0.setServiceName( "ABCD" ); 
       fact0.setMemberStatus( true ); 
       insert(fact0 );  
       eligInqList.add( fact0 ); 
   end

   // after return from fireAllRules
   for( Object elem: list ){
    System.out.println( eligInqClass.cast( elem ) );
   }