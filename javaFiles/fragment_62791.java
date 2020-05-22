SimpleMessageListenerContainer listener = (SimpleMessageListenerContainer) 
            registry.getListenerContainer("test listener 1");
listener.addQueues(declaredQueue);
Method method = SimpleMessageListenerContainer.class.getDeclaredMethod("queuesChanged");
method.setAccessible(true);
method.invoke(listener);