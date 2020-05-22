try{
        List<ContactType> list= ofy
            .load()
            .type(ContactType.class)
            .list();  
        int size = list.size();
    }catch(LoadException e){
        String message = e.getMessage();
    }