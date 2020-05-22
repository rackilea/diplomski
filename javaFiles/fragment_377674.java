Collections.sort(listEventosAll,  new Comparator<Evento> (){
    public int compare(Evento evento1, Evento evento2) {
        if(evento1.date.getTime() == evento2.date.getTime()) 
            System.out.println("Warning! Two references pointing to the same object!");
         if (evento1.date.getTime() == null || evento2.date.getTime() == null)
             return 0;
         return evento1.date.getTime().compareTo(evento2.date.getTime());
    }