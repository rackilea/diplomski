String network = findNetworkIdOfService("vote")
chrome.withNetworkMode(network)

private String findNetworkIdOfService(String service) {
        environment.ambassadorContainers.find {
            it.key.contains(service)
        }.value.containerInfo.networkSettings.networks.values().first().networkID
}