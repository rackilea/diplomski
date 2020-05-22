options {
    BUILD_PARSER=false;
    STATIC=false;
}
PARSER_BEGIN(Robot)

public class Robot {}
PARSER_END(Robot)
TOKEN_MGR_DECLS: {
  public static void main(String[] args) throws Exception {
    java.io.Reader r = new java.io.FileReader(args[0]);
    SimpleCharStream scs = new SimpleCharStream(r);
    RobotTokenManager mgr = new RobotTokenManager(scs);
    for (Token t = mgr.getNextToken(); t.kind != EOF;
      t = mgr.getNextToken()) {
        System.out.println("Found a " + RobotConstants.tokenImage[t.kind] + ": " + t.image);
    }
  }
}    
SKIP :
{
    " "
|   "\n"
|   "\r"
|   "\r\n"
}
TOKEN :
{
    <STEP   :   "STEP">
|   <RIGHT  :   "RIGHT">
|   <LEFT   :   "LEFT">
|   <NUM    :   (["1"-"9"])+ (["0"-"9"])*>
}