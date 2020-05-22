application {
  config {
    applicationType gateway,
    serviceDiscoveryType consul,
    authenticationType jwt,
    skipUserManagement false
    skipClient true
  }
}