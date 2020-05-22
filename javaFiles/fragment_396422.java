protected final byte CPMEOF = 26;       /* control/z */
protected final int MAXERRORS = 10;     /* max times to retry one block */
protected final int SECSIZE = 128;      /* cpm sector, transmission block */
protected final int SENTIMOUT = 30;     /* timeout time in send */
protected final int SLEEP   = 30;       /* timeout time in recv */

/* Protocol characters used */

protected final byte    SOH = 1;    /* Start Of Header */
protected final byte    EOT = 4;    /* End Of Transmission */
protected final byte    ACK = 6;    /* ACKnowlege */
protected final byte    NAK = 0x15; /* Negative AcKnowlege */

protected InputStream inStream;
protected OutputStream outStream;
protected PrintWriter errStream;



/** Construct a TModem */
public TModem(InputStream is, OutputStream os, PrintWriter errs) {
    inStream = is;
    outStream = os;
    errStream = errs;
}

/** Construct a TModem with default files (stdin and stdout). */
public TModem() {
    inStream = System.in;
    outStream = System.out;
    errStream = new PrintWriter(System.err);
}

/** A main program, for direct invocation. */
public static void main(String[] argv) throws 
Exception, IOException, InterruptedException {

    /* argc must == 2, i.e., `java TModem -s filename' */
    if (argv.length != 2) 
        usage();

    if (argv[0].charAt(0) != '-')
        usage();

    TModem tm = new TModem( );
    tm.setStandalone(true);

    boolean OK = false;
    switch (argv[0].charAt(1)){
    case 'r': 
        OK = tm.receive(argv[1]); 
        break;
    case 's': 
        OK = tm.send(argv[1]); 
        break;
    default: 
        usage();
    }
    System.out.print(OK?"Done OK":"Failed");
    System.exit(0);
}

/* give user minimal usage message */
protected static void usage()
{
    System.err.println("usage: TModem -r/-s file");
    // not errStream, not die(), since this is static.
    System.exit(1);
}

/** If we're in a standalone app it is OK to System.exit() */
protected boolean standalone = false;
public void setStandalone(boolean is) {
    standalone = is;
}
public boolean isStandalone() {
    return standalone;
}

/** A flag used to communicate with inner class IOTimer */
protected boolean gotChar;

/** An inner class to provide a read timeout for alarms. */
class IOTimer extends Thread {
    String message;
    long milliseconds;

    /** Construct an IO Timer */
    IOTimer(long sec, String mesg) {
        milliseconds = 1000 * sec;
        message = mesg;
    }

    public void run() {
      try {
        Thread.sleep(milliseconds);
      } catch (InterruptedException e) {
        // can't happen
          e.printStackTrace();
      }
      /** Implement the timer */
      if (!gotChar)
        errStream.println("Timed out waiting for " + message);
        //System.out.println("Timed out waiting for " + message);
        die(1);
    }
}

/*
 * send a file to the remote
 */
public boolean send(String tfile) throws Exception, IOException, InterruptedException
{
    Parameters param;
    param = new Parameters();
    param.setPort("COM1");
    param.setBaudRate("115200");
    param.setParity("N");
    param.setByteSize("8");
    Com com = new Com(param);

    char checksum, index, blocknumber, errorcount;
    byte character;
    byte[] sector = new byte[SECSIZE];
    int nbytes;
    DataInputStream foo;

    foo = new DataInputStream(new FileInputStream(tfile));
    errStream.println( "file open, ready to send");
    System.out.println( "file open, ready to send");
    errorcount = 0;
    blocknumber = 1;

    // The C version uses "alarm()", a UNIX-only system call,
    // to detect if the read times out. Here we do detect it
    // by using a Thread, the IOTimer class defined above.
    gotChar = false;
    new IOTimer(SENTIMOUT, "NAK to start send").start();

    do {
        character = getchar(com);
        gotChar = true;
        if (character != NAK && errorcount < MAXERRORS)
            ++errorcount;
    } while (character != NAK && errorcount < MAXERRORS);

    errStream.println( "transmission beginning");
    System.out.println( "transmission beginning");
    if (errorcount == MAXERRORS) {
        xerror();
    }

    while ((nbytes=inStream.read(sector))!=0) {
        if (nbytes<SECSIZE)
            sector[nbytes]=CPMEOF;
        errorcount = 0;
        while (errorcount < MAXERRORS) {
            errStream.println( "{" + blocknumber + "} ");
            System.out.println( "{" + blocknumber + "} ");
            putchar(com,  SOH);   /* here is our header */
            putchar(com,  blocknumber);   /* the block number */
            putchar(com,  ~blocknumber);  /* & its complement */
            checksum = 0;
            for (index = 0; index < SECSIZE; index++) {
                putchar(com, sector[index]);
                checksum += sector[index];
            }
            putchar(com, checksum);  /* tell our checksum */
            if (getchar(com) != ACK)
                ++errorcount;
            else
                break;
        }
        if (errorcount == MAXERRORS)
            xerror();
        ++blocknumber;
    }
    boolean isAck = false;
    while (!isAck) {
        putchar(com, EOT);
        isAck = getchar(com) == ACK;
    }
    errStream.println( "Transmission complete.");
    //System.out.println( "Transmission complete.");
    return true;
}

/*
 * receive a file from the remote
 */
public boolean receive(String tfile) throws Exception
{
    Parameters param;
    param = new Parameters();
    param.setPort("COM1");
    param.setBaudRate("115200");
    param.setParity("N");
    param.setByteSize("8");
    Com com = new Com(param);

    char checksum, index, blocknumber, errorcount;
    byte character;
    byte[] sector = new byte[SECSIZE];
    DataOutputStream foo;

    foo = new DataOutputStream(new FileOutputStream(tfile));

   System.out.println("you have " + SLEEP + " seconds...");

    /* wait for the user or remote to get his act together */
    gotChar = false;
    new IOTimer(SLEEP, "receive from remote").start(); 

    errStream.println("Starting receive...");
    //System.out.println("Starting receive...");
    putchar(com, NAK);
    errorcount = 0;
    blocknumber = 1;
    rxLoop:
    do { 
        character = getchar(com);
        gotChar = true;
        if (character != EOT) {
            try {
                byte not_ch;
                if (character != SOH) {
                   errStream.println( "Not SOH");
                    //System.out.println( "Not SOH");
                    if (++errorcount < MAXERRORS)
                        continue rxLoop;
                    else
                        xerror();
                }
                character = getchar(com);
                not_ch = (byte)(~getchar(com));
                errStream.println( "[" +  character + "] ");
                //System.out.println( "[" +  character + "] ");
                if (character != not_ch) {
                    errStream.println( "Blockcounts not ~");
                    //System.out.println("Blockcounts not ~");

                    ++errorcount;
                    continue rxLoop;
                }
                if (character != blocknumber) {
                    errStream.println( "Wrong blocknumber");
                    //System.out.println( "Wrong blocknumber");
                    ++errorcount;
                    continue rxLoop;
                }
                checksum = 0;
                for (index = 0; index < SECSIZE; index++) {
                    sector[index] = getchar(com);
                    checksum += sector[index];
                }
                if (checksum != getchar(com)) {
                    errStream.println( "Bad checksum");
                    //System.out.println( "Bad checksum");
                    errorcount++;
                    continue rxLoop;
                }
                putchar(com, ACK);
                blocknumber++;
                try {
                    foo.write(sector);
                } catch (IOException e) {
                    errStream.println("write failed, blocknumber " + blocknumber);
                    //System.out.println("write failed, blocknumber " + blocknumber);
                }
            } finally {
            if (errorcount != 0)
                putchar(com, NAK);
        }
    }
    } while (character != EOT);

    foo.close();

    putchar(com, ACK);   /* tell the other end we accepted his EOT   */
    putchar(com, ACK);
    putchar(com, ACK);

    errStream.println("Receive Completed.");
    //System.out.println("Receive Completed.");
    return true;
}

protected byte getchar(Com com) throws Exception {
    return (byte)com.receiveSingleDataInt();
   // return (byte)inStream.read();
}

protected void putchar(Com com, int c) throws Exception {

com.sendSingleData(c);
//    outStream.write(c);
}

protected void xerror()
{
    errStream.println("too many errors...aborting");
    //System.out.println("too many errors...aborting");
    die(1);
}

protected void die(int how)
{
    if (standalone)
        System.exit(how);
    else 
      System.out.println(("Error code " + how));
}