Semaphore semaphore = new Semaphore(MAX_CONCURRENT_REQUESTS, true); // false if FIFO is not important
new BufferedReader(new InputStreamReader(new ByteArrayInputStream(file)))
.lines()
        .map(line -> CsvLine.create(line))
        .filter(line -> !line.isHeader())
        .forEach(line -> {
            try {
                if (!semaphore.tryAcquire(ASYNC_REQUEST_TIMEOUT, TimeUnit.MILLISECONDS)) {
                    handleTimeout();
                } else {
                    getResult(line, new FutureCallback<HttpResponse>() {
                        @Override
                        public void completed(HttpResponse response) {
                            try {
                                result.addLine(response);
                            } catch (IOException e) {
                                LOGGER.error("IOException, cannot write to server", e);
                                todo.set(-1); // finish in error
                            } finally {
                                todo.decrementAndGet();
                                semaphore.release();
                            }
                        }

                        @Override
                        public void failed(Exception ex) {
                            handleError();
                            semaphore.release();
                        }

                        @Override
                        public void cancelled() {
                            handleError();
                            semaphore.release();
                        }
                    }
                    );
                }
            } catch (InterruptedException e) {
                // handle appropriately
            }

        });