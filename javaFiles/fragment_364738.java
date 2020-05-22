public boolean isLocalHost(@Nonnull final ServletRequest request) {
     if(settings == null) {
         return false;
     }

     String localhost = settings.getString(LOCALHOST);

     return localhost != null && localhost.equals(request.getServerName());
 }