Service myservice = client.services().inNamespace(parsedNamespaceStr).createNew()
                     .withNewMetadata()
                       .withName(parsedServiceName)
                       .addToLabels(parsedLabel1, parseLabel2)
                     .endMetadata()
                     .done();