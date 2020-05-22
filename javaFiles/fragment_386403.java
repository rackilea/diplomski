SELECT DISTINCT CASE WHEN dummy.id = 1 THEN r.bic_crspndt
                     WHEN dummy.id = 2 THEN r.bic_issr
                END AS bics_rma
FROM   (SELECT rma.crspdt AS bic_crspndt,
               rma.issr   AS bic_issr
        FROM   rma
        WHERE  (rma.tp = 'Issued' OR rma.tp = 'Received')
        AND    rma.rmasts = 'Enabled'
        AND    rma.svcnm = 'swift.fin') r
       INNER JOIN (SELECT 1 ID FROM dual UNION ALL
                   SELECT 2 ID FROM dual) dummy ON (dummy.id = 1 AND r.crspdt IS NOT NULL)
                                                   OR (dummy.id = 2 AND r.issr IS NOT NULL);