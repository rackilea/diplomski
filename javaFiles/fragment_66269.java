Container container = ServerContextFactory.get().getContainer();
    ScriptSessionManager manager = container.getBean(ScriptSessionManager.class);
    System.out.println("sessions: " + manager.getAllScriptSessions().size());
    for (ScriptSession scriptSession : manager.getAllScriptSessions()) {
        System.out.println("Sending script to session " + scriptSession);
        ScriptBuffer script = new ScriptBuffer("window.alert('hello from reverse ajax server');");
        scriptSession.addScript(script);
    }