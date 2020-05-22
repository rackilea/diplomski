try {
     loadClientUserData( context, logging );
     loadMBeans( context, logging );
} catch (ManagerException e) {
     throw new RuntimeException( "Error during startup of service !!!" );
}