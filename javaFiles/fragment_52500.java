SELECT 
    FC.COD_FCD,
    FC.DSC_FCD, 
    DS.DSC_DSL ,
    FC.COD_EST_GNC, 
    FC.COD_HBT 
FROM SPFS_DT_FACUL FC 
INNER JOIN  SPFS_DT_DSPLG DS 
    ON FC.COD_DSL = DS.COD_DSL 
WHERE 
    FC.COD_AB='01' 
    AND 
        ( #{value1} IS NOT NULL AND FC.COD_FCD LIKE #{value1}||'%' )
        OR ( #{value2} IS NOT NULL AND FC.COD_FCD LIKE #{value2}||'%' )
    )