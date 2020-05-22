@DataBoundConstructor
public SonarInstallation(String name,
  String serverUrl, String serverAuthenticationToken,
  String mojoVersion, String additionalProperties, TriggersConfig triggers,
  String additionalAnalysisProperties) {
  this.name = name;
  this.serverUrl = serverUrl;
  this.serverAuthenticationToken = serverAuthenticationToken;
  this.additionalAnalysisProperties = additionalAnalysisProperties;
  this.mojoVersion = mojoVersion;
  this.additionalProperties = additionalProperties;
  this.triggers = triggers;
}