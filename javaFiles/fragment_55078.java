private boolean executeCommands() {
        boolean isSuccess = true;
        Closure closure = new Closure() {
            public void run(ExpectState expectState) throws Exception {
                buffer.append(expectState.getBuffer());//buffer is string buffer for appending output of executed command             
                expectState.exp_continue();
            }
        };
        List<Match> lstPattern =  new ArrayList<Match>();
        String[] regEx = SSHConstants.linuxPromptRegEx;  
        if (regEx != null && regEx.length > 0) {
            synchronized (regEx) {
                for (String regexElement : regEx) {//list of regx like,  :>, /> etc. it is possible command prompts of your remote machine
                    try {
                        RegExpMatch mat = new RegExpMatch(regexElement, closure);
                        lstPattern.add(mat);                        
                    } catch (MalformedPatternException e) {                     
                        return false;
                    } catch(Exception e) {                      
                        return false;
                    }
                }
                lstPattern.add(new EofMatch( new Closure() { // should cause entire page to be collected
                    public void run(ExpectState state) {
                    }
                }));
                lstPattern.add(new TimeoutMatch(defaultTimeOut, new Closure() {
                    public void run(ExpectState state) {
                    }
                }));
            }
        }
        try {
            Expect4j expect = SSH(objConfig.getHostAddress(), objConfig.getUserName(), objConfig.getPassword(), SSHConstants.SSH_PORT);
            expect.setDefaultTimeout(defaultTimeOut);       
            if(isSuccess) {
                for(String strCmd : lstCmds)
                    isSuccess = isSuccess(lstPattern,strCmd);
            }
            boolean isFailed = checkResult(expect.expect(lstPattern));
            return !isFailed;
        } catch (Exception ex) {            
            return false;
        } finally {
            closeConnection();
        }
    }


private boolean isSuccess(List<Match> objPattern,String strCommandPattern) {
        try {   
            boolean isFailed = checkResult(expect.expect(objPattern));

            if (!isFailed) {
                expect.send(strCommandPattern);         
                expect.send("\r");              
                return true;
            } 
            return false;
        } catch (MalformedPatternException ex) {    
            return false;
        } catch (Exception ex) {
            return false;
        }
} 

 private boolean checkResult(int intRetVal) {
    if (intRetVal == SSHConstants.COMMAND_EXECUTION_SUCCESS_OPCODE) {
        return true;
    }
    return false;
 }

    public static final int COMMAND_EXECUTION_SUCCESS_OPCODE = -2; 
public static final String BACKSLASH_R = "\r";
public static final String BACKSLASH_N = "\n";
public static final String COLON_CHAR = ":";
public static String ENTER_CHARACTER = BACKSLASH_R;
public static final int SSH_PORT = 22;  
public static String[] linuxPromptRegEx = new String[]{"~]#","~#","#",":~#","/$",}