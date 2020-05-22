package com.lacqui.commands;

public class ArticleCommand extends Command {
    public ResponseCode execute() {
        Server srv = getServer();

        if (srv.hasCapability(Capabilities.READER) == false) {
            Log.debug("Attempting non-available capability: READER");
        }

        String article-id = getArgument("article-id");
        if (article-id == null) {
             throw new InvalidArgumentException("Require article-id");
        }

        String message-id = getArgument("message-id");

        String command = "GROUP";
        if (article-id != null) command += " -article-id " + article-id;
        if (message-id != null) command += " -message-id " + message-id;

        srv.send(command);
        return srv.getResponse();
    }
}