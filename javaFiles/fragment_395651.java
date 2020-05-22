//Sort the tellers:
//ideally, call this only once, and insert future Tellers in order (to maintain ordering)
for(Bank bank : banks)
{
    for(List<Teller> tellers : bank.getTellers())
    {
        Collections.sort(tellers);
    }
}

//then, to get your top tellers:
for(Bank bank : banks)
{
    Teller bestTeller = bank.getTeller(0);
    Teller secondBestTeller = bank.getTeller(1);
    //...
}