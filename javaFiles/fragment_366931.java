public Fenetre(Interface uneinterface) 
{
    this.ninja = uneinterface;
    try 
    {
        Piece[] unpool = ninja.PoolPieces();
        this.setBoutons(unpool);
    } 
    catch (RemoteException e) 
    {
        e.printStackTrace();
    }