...
int ABC_Shell(String command, int len, Pointer[] response, int buflen);
int ABC_ImageProcessFromRaw(Pointer hFront, Pointer hRear);
...

Pointer[] response = new Pointer[3];
// You should probably be more programmatic about the command buffer and its length
api.ABC_Shell("CP12", 8, response, response.length * Pointer.SIZE);
api.ABC_ImageProcessFromRaw(response[0], null);