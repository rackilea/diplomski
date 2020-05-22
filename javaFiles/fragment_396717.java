public class PostImagen {
private String mURL;
private byte[] mDatos;

public PostImagen(String URLServicio, byte[] Datos){
    mDatos = Datos;
    mURL = URLServicio;
}

public void getRespuesta() throws Exception {       
    try {                                      
        String mBoundary = "SUPSUP";            

        /* Strings a usar para el contenido */
        String nuevaLinea = "\r\n";
        String contDisp="Content-Disposition: multipart/form-data; name=\"foto\";filename=\"sample.jpg\"";
        String contEnc = "Content-Transfer-Encoding: binary";
        String type="Content-Type:image/jpeg";

        /* Preparar objeto a enviar */
        byte[] mBytesPostear;
        if (mDatos == null){
            InputStream mImagen = this.getClass().getResourceAsStream("sample.jpg");            
            mBytesPostear = IOUtilities.streamToBytes(mImagen);
        } else {
            mBytesPostear = mDatos;
        }                       

        System.err.println("Longitud de imagen: " + mBytesPostear.length);



        /* Preparar contenido de salida */
        ByteArrayOutputStream mOutput = new ByteArrayOutputStream();
        mOutput.write(nuevaLinea.getBytes());
        mOutput.write("--".getBytes());
        mOutput.write(mBoundary.getBytes());
        mOutput.write(nuevaLinea.getBytes());
        mOutput.write(contDisp.getBytes());
        mOutput.write(nuevaLinea.getBytes());
        mOutput.write(type.getBytes());
        mOutput.write(nuevaLinea.getBytes());
        mOutput.write(contEnc.getBytes());
        mOutput.write(nuevaLinea.getBytes());
        mOutput.write(nuevaLinea.getBytes());
        mOutput.write(mBytesPostear);
        mOutput.write(nuevaLinea.getBytes());
        mOutput.write("--".getBytes());
        mOutput.write(mBoundary.getBytes());
        mOutput.write("--".getBytes());         
        mOutput.write(nuevaLinea.getBytes());

        /* Preparar conexión y headers */
        HttpConnection mConexion = (HttpConnection) Connector.open(mURL);
        mConexion.setRequestMethod(HttpConnection.POST);
        mConexion.setRequestProperty(HttpProtocolConstants.HEADER_CONTENT_TYPE, HttpProtocolConstants.CONTENT_TYPE_MULTIPART_FORM_DATA + ";boundary=" + mBoundary);
        mConexion.setRequestProperty(HttpProtocolConstants.HEADER_CONTENT_LENGTH, String.valueOf(mOutput.size()));          
        mConexion.setRequestProperty( "x-rim-transcode-content", "none" );      

        /**********************/
        System.err.println("Escribiendo stream");

        OutputStream mOS = mConexion.openOutputStream();            

        /* Escribir el contenido */
        mOS.write(mOutput.toByteArray());

        mOutput.flush();
        mOutput.close();

        mOS.flush();
        mOS.close();

        System.err.println("Se terminó de escribir payload, recibiendo respuesta");

        /* Recibir respuesta del servidor */
        if (mConexion.getResponseCode() != HttpConnection.HTTP_OK){             
            throw new Exception("El servidor NO regresó OK (200) al leer la respuesta. Saliendo...");
        }

        InputStream mIS = mConexion.openInputStream();
        int mLongitud = (int) mConexion.getLength();

        if (mLongitud > 0) {                

            int mActual = 0;
            int mBytesLeidos = 0;
            byte[] mBytes = new byte[mLongitud];

            while ((mBytesLeidos != mLongitud) && (mActual != -1)){
                mActual = mIS.read(mBytes, mBytesLeidos, mLongitud - mBytesLeidos);
                mBytesLeidos += mActual;
            }               

            String mRespuesta = new String(mBytes);     
            System.out.println("Respuesta: " + mRespuesta);

        } else {                                            
            throw new Exception("No se recibió respuesta del servidor");
        }                                           
    } catch (IOException e) {                                   
        throw new Exception("Error de lectura o escritura: " + e.getMessage());
    }       
}