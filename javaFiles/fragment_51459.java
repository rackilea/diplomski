replacementVersions.each { k, v ->
  def orig = originalVersions[ k ]
  if( !orig || orig < v ) {
    println "Should replace $orig with $v"
  }
}