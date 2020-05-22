private static long checkout( SVNURL url , SVNRevision revision , File destPath , boolean isRecursive ) throws SVNException {

   SVNUpdateClient updateClient = ourClientManager.getUpdateClient( );
   /*
    * sets externals not to be ignored during the checkout
     */
    updateClient.setIgnoreExternals( false );
    /*
     * returns the number of the revision at which the working copy is 
    */
   return updateClient.doCheckout( url , destPath , revision , revision , isRecursive );