BaseCall<Set<String>> getXInstance = new RunVcTask<>(credentials,
    new RunVcTask.ActualTask<Set<String>>() {
        public Set<String> actualOp(Structure proxy, Credentials credentials) {
            return proxy.getXfromVC(credentials);
        }
    });
BaseCall<Set<String>> getYInstance = new RunVcTask<>(credentials,
    new RunVcTask.ActualTask<Set<String>>() {
        public Set<String> actualOp(Structure proxy, Credentials credentials) {
            return proxy.getYfromVC(credentials);
        }
    });