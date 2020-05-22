Azure azure = Azure.configure().withLogLevel(LogLevel.NONE)
        .authenticate(credFile).withDefaultSubscription();
String resourceGroupName = "<your-resource-group-name>";
String providerNamespace = "Microsoft.DBforPostgreSQL";
Iterator<GenericResource> iter = azure.genericResources().listByResourceGroup(resourceGroupName).iterator();
/*
 * List all resource without resource group
 * Iterator<GenericResource> iter = azure.genericResources().list().iterator();
 */
while (iter.hasNext()) {
    GenericResource gr = iter.next();
    if (providerNamespace.equals(gr.resourceProviderNamespace()))
        System.out.println(gr.name() + "\t" + gr.resourceProviderNamespace() + "/" + gr.resourceType());
}