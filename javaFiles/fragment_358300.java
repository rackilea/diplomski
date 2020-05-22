EasyFactoryConfiguration config = new EasyFactoryConfiguration();
    config.toolbox(Scope.APPLICATION).tool("msg", UTF8ResourceTool.class)
            .property("bundles", "messages/messages").property("locale", locale)
            .tool("date", DateTool.class).tool("number", NumberTool.class)
            .tool("string", StringTool.class).tool("esc", EscapeTool.class)
            .tool("base64", Base64Tool.class);