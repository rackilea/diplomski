Process
    slave_process = Runtime.getRuntime().exec("cmdname -opts cmdargs");

 OutputStream
 __bytes_into_his_stdin  = slave_process.getOutputStream();

 OutputStreamWriter
   chars_into_his_stdin  = new OutputStreamWriter(
                             __bytes_into_his_stdin,
         /* DO NOT OMIT! */  Charset.forName("UTF-8").newEncoder()
                         );

 InputStream
 __bytes_from_his_stdout = slave_process.getInputStream();

 InputStreamReader
   chars_from_his_stdout = new InputStreamReader(
                             __bytes_from_his_stdout,
         /* DO NOT OMIT! */  Charset.forName("UTF-8").newDecoder()
                         );

 InputStream
 __bytes_from_his_stderr = slave_process.getErrorStream();

 InputStreamReader
   chars_from_his_stderr = new InputStreamReader(
                             __bytes_from_his_stderr,
         /* DO NOT OMIT! */  Charset.forName("UTF-8").newDecoder()
                         );