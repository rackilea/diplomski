ClientExecChain execChain = createMainExec(
            requestExecCopy,
            connManagerCopy,
            reuseStrategyCopy,
            keepAliveStrategyCopy,
            new ImmutableHttpProcessor(new RequestTargetHost(), new RequestUserAgent(userAgentCopy)),
            targetAuthStrategyCopy,
            proxyAuthStrategyCopy,
            userTokenHandlerCopy);