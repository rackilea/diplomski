CLEANUP_REQUIRED = true
Runtime.runtime.addShutdownHook {
  println "Shutting down..."
  if( CLEANUP_REQUIRED ) {
    println "Cleaning up..."
  }
}
(1..10).each {
  sleep( 1000 )
}
CLEANUP_REQUIRED = false