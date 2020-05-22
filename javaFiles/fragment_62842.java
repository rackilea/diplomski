EditText comentarios;
Calendario calendario;

public TasksAdapter(@NonNull Context context, @SuppressLint("SupportAnnotationUsage") @LayoutRes ArrayList<Tasks> list){
    super(context, 0, list);
    sContext = context;
    taskData = list;
    tasksModal = new Dialog(sContext);
    tasksModal.setCancelable(false); //make it un cancelable
    tasksModal.setContentView(R.layout.modal_tasksdone);
    tasksModal.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
    comentarios = (EditText) tasksModal.findViewById(R.id.edtComentario);
    calendario = new Calendario();
}
-------------------------------------------------------------
Button done = (Button) listItem.findViewById(R.id.tasksDone);
done.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View view) {
        comentarios.setText("");
        yorn = true;
        tarefaId = presenteTask.getTaskId();
        data = presenteTask.getDataTask();
        hora = String.valueOf(presenteTask.getTimeStart());

        tasksModal.findViewById(R.id.btnSend).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                comentario = comentarios.getEditableText().toString();
                if(!comentario.equals("")){
                    tasksModal.dismiss(); //dismiss here
                    calendario.retrofitDoneTasks(tarefaId, comentario, data, hora, yorn, tarefaRealizadaId);
                }
                else{
                    Toast.makeText(sContext,"Por favor digite um comentário.", Toast.LENGTH_SHORT).show();
                }
            }
        });

        tasksModal.show();
    }
});

Button notDone = (Button) listItem.findViewById(R.id.tasksNotDone);
notDone.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View view) {
        comentarios.setText("");
        yorn = false;
        tarefaId = presenteTask.getTaskId();
        data = presenteTask.getDataTask();
        hora = String.valueOf(presenteTask.getTimeStart());

        tasksModal.findViewById(R.id.btnSend).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                comentario = comentarios.getEditableText().toString();
                if(comentario.equals("")){
                    Toast.makeText(sContext,"Por favor digite um comentário.", Toast.LENGTH_SHORT).show();
                }
                else{
                    tasksModal.dismiss();
                    calendario.retrofitDoneTasks(tarefaId, comentario, data, hora, yorn, tarefaRealizadaId);
                }
            }
        });

        tasksModal.show();
    }
});