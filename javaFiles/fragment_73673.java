public void addOperation(Operation operation, AddOperationInteractor.CallBack callback) {
    execute(()-> operationRepository.addNewOperation(operation),
            ()-> callback.onAddOperationSuccess());
}

public void deleteOperation(Operation operation, RemoveOperationInteractor.CallBack callback) {
    execute(()-> operationRepository.removeOperation(operation),
            ()-> callback.onRemoveOperationSuccess());
}

private void execute(Runnable action, Runnable onSuccess) {
    ThreadExecutor.getInstance().execute(() -> {
        try {
            action.run();
            onSuccess.run();
        } catch (Exception e) {
            LOG.warn(e);
            onSuccess.run();
        }
    }
}