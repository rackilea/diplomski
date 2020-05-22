rule  "Your First Rule"
  timer( int:5s )
when
then
  System.out.println("Finished");
  drools.halt();
end