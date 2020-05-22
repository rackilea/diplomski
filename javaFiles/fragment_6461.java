private ServerInterceptor si = new ServerInterceptor() {

        @Override
        public <ReqT, RespT> ServerCall.Listener<ReqT> interceptCall(ServerCall<ReqT, RespT> call, Metadata headers, ServerCallHandler<ReqT, RespT> next) {
            ServerCall<ReqT, RespT> wrappedCall = new ForwardingServerCall.SimpleForwardingServerCall<ReqT, RespT>(call) {
                @Override
                public void sendMessage(RespT message) {
                    super.sendMessage(message);
                }

                @Override
                public void close(Status status, Metadata trailers) {
                    System.out.println("Interceptor: " + (status.getCause() == null ? "null" : status.getCause().getClass().getName()));
                    if (status.getCode() == Status.Code.UNKNOWN
                            && status.getDescription() == null
                            && status.getCause() != null) {
                        Throwable e = status.getCause();
                        status = Status.INTERNAL
                                .withDescription(e.getMessage())
                                .augmentDescription(stacktraceToString(e));
                    }
                    super.close(status, trailers);
                }
            };

            return next.startCall(wrappedCall, headers);
        }

        private String stacktraceToString(Throwable e) {
            StringWriter stringWriter = new StringWriter();
            PrintWriter printWriter = new PrintWriter(stringWriter);
            e.printStackTrace(printWriter);
            return stringWriter.toString();
        }
    };