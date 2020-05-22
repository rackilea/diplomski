@ModelAttribute
    public Candidate loadCandidate(@RequestParam(value="id",required=false) Long id) {
      Candidate candidate=null;
      if(id!=null){
        candidate=candidateService.findById(id);
      }
      else{
       candidate=new Candidate();
      }

      return candidate;
     }

    @RequestMapping(.......)
    public String saveCandidate(Model model, @ModelAttribute Candidate candidate) {
        candidateService.update(candidate);
          return "candidateMenu";
     }