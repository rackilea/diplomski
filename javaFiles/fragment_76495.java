Query query = session.createSQLQuery("SELECT
    XMLSERIALIZE
    (CONTENT
      XMLELEMENT
      (
        NAME \"ltc\\:DOAATLTC\",
        XMLATTRIBUTES
        (
          'http://www.edftrading.com/Trade/Common/DoaatLTC' AS \"xmlns\\:ltc\",
          'http://www.edftrading.com/Trade/Common/DoaatLTCHourlyNomination' AS \"xmlns\\:ltchnom\"
        ),
        XMLELEMENT ( ... ) FROM ...");