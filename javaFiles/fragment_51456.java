class LibVersion implements Comparable {
  String filename
  String library
  String version

  // Just compare the String versions.
  // This is naïve, and should probably be improved
  int compareTo( Object other ) {
    version <=> other.version
  }

  String toString() {
    "$library: $version"
  }

  static fromFilename( String s ) {
    def matcher = ( s =~ $/.+/(.+?)-([0-9\.]+(?:-.+?){0,1})\.jar/$ )[0]
    new LibVersion( filename: s, library: matcher[ 1 ], version: matcher[ 2 ] )
  }
}