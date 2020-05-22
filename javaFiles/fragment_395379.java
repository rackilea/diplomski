SELECT
  state,
  GooCount,
  GooCount   / Total AS AVG_GOO,
  sCOPECount,
  SCOPECount / Total AS AVG_SCOPE,
  FBCOunt, 
  FBCount    / Total AS AVG_FB,
  PALCount,
  PALCount   / Total AS AVG_PAL
FROM
(
    select
      state,
      SUM(CASE WHEN COMPANY_NAME = 'GOO'   THEN 1 ELSE 0 END) AS GooCount, 
      SUM(CASE WHEN COMPANY_NAME = 'SCOPE' THEN 1 ELSE 0 END) AS SCOPECount, 
      SUM(CASE WHEN COMPANY_NAME = 'FB'    THEN 1 ELSE 0 END) AS FBCount, 
      SUM(CASE WHEN COMPANY_NAME = 'PAL'   THEN 1 ELSE 0 END) AS PALCount,    
      COUNT(*) AS total
    from company_details 
    where company_status = 'OPEN'
    group by state order by state
) AS sub;