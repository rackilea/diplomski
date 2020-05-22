RecyclerView rv;
 public MaTask(Button b,ProgressDialog progressBar,List<Cours> laliste, RecyclerView rv)
  {
      dialog=progressBar; 
      button=b; 
      jours=laliste;
      this.rv = rv;
  }