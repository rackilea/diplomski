int CHAR_WIDTH = W32APITypeMapper.DEFAULT == W32APITypeMapper.UNICODE ? 2 : 1;
int PORT_SIZE = 7;
int MAX_NAME_SIZE = 248;

class InnerStructure ... {
    public byte[] szPort = new byte[CHAR_WIDTH * PORT_SIZE];
    public boolean fActivated;
    public byte[] szName = new byte[CHAR_WIDTH * MAX_NAME_SIZE];
...
}