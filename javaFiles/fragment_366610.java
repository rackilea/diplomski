class BadNews {
  static Map<String,List<Object>> warnings = [:];

  static void warn(String key, Object uniqueStuff) {
    def knownWarnings = warnings[key]
    if (! knownWarnings) {
      knownWarnings = []
      warnings[key] = knownWarnings
    }
    knownWarnings << uniqueStuff
  }

  static void dumpWarnings(PrintStream out) {
    warnings.each{key, stuffs ->
      out.println("$key: " + stuffs.size())
      stuffs.each{
        out.println("\t$it")
      }
    }
  }
}

class SomewhereElse {
  def foo(Bar bar) {
    if (! bar)
      BadNews.warn("Empty bar", this)
  }
}