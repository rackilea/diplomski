SELECT company.name,
       SUM(bill.amount) - SUM(cheque.amount) AS amount
FROM       imone     AS company
INNER JOIN saskaitos AS bill   ON company.id   = bill.imone
LEFT  JOIN kvitai    AS cheque ON bill.sask_nr = cheque.sask_nr
GROUP BY company.name;