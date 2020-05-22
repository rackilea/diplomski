@Override
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);

    queue=Volley.newRequestQueue(this);

    AutenticacaoLocalTask mAutenticacaoLocalTask = new AutenticacaoLocalTask();
    mAutenticacaoLocalTask.execute((Void) null);

}