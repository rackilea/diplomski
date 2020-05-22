String resourceGroupName = "<your-resource-group-name>";
String providerNamespace = "Microsoft.DBforPostgreSQL";
String resourceType = "servers";
String resourceName = "<your-resource-name>";
GenericResource gr = azure.genericResources().get(resourceGroupName, providerNamespace, resourceType,
            resourceName);
System.out.println(gr.name() + "\t" + gr.resourceProviderNamespace() + "/" + gr.resourceType());