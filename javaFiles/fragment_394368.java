scheduledFutures.add(executorService.scheduleAtFixedRate(() -> {
                    try {
                        String data = "Ping";
                        ByteBuffer payload = ByteBuffer.wrap(data.getBytes());
                        userSession.getRemote().sendPing(payload);

                        if (lastPong != null
                                && Instant.now().getEpochSecond() - lastPong.getEpochSecond() > 60) {
                            userSession.close(1000, "Timeout manually closing dead connection.");
                        }

                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                },
                10, 10, TimeUnit.SECONDS));