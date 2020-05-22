public String autocompleteClient(){

        if (this.idClient!=null && !this.idClient.isEmpty()){
            try{
                ItClient client = this.myservice.findClient(Integer.valueOf(this.idClient));
                if (client !=null){
                     return SUCCESS;
            } catch(Exception e){
                LOG.error(e.getMessage());
                addActionError(e.getMessage());
                return ERROR;
            }
        }
        else{
            addActionError("idClient is null");
            return ERROR;
        }

}


public String loadClient(){
        this.listClient = new LinkedHashMap<String, String>();

        List<ItClient> list = null;
        if(term!=null && !term.isEmpty())
            list = is.findAllClientsByName(term);
        else    
            list = is.findAllClients();
        Iterator<ItClient> it = list.iterator();
        while (it.hasNext()){
            ItClient clientAux= it.next();
            listSolicitante.put(clientAux.getId().toString(), clientAux.getNombre());
        }
        return SUCCESS;
    }