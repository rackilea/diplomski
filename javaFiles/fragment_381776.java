public static boolean execute(String file, String parameters) {
    Function shellExecute =
      Shell32.getInstance().getFunction(SHELL_EXECUTE.toString());
    Int32 ret = new Int32();
    shellExecute.invoke(ret, // return value
                        new Parameter[] {
                          new Handle(),         // hWnd
                          new Str("open"),      // lpOperation
                          new Str(file),        // lpFile
                          new Str(parameters),  // lpParameters
                          new Str(),            // lpDirectory
                          new Int32(1)          // nShowCmd
                        });
    if(ret.getValue() <= 32) {
        System.err.println("could not execute ShellExecute: " +
                           file + ". Return: " + ret.getValue());
    }
    return (ret.getValue() > 32);
  }

  public static void main(String[] args) {
    ShellExecute.execute("rundll32.exe","url.dll,FileProtocolHandler pathToGadget" );
  }