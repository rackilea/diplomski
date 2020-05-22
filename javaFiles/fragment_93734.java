/**
   * Gets the correct index name if it is a index for a TABLE_PER_CLASS inheritance and longer than
   * 30 chars.
   *
   * @param index the index to decide for
   * @return the correct index name
   */
  private String getCorrectIndexName( Index index )
  {
    if ( index.getTable() instanceof DenormalizedTable && index.getName().length() > 30 )
    {
      String prefixedTable = index.getTable().getName();
      String tableName = prefixedTable.substring( prefixedTable.indexOf( '_' ) + 1, prefixedTable.length() );
      tableName = shortenName( tableName );
      Iterator<Column> columnItr = index.getColumnIterator();
      String reference;

      if ( columnItr.hasNext() )
      {
        reference = extractReference( columnItr.next() );
      }
      else
      {
        /** backup strategy to prevent exceptions */
        reference = shortenName( NamingHelper.INSTANCE.hashedName( index.getName() ) );
      }

      return tableName + "_" + reference;
    }
    return index.getName();
  }

  /**
   * Extract the reference column of the index and hash the full name before shortening it with
   * shortenName().
   *
   * @param index the index to extract the reference from.
   * @return the reference with an appended _FK(hashedReference).
   */
  private String extractReference( Column column )
  {
    String reference = column.getQuotedName( dialect );
    String md5Hash = NamingHelper.INSTANCE.hashedName( reference );
    md5Hash = md5Hash.substring( md5Hash.length() - 4, md5Hash.length() );
    reference = shortenName( reference );

    return reference + "_FK" + md5Hash;
  }

  /**
   * Shorten the name to a maximum of 11 chars if it's longer.
   *
   * @param reference the reference to shorten
   * @return the shortened string
   */
  private static String shortenName( String reference )
  {
    if ( reference.length() > 11 )
    {
      return reference.substring( 0, 11 );
    }
    return reference;
  }