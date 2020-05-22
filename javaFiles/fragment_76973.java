BlocoJpaController jpa = new BlocoJpaController();
    Condominio c = new Condominio();
    c.setIdcondominio(idcond);
    bloco.setCondominio(c);
    jpa.create(bloco);

    return ("redirect:bloco.htm");

}