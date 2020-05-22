ExecuteWatchdog watchdog = new ExecuteWatchdog(EXECUTION_TIMEOUT_IN_MS);
    DefaultExecutor executor = new DefaultExecutor();

    executor.setWatchdog(watchdog);
    executor.setExitValue(0);

    ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
    ByteArrayOutputStream errorStream = new ByteArrayOutputStream();

    executor.setStreamHandler(new PumpStreamHandler(outputStream, errorStream));

    try {
        log.info(commandLine.toString());

        int exitCode = executor.execute(commandLine, (Map<?, ?>) null);

        if (exitCode != 0)
            throw new BusinessException("Process exited with non-zero exit code.");

        return outputStream.toString();
    } catch (ExecuteException e) {
        String errorStreamStr = null;

        if (errorStream.size() != 0)
            errorStreamStr = errorStream.toString();

        StringBuilder errorMessageBuilder = new StringBuilder();

        errorMessageBuilder.append("main.error").append(":\n").append(
                e.getMessage()).append("\n\n");

        if (errorStreamStr != null) {
            errorMessageBuilder.append("additional.error").append(":\n").append(errorStreamStr).append("\n\n");
        }

        errorMessageBuilder.append("command.line").append(":\n").append(commandLine.toString());

        if (log.isDebugEnabled())
            log.debug(errorMessageBuilder.toString());

        throw new BusinessException(errorMessageBuilder.toString());
    } catch (IOException e) {
        throw new IllegalStateException(e);
    } finally {
        StreamUtil.closeQuietly(outputStream, errorStream);
    }