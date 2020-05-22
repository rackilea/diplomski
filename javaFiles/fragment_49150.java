public ObservableList<Requisicao> atualizarTabela() {
    RequisicaoDAO dao = new RequisicaoDAO();
    //create an empty list first
    requisicoes = FXCollections.observableArrayList();
    //execute the query in the task
    Task<List<Requisicao>> task = new Task<List<Requisicao>>() {

        @Override
        protected List<Requisicao> call() throws Exception {
            //getList has no thread anymore
            return dao.getList();
        }

    };
    //add the list values to the observable list, when the task succeeds
    task.setOnSucceeded(e -> requisicoes.addAll(task.getValue()));
    task.setOnFailed(e -> System.out.println("Task failed"));//better do some execption handling here...

    //start the task in a new thread
    Thread executor = new Thread(task, "get_list_task_thread");
    executor.start();

    //return the (empty) list, which will be filled when the task (that includes the query) has finished
    return requisicoes;
}