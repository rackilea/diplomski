# Q&D -- assumes default as of 0.1.53
session.setConfig ("PreferredAuthentications", 
    "publickey,keyboard-interactive,password"); 
# or 
session.setConfig ("PreferredAuthentications", 
    "publickey,keyboard-interactive,password,gssapi-with-mic");

# more robust for future
ArrayList<String> auths = new ArrayList<String>( 
  Arrays.asList( session.getConfig ("PreferredAuthentications") .split(",")) );
auths.remove ("gssapi-with-mic");
# optional add back to end
auths.add ("gssapi-with-mic");
session.setConfig ("PreferredAuthentications", String.join (",", auths));