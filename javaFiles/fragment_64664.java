public void stopService() {
    if( attempt > 0 ){
        Util.logger.log(Level.INFO, "Stpoping F-Infra...");
        finfraService.stopService();
    }
}