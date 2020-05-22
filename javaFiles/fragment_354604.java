public int buildQuery4SConsistencyCheck(Societe societe,Date periode) throws 
 TechnicalNGEException {
    String sql="select SUM(INTERNAL_AMOUNT) from (select   vR.montant_valorise as 
    INTERNAL_AMOUNT"
        + " from sigma02.valorisation_location vR inner join sigma02.eds  soc on 
              vR.societe=soc.id_eds "
        + "inner join sigma02.chantier  ch on vR.compte_de_recette=ch.id_eds"
        + " inner join sigma02.edsm on  vR.id_edsm=edsm.id_edsm inner join sigma02.eds  "
        + "edsR on vR.compte_de_recette=edsR.id_eds where vR.montant_facture !=0 and 
               vR.statut_traitment "
        + "like 'F' and vR.societe = 11 and vR.date_piece='2018-1-31' union all 
    select vDep.montant_valorise as INTERNAL_AMOUNT  FROM 
       sigma02.valorisation_location"
        + " vDep inner join sigma02.eds soc on vDep.societe=soc.id_eds "
        + "inner join sigma02.eds as edsDep on vDep.chantier_materiel=edsDep.id_eds "
        + "inner join sigma02.chantier as chDep on 
           vDep.chantier_materiel=chDep.id_eds"
        + " inner join sigma02.edsm on vDep.id_edsm=edsm.id_edsm  WHERE 
           vDep.montant_facture<>0"
        + " and vDep.statut_traitment='F' and vDep.societe=11 and 
               vDep.date_piece='2018-1-31'  ) 
        as somme";       
    int result =-1;
        try {
            SQLQuery query = session.createSQLQuery(sql);
                 // cast 
             result = ((BigDecimal) query.uniqueResult()).intValue();


        } catch (HibernateException e) {
            bloqException(e);
        }

        return result;


}