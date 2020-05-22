private static void LoadMap()
        {
            StructureMap.Pipeline.SmartInstance<ConcreteService> ServicePipeline = StructureMap.StructureMapConfiguration.ForRequestedType<IService>().TheDefault.Is.OfConcreteType<ConcreteService>();
            IPServicePipeline.WithCtorArg("serviceIP").EqualTo("192.168.0.1");
            StructureMap.StructureMapConfiguration.ForRequestedType<IDataRepository>().TheDefaultIsConcreteType<MySqlDataRepository>();
}