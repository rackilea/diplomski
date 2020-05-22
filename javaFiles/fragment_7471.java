ChannelFuture channelFuture = bootstrap.connect(remoteAddress, localAddress);

        channelFuture.addListener(new ChannelFutureListener() {
            @Override
            public void operationComplete(ChannelFuture future) throws Exception {
                resultConcurrentHashMap.put(future.getChannel().getId(), result);
            }
        });