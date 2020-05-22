@GET
@Path("{id}")
// CDI is now able to continue the transaction opened by walletBusiness
// Shut it down there
@Transactional(Transactional.TxType.NEVER)
public Wallet getWallet(@PathParam("id") int walletId){

    JpaWallet wallet = walletBusiness.findWallet(walletId);

    // No more propagation. 
    wallet.getLines().stream().forEach(jpaLine -> jpaLine.setWallet(null));

    return wallet;
}