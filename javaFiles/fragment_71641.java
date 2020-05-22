public boolean StartJob()
            throws MyException{



        try {

                final JobParameters jobParameters = new JobParametersBuilder()
                        .addLong("time", System.nanoTime())
                        .addString("file", jobInputFolder.getAbsolutePath())
                        .toJobParameters();

                final JobExecution execution = jobLauncher.run(job,
                        jobParameters);
                final ExitStatus status = execution.getExitStatus();

                if (ExitStatus.COMPLETED.getExitCode().equals(
                        status.getExitCode())) {
                    result = true;
                } else {
                    final List<Throwable> exceptions = execution
                            .getAllFailureExceptions();
                    for (final Throwable throwable : exceptions) {

                        if (throwable instanceof MyException) {
                            throw (MyException) throwable;
                        }
                        if (throwable instanceof FlatFileParseException) {

                            Throwable rootException = throwable.getCause();
                            if (rootException instanceof IncorrectTokenCountException) {

                                throw new MyException(logMessage, errorCode);
                            }
                            if (rootException instanceof BindException) {
                                BindException bindException = (BindException) rootException;
                                final FieldError fieldError = bindException
                                        .getFieldError();
                                final String field = fieldError.getField();

                                throw new MyException(logMessage, errorCode);
                            }
                        }

                    }
                }
            }
        } catch (JobExecutionAlreadyRunningException ex) {

        } catch (JobRestartException ex) {

        } catch (JobInstanceAlreadyCompleteException ex) {

        } catch (JobParametersInvalidException ex) {

        } catch (IOException ex) {

        } finally {

        }

        return result;
    }