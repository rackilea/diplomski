select id_activity, sum(cost_hn) as sm_cost_hn, sum(cost_hs) as sm_cost_hs, (sum(cost_hn)+sum(cost_hs)) as cost_activity 
from (
  select id_salarie, 
         concat(nom, ' ', prenom) as np, 
         hour_salary, 
         id_chantier, 
         id_activity, 
         SUM(nb_heures) as s_hn, 
         SUM(nb_heures_s) as s_hs, 
         value_update, 
         (hour_salary*SUM(nb_heures)) as cost_hn, 
         ((hour_salary*value_update)*SUM(nb_heures_s)) as cost_hs 
  from pointage_full pf, salarie s, hs_increase hsi 
  where s.id = pf.id_salarie 
  and hsi.etat = 1 
  and id_chantier = ?
  and id_salarie <> id_chef 
  group by id_salarie, np, hour_salary, id_activity, id_chantier, value_update 
) as recap
group by id_activity 
order by id_activity asc;