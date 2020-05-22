Map<String, String> mOpts = new HashMap<>(); // options

mOpts.put("doNotPrompt", Boolean.TRUE.toString());
mOpts.put("useTicketCache", Boolean.FALSE.toString());
mOpts.put("useKeyTab", Boolean.TRUE.toString());
mOpts.put("keyTab", options.getKeytabPath().toString());
mOpts.put("principal", PrincipalUtils.getDefaultPrincipal().getName());

krb5LM.initialize(_subject, options.getCallbackHandler(), mSS, mOpts);

//
// attempt to authenticate the user
//
krb5LM.login();