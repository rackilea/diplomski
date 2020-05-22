import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import org.apache.commons.net.ftp.FTP;
import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPFile;

/**
* To Download folder from FTP Server using FTPClient library.
* 
* @author Hadri
* @version 1.0
*/
public class FTPDown {

/**
 * Download a file
 *
 * @param clienteFTP
 * 
 * @param pathRemoto
 *            Path  FTP
 * @param archivoLocal
 *            Path from file
 * @return true if download correctly
 * @throws IOException
 * 
 */

public static boolean retrieveFile(FTPClient clienteFTP, String pathRemoto, String archivoLocal)
        throws IOException {
    DBDataBackup info = new DBDataBackup();
    System.err.println("RetrieveFile");
    System.err.println("Path remoto:" + pathRemoto + "Path guardado: " + archivoLocal);
    info.consoleArea.append("RetrieveFile\n");
    info.consoleArea.append("Path remoto:" + pathRemoto + "Path guardado: " + archivoLocal + "\n");

    File archivoDescarga = new File(archivoLocal);
    File directorio = archivoDescarga.getParentFile();

    if (!directorio.exists()) {
        info.consoleArea.append("Archivo: " + directorio.getName() + "\n");
        directorio.mkdir();
    }
    try (OutputStream outputStream = new BufferedOutputStream(new FileOutputStream(archivoDescarga))) {
        clienteFTP.setFileType(FTP.BINARY_FILE_TYPE);
        return clienteFTP.retrieveFile(pathRemoto, outputStream);
    } catch (IOException ex) {
        throw ex;
    }
}

/**
 * Download folder from FTP
 *
 * @param clienteFtp
 *            FTPClient to use
 * @param directorioRemoto
 *           Folder to donwload
 *
 * 
 * @param directorioLocal
 *           Path where it saves
 * @throws IOException
 *             Exception
 */
public static void retrieveDir(FTPClient clienteFtp, String directorioRemoto, String directorioLocal)
        throws IOException {
    directorioLocal += "/www";
    DBDataBackup info = new DBDataBackup();
    System.err.println("RetrieveDir");
    info.consoleArea.append("RetrieveDir\n");
    System.err.println("Path remoto:" + directorioRemoto + "Path guardado: " + directorioLocal);
    info.consoleArea.append("Path remoto:" + directorioRemoto + "Path guardado: " + directorioLocal + "\n");
    FTPFile[] ftpFiles = clienteFtp.listFiles(directorioRemoto);
    if (ftpFiles == null || ftpFiles.length == 0) {
        return;
    }
    for (FTPFile ftpFile : ftpFiles) {
        info.consoleArea.append("Directorio: " + ftpFile.getName() + "\n");
        String ftpFileNombre = ftpFile.getName();
        if (ftpFileNombre.equals(".") || ftpFileNombre.equals("..")) {

            continue;
        }
        String archivoLocal = directorioLocal + "/" + ftpFileNombre;
        String archivoRemoto = directorioRemoto + "/" + ftpFileNombre;
        if (ftpFile.isDirectory()) {

            File nuevoDirectorio = new File(archivoLocal);
            nuevoDirectorio.mkdirs();

            retrieveDir(clienteFtp, archivoRemoto, archivoLocal);
        } else {

            retrieveFile(clienteFtp, archivoRemoto, archivoLocal);
        }
    }
 }
}