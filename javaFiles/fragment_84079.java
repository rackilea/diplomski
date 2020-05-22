DebuggerManager.getDebuggerManager().addDebuggerListener();
MethodBreakpoint.create();
RequestProcessor.getDefault().post();
DebuggerInfo.create ("netbeans-jpda-AttachingDICookie", new Object [] {AttachingDICookie.create ("localhost",port)} );
DebuggerManager.getDebuggerManager().startDebugging()
JPDADebugger d = DebuggerEngine.lookupFirst("", JPDADebugger.class);
JPDADebugger.waitRunning();