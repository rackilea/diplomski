@PostLoad 
void onPostLoad() {
   if (contacter == null) {
      contacter = new ContacterInfo();
   }
   if (company == null) {
      company = new CompanyInfo();
   }
}