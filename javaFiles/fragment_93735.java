String indexName = getCorrectIndexName( index );
  indexNameForCreation = jdbcEnvironment.getQualifiedObjectNameFormatter()
      .format(
          new QualifiedNameImpl( index.getTable().getQualifiedTableName().getCatalogName(),
              index.getTable().getQualifiedTableName().getSchemaName(), jdbcEnvironment.getIdentifierHelper().toIdentifier( indexName ) ),
          jdbcEnvironment.getDialect() );