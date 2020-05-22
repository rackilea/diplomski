@RequestMapping(value = "/api/allconf", method = RequestMethod.GET)
    public Response getAllConf(@RequestBody Conferences conf) {

        Response resp = new Response();
        List<Conferences> allConf = new ArrayList<Conferences>();
        try{
            allConf.addAll(confRepository.findAll());
            resp.setContent(allConf);
        }catch(Exception e){
           resp.setError(e.getMessage());
        }
        return resp;
    }