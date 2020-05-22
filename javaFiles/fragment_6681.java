private static class C_ProcessOutputThread extends Thread {
    private StringBuffer m_output;
    private InputStream m_inputStream;

    public C_ProcessOutputThread(
            InputStream inputstream,
            StringBuffer output
    ) {
        super( "ProcessOutputThread" );
        m_inputStream = inputstream;
        m_output = output;
    }

    @Override
    public void run() {
        byte[] buffer = new byte[ 8192 ];

        try {
            while( true ) {
                int available = m_inputStream.available();

                if( available == 0 ) {
                    try {
                        Thread.sleep( 100 );
                    }
                    catch( InterruptedException e ) {
                        break;
                    }

                    continue;
                }

                int len = Math.min( buffer.length, available );
                len = m_inputStream.read( buffer, 0, len );
                String outString = new String( buffer, 0, len );
                m_output.append( outString );
            }
        }
        catch( IOException e ) {
            e.printStackTrace();
        }
    }
}