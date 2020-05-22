Map<String, Object> bindingArgs = new HashMap<String, Object>();
bindingArgs.put("x-match", "any"); //any or all
bindingArgs.put("headerName#1", "headerValue#1");
bindingArgs.put("headerName#2", "headerValue#2");

...
channel.queueBind("myQueue", "myExchange", "", bindingArgs);
...