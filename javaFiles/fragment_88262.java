public class EnergyAction extends ActionSupport
    {
        private Object siteData;

        @Override
        public String execute()
                throws Exception {
            //Get the site Data
            EnergyAnalysisBusinessHandler handler = new EnergyAnalysisBusinessHandler();
            siteData = handler.getSiteData();
            return SUCCESS;
       }

        public void setSiteData(Object siteData){
            this.siteData = siteData;
        }

        public Object getSiteData(){
            return siteData;
        }
    }