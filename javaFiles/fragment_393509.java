INSERT INTO import_xml (
  EXCHNAM,
  ENVTEXT,
  RPTCOD,
  RPTNAM,
  RPTFLEXKEY,
  MEMBID,
  MEMBLGLNAM,
  RPTPRNTEFFDAT,
  RPTPRNTRUNDAT,
  PARTICIPANT
)
SELECT EXCHNAM,
       ENVTEXT,
       RPTCOD,
       RPTNAM,
       RPTFLEXKEY,
       MEMBID,
       MEMBLGLNAM,
       RPTPRNTEFFDAT + ( TO_TIMESTAMP( RPTPRNTEFFTIM, 'HH24:MI:SS.FF2' )
                       - TO_TIMESTAMP( '00:00:00.00', 'HH24:MI:SS.FF2' ) ),
       RPTPRNTRUNDAT,
       PARTICIPANT
FROM   XMLTABLE(
         XMLNAMESPACES( DEFAULT 'http://www.eu.com/technology' ),
         '//fd115'
         PASSING XMLType( your_xml )
         COLUMNS
           EXCHNAM        VARCHAR2(50)  PATH './rptHdr/exchNam',
           ENVTEXT        VARCHAR2(20)  PATH './rptHdr/envText',
           RPTCOD         VARCHAR2(20)  PATH './rptHdr/rptCod',
           RPTNAM         VARCHAR2(180) PATH './rptHdr/rptNam',
           RPTFLEXKEY     VARCHAR2(180) PATH './rptHdr/rptFlexKey',
           MEMBID         VARCHAR2(50)  PATH './rptHdr/membId',
           MEMBLGLNAM     VARCHAR2(80)  PATH './rptHdr/membLglNam',
           RPTPRNTEFFDAT  TIMESTAMP     PATH './rptHdr/rptPrntEffDat',
           RPTPRNTEFFTIM  VARCHAR2(50)  PATH './rptHdr/rptPrntEffTim',
           RPTPRNTRUNDAT  DATE          PATH './rptHdr/rptPrntRunDat',
           PARTICIPANT    VARCHAR2(50)  PATH './fd115Grp/fd115KeyGrp/participantGrp/participant'
       );