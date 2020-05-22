Endpoint.publish("http://localhost:8080/ws/hello", new Service1Soap()
{

    @Override
    public String uparivanje(String datum, String spisakTransakcija)
    {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void storno(String idTransakcijaStornoPosta, String idTransakcijaPosta, String posta, String idRadnik, String datumVreme, Holder<String> stornoResult, Holder<String> idTransakcijaStornoExt, Holder<String> brojTelefona, Holder<String> username)
    {
        // TODO Auto-generated method stub

    }

    @Override
    public void echo(String datumVremePosta, Holder<String> echoResult, Holder<String> datumVremeExt)
    {
        // TODO Auto-generated method stub
    }

    @Override
    public void dopuna(String idTransakcijaPosta, String idKorisnik, String iznos, String posta, String idRadnik, String datumVreme, Holder<String> dopunaResult, Holder<String> idTransakcijaExt, Holder<String> brojTelefona, Holder<String> username)
    {
        // TODO Auto-generated method stub

    }
});