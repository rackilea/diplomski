public <T extends Throwable> void addExceptionCommands(Supplier<T> exceptionSupplier, Command... commands) throws T {
        for (Command command : commands) {
            try {
                //Push the command to the stack of executed commands
                executedCommands.push(command);
                command.execute();
            } catch (CouldNotExecuteCommandException e) {
                // Default strategy is to rollback
                rollback();
                // Log
                e.printStackTrace();
                //I want to throw exClass here

                final T exception = exceptionSupplier.get();
                exception.addSuppressed(e);

                throw exception;
            }
        }
    }