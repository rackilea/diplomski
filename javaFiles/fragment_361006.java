for(Nodo nodoPai : nodosBase)
{
    Collection<Nodo> filhos = nodoPai.gerarFilhos();
    for(Nodo filho : filhos)
    {
        if( idsPercorridos.contains( filho.getId() ) == false )
        {
            novaFronteira.add( filho );
        }
    }
}