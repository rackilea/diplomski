excludedJars in assembly := {
  val cp = (fullClasspath in assembly).value
  cp filter {f =>
     f.data.getName.contains("spark"),
     f.data.getName.startsWith("jar_name")
  }
}