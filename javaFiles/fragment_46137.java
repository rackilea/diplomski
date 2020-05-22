@InitBinder
public void initBinder( WebDataBinder binder){

     SimpleDateFormat simpleDateFormat=new SimpleDateFormat("MM/dd/yyyy");
            simpleDateFormat.setLenient(false);
            binder.registerCustomEditor( Date.class, new CustomDateEditor( simpleDateFormat,false));     

}