String acronymeministere = "YOOOO;"
String pays = "CA;"
String finalString = ""

payload.each { p ->

    String telephoneinternet = ";";
    String telephone = ";";
    String telecopieur = ";"
    String nomdefamille = ";";
    String prenom = ";";
    String initale =";"
    String qualificateurdegen = ";"
    String email = ";";
    String immeubleetsuffixe = ";"
    String odonyme = ";"
    String ville = ";";
    String province = ";";
    String codepostal = ";";
    String casepostale = ";"
    String bureau = ";"
    String etage = ";"
    String localisation = ";"
    String edifice = ";"
    String autres =";"

    if(p.streetAddress != null){
        String streetnumaddress = p.streetAddress;
        String[] parts = streetnumaddress.split(",");
        immeubleetsuffixe = parts[0].trim() + immeubleetsuffixe
        odonyme = parts[1].trim() + odonyme
    }

    telephoneinternet = p.telephoneNumber.toString().trim() + telephoneinternet
    telephone = p.telephoneNumber.toString().trim() + telephone
    nomdefamille = p.sn.toString().trim() + nomdefamille
    prenom = p.givenName.toString().trim() + prenom
    email = p.mail.toString().trim()    + email
    ville = p.l.toString().trim() + ville
    province = p.st.toString().trim() + province
    codepostal = p.postalCode.toString().trim() + codepostal


    finalString += ('"' + acronymeministere+telephoneinternet+telephone+telecopieur+nomdefamille
        +prenom+initale+qualificateurdegen+email+immeubleetsuffixe
        +odonyme+ville+province+codepostal+casepostale+pays+bureau+
        etage+localisation+edifice+autres+ '"'+'\n')
}

return finalString