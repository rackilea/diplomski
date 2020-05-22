CREATE MATERIALIZED VIEW quasar_evaludated_function_mv AS select 
                a.id as id,
                (select count(f) from quasar_qs_auditor_code f where  f.auditor_id = a.id and f.is_granted = true) >  0 as is_qs_auditor,
                (select count(f) from quasar_product_assessor_a_code f where  f.auditor_id = a.id and f.is_granted = true) >  0 as is_product_assessor_a,
                (select count(f) from quasar_product_assessor_r_code f where  f.auditor_id = a.id and f.is_granted = true) >  0 as is_product_assessor_r, 
                (select count(f) from quasar_product_specialist_code f where  f.auditor_id = a.id and f.is_granted = true) >  0 as is_product_specialist,
                (select count(f) from quasar_technical_expert_code f where  f.auditor_id = a.id and f.is_granted = true) >  0 as is_technical_expert,
                (select count(f) from quasar_clinical_expert_code f where  f.auditor_id = a.id and f.is_granted = true) >  0 as is_clinical_expert, 
                (select count(f) from quasar_responsible_clinician_code f where  f.auditor_id = a.id and f.is_granted = true) >  0 as is_responsible_clinician
                from quasar_auditor a;

    CREATE VIEW quasar_evaludated_function  AS SELECT mv.* from quasar_evaludated_function_mv mv;