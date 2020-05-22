@NonCPS
String getVersion(String binaryName) {
  def matches = (binaryName =~ /(V)(\d+)(_)(\d+)(_)(Build)(_)(\d+)/)
  versionTag = ""+matches[0].getAt(0)
  versionTag
}