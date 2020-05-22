boolean bool1 = (zoektermselect.equals("Alle") && (dossiernaam.contains(zoekterm) || dossierexternepartij.contains(zoekterm)); 
boolean bool2 = (zoektermselect.equals("Dossiernaam") && dossiernaam.contains(zoekterm);
boolean bool3 = zoektermselect.equals("Externe partij") && dossierexternepartij.contains(zoekterm);
if(bool1 || bool2 || bool3){ 
    filterlist.add(dossier);
}