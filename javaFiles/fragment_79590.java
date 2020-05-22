private Locale locale(){
    Locale locale=null;     
        if(country == null || country.equals("null")){
            locale = setLanguage();                 
        }else{          
            locale = new Locale(language, country);
        }
return locale;
}