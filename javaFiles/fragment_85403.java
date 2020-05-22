public class WSDLFilterBehavior : IWsdlExportExtension, IEndpointBehavior
{
    public void ExportContract(WsdlExporter exporter, WsdlContractConversionContext context)
    {
        // never called
    }

    public void ExportEndpoint(WsdlExporter exporter, WsdlEndpointConversionContext context)
    {
        var schemas = exporter.GeneratedXmlSchemas.Schemas(@"http://Abc/Services/Data");
        foreach (XmlSchema schema in schemas)
        {
            for (int i = schema.Items.Count - 1; i >= 0; --i)
            {
                // Do some other processing ...

                var schemaComplexType = schema.Items[i] as XmlSchemaComplexType;
                if (schemaComplexType == null)
                {
                    continue;
                }

                XmlSchemaSequence xmlSchemaSequence;
                var xmlSchemaContentModel = schemaComplexType.ContentModel;
                if (xmlSchemaContentModel == null)
                {
                    if (schemaType.Name.StartsWith("ArrayOf"))
                    {
                        continue;
                    }
                    xmlSchemaSequence = schemaComplexType.Particle as XmlSchemaSequence;
                }
                else
                {
                    var xmlSchemaComplexContentExtension = xmlSchemaContentModel.Content as XmlSchemaComplexContentExtension;
                    if (xmlSchemaComplexContentExtension == null)
                    {
                        continue;
                    }

                    xmlSchemaSequence = xmlSchemaComplexContentExtension.Particle as XmlSchemaSequence;
                }

                if (xmlSchemaSequence == null)
                {
                    continue;
                }

                var xmlSchemaObject = new XmlSchemaAny
                {
                    MinOccurs = 0
                };
                xmlSchemaSequence.Items.Add(xmlSchemaObject);
            }
        }
    }

    public void AddBindingParameters(ServiceEndpoint endpoint, BindingParameterCollection bindingParameters)
    {
        // not needed
    }

    public void ApplyClientBehavior(ServiceEndpoint endpoint, ClientRuntime clientRuntime)
    {
        // not needed
    }

    public void ApplyDispatchBehavior(ServiceEndpoint endpoint,EndpointDispatcher dispatcher)
    {
        // not needed
    }

    public void Validate(ServiceEndpoint endpoint)
    {
        // not needed
    }
}