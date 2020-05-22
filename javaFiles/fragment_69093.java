SELECT pr.NAME,
       pr.date_phy,
       pr.code,
       pd.totalAmount+pr.advance as TotalPaid,
pa.totalatten as TotalPresent
FROM   physiofit_registration pr
       LEFT JOIN (SELECT code,Sum(amount) totalAmount
                  FROM   physiofit_deposit
           group by code
                  ) pd
              ON (pr.code = pd.code)
          LEFT JOIN (SELECT code,Count(*) totalatten
                  FROM   physiofit_attendence
                  GROUP  BY code) pa
           ON pr.code = pa.code;