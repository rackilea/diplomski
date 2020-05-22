int n = 21;
int m = 23;
double[][] data = new double[n][m];
for (int i=0;i<data.lengthi++){    
    for (int j=0;j<data[0].length;j++){
        data[i][j] = Math.random();
    }
}
RCaller caller = new RCaller();
Globals.detect_current_rscript();   
caller.setRscriptExecutable(Globals.Rscript_current);

RCode code = new RCode();
code.addDoubleMatrix("x", data);
caller.setRCode(code);

caller.runAndReturnResult("x");

int[] mydim = caller.getParser().getDimensions("x");

Assert.assertEquals(n, mydim[0]);
Assert.assertEquals(m, mydim[1]);