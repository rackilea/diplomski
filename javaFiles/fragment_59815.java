SQL> select utl_match.jaro_winkler_similarity( '001 Chestnut Avenue',
  2                                            '1 Chestnut Avenue' )
  3    from dual;

UTL_MATCH.JARO_WINKLER_SIMILARITY('001CHESTNUTAVENUE','1CHESTNUTAVENUE')
------------------------------------------------------------------------
                                                                      96