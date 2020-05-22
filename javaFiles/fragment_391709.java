Network.DefinitionStages.WithCreate creatableNetwork = azure.networks()
                    .define(networkName)
                    .withRegion(region)
                    .withExistingResourceGroup(resourceGroup)
                    .withAddressSpace("10.0.0.0/20")
                    .defineSubnet(subnetName)
                        .withAddressPrefix("10.0.0.0/20")
                        .withExistingNetworkSecurityGroup(NSG)
                        .attach();