public void addOperation(Operation operation, AddOperationInteractor.CallBack callback) {
    ThreadExecutor.getInstance().execute(() -> {
        try {
            operationRepository.addNewOperation(operation);
        }
        finally {
            callback.onAddOperationSuccess();
        }
    });
}

public void deleteOperation(Operation operation, RemoveOperationInteractor.CallBack callback) {
    ThreadExecutor.getInstance().execute(() -> {
        try {
            operationRepository.removeOperation(operation);
        }
        finally {
            callback.onRemoveOperationSuccess();
        }
    });
}