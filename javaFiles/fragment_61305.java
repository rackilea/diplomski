try{
     Bids bids = BidParser.parse( bidsInput );
     BidChecker.check(bids, var1);
     Maps.update(bids, var2);
} catch (...){
}