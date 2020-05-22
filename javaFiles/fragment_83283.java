package com.lacqui.commands;

public class GroupCommand extends Command {
    public ResponseCode execute() {
        Server srv = getServer();

        if (srv.hasCapability(Capabilities.LOGGER) == false) {
            Log.debug("Attempting non-available capability: LOGGER");
        }

        if (srv.hasCapability(Capabilities.AUTHENTICATOR) == false) {
            Log.debug("Attempting non-available capability: AUTHENTICATOR");
        }

        String groupname = getArgument("groupname");
        if (groupname == null) {
             throw new InvalidArgumentException("Require groupname");
        }

        String command = "GROUP";
        if (groupname != null) command += " -groupname " + groupname;

        srv.send(command);
        return srv.getResponse();
    }
}