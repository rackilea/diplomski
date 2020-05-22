final Boolean preferGeneratorNameAsDefaultName = serviceRegistry.getService( ConfigurationService.class )
            .getSetting( AvailableSettings.PREFER_GENERATOR_NAME_AS_DEFAULT_SEQUENCE_NAME, StandardConverters.BOOLEAN, true );
if ( preferGeneratorNameAsDefaultName ) {
    final String generatorName = params.getProperty( IdentifierGenerator.GENERATOR_NAME );
    if ( StringHelper.isNotEmpty( generatorName ) ) {
        fallbackSequenceName = generatorName;
    }
}