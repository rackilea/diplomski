package google;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.apache.commons.io.FileUtils;

import com.google.api.client.googleapis.auth.oauth2.GoogleCredential;
import com.google.api.client.googleapis.javanet.GoogleNetHttpTransport;
import com.google.api.client.http.FileContent;
import com.google.api.client.http.HttpTransport;
import com.google.api.client.json.JsonFactory;
import com.google.api.client.json.jackson2.JacksonFactory;
import com.google.api.client.util.store.FileDataStoreFactory;
import com.google.api.services.drive.Drive;
import com.google.api.services.drive.DriveScopes;
import com.google.api.services.drive.model.File;
import com.google.api.services.drive.model.FileList;
import com.google.auth.oauth2.*;
import com.google.cloud.storage.*;

import controllers.GlobalUtilities.StringControl;
import play.Configuration;
import play.Logger;

/**
 * @author Dan Zeller
 *
 */

public class GoogleControl {

    private static final String APPLICATION_NAME = "PTP";
    private static final JsonFactory JSON_FACTORY = JacksonFactory.getDefaultInstance();
    private static HttpTransport HTTP_TRANSPORT;
    private static final String BUCKET_NAME = Configuration.root().getString("google.storage.bucket.name");
    public static final String FILE_PREFIX = "stream2file";
    public static final String FILE_SUFFIX = ".tmp";

    static {
        try {
            HTTP_TRANSPORT = GoogleNetHttpTransport.newTrustedTransport();
        } catch (Throwable t) {
            t.printStackTrace();
            System.exit(1);
        }
    }

    @SuppressWarnings("deprecation")
    public static GoogleCredential authorize() throws IOException {
        GoogleCredential credential = null;
        String credentialsFileName = "";
        try {
            Logger.info("GoogleControl: authorize: Starting...");

            Logger.info("GoogleControl: authorize: Getting credentialsFileName path...");
            credentialsFileName = Configuration.root().getString("google.drive.credentials.file");
            Logger.info("GoogleControl: authorize: credentialsFileName = " + credentialsFileName);

            Logger.info("GoogleControl: authorize: Setting InputStream...");
            InputStream in = GoogleControl.class.getClassLoader().getResourceAsStream(credentialsFileName);
            if (in == null) {
                Logger.info("GoogleControl: authorize: InputStream is null");
            }
            Logger.info("GoogleControl: authorize: InputStream set...");

            Logger.info("GoogleControl: authorize: Setting credential...");
            credential = GoogleCredential.fromStream(in, HTTP_TRANSPORT, JSON_FACTORY)
                    .createScoped(Collections.singleton(DriveScopes.DRIVE));
        } catch (IOException ex) {
            System.out.println(ex.toString());
            System.out.println("Could not find file " + credentialsFileName);
            ex.printStackTrace();
        }
        Logger.info("GoogleControl: authorize: Ending...");
        return credential;
    }

    public static java.io.File createFileFromURL(String fileURL, String fileName) throws IOException {

        java.io.File tempFile = null;

        try {
            URL url = new URL(fileURL);
            Logger.info("GoogleControl: createFileFromURL: url = " + url);
            Logger.info("GoogleControl: createFileFromURL: fileName = " + fileName);
            String filePrefix = StringControl.left(fileName, ".") + "_";
            String fileExt = "." + StringControl.rightBack(fileName, ".");
            Logger.info("GoogleControl: createFileFromURL: filePrefix = " + filePrefix);
            Logger.info("GoogleControl: createFileFromURL: fileExt = " + fileExt);

            tempFile = java.io.File.createTempFile(filePrefix, fileExt);

            tempFile.deleteOnExit();
            FileUtils.copyURLToFile(url, tempFile);
            Logger.info("GoogleControl: createFileFromURL: tempFile name = " + tempFile.getName());
        } catch (Exception ex) {
            System.out.println(ex.toString());
            ex.printStackTrace();
        }

        return tempFile;
    }

    public static void downloadFile(String fileID) {
        // Set the drive service...
        Drive service = null;
        try {
            service = getDriveService();
        } catch (IOException e) {
            e.printStackTrace();
        }
        OutputStream outputStream = new ByteArrayOutputStream();
        try {
            service.files().get(fileID).executeMediaAndDownloadTo(outputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String getContentType(String filePath) throws Exception {
        String type = "";
        try {
            Path path = Paths.get(filePath);
            type = Files.probeContentType(path);
            System.out.println(type);
        } catch (Exception ex) {
            System.out.println(ex.toString());
            ex.printStackTrace();
        }
        return type;
    }

    public static Drive getDriveService() throws IOException {
        Logger.info("GoogleControl: getDriveService: Starting...");
        GoogleCredential credential = null;
        Drive GoogleControl = null;
        try {
            credential = authorize();
            Logger.info("GoogleControl: getDriveService: Credentials set...");
            try {
                GoogleControl = new Drive.Builder(HTTP_TRANSPORT, JSON_FACTORY, credential)
                        .setApplicationName(APPLICATION_NAME).build();
            } catch (Exception ex) {
                System.out.println(ex.toString());
                ex.printStackTrace();
            }

        } catch (IOException ex) {
            System.out.println(ex.toString());
            ex.printStackTrace();
        }
        return GoogleControl;
    }

    public static String getPath() {
        String s = GoogleControl.class.getName();
        int i = s.lastIndexOf(".");
        if (i > -1)
            s = s.substring(i + 1);
        s = s + ".class";
        System.out.println("Class Name: " + s);
        Object testPath = GoogleControl.class.getResource(s);
        System.out.println("Current Path: " + testPath);
        return "";
    }

    public static String getSubfolderID(Drive service, String parentFolderID, String folderKeyToGet) {
        // We need to see if the folder exists based on the ID...
        String folderID = "";
        Boolean foundFolder = false;
        FileList result = null;
        File newFolder = null;

        // Set the drive query...
        String driveQuery = "mimeType='application/vnd.google-apps.folder' and '" + parentFolderID
                + "' in parents and name='" + folderKeyToGet + "' and trashed=false";

        try {
            result = service.files().list().setQ(driveQuery).setIncludeTeamDriveItems(true).setSupportsTeamDrives(true)
                    .execute();
        } catch (IOException e) {
            e.printStackTrace();
        }
        for (File folder : result.getFiles()) {
            System.out.printf("Found folder: %s (%s)\n", folder.getName(), folder.getId());
            foundFolder = true;
            folderID = folder.getId();
        }
        if (foundFolder != true) {
            // Need to create the folder...
            File fileMetadata = new File();
            fileMetadata.setName(folderKeyToGet);
            fileMetadata.setTeamDriveId(parentFolderID);
            fileMetadata.set("supportsTeamDrives", true);
            fileMetadata.setMimeType("application/vnd.google-apps.folder");
            fileMetadata.setParents(Collections.singletonList(parentFolderID));

            try {
                newFolder = service.files().create(fileMetadata).setSupportsTeamDrives(true).setFields("id, parents")
                        .execute();
            } catch (IOException e) {
                e.printStackTrace();
            }
            // Send back the folder ID...
            folderID = newFolder.getId();
            System.out.println("Folder ID: " + newFolder.getId());
        }

        return folderID;
    }

    @SuppressWarnings("deprecation")
    public static java.io.File sendFileToBucket(InputStream fileStream, String fileName) throws Exception {
        Logger.info("GoogleControl: sendFileToBucket: Starting...");

        GoogleCredential credential = null;
        String credentialsFileName = "";
        String outputFileName = "";
        Storage storage = null;
        Blob blob = null;
        List<Acl> acls = null;
        java.io.File returnFile = null;

        try {
            Logger.info("GoogleControl: sendFileToBucket: Getting credentialsFileName path...");
            credentialsFileName = Configuration.root().getString("google.storage.credentials.file");
            Logger.info("GoogleControl: sendFileToBucket: credentialsFileName = " + credentialsFileName);

            Logger.info("GoogleControl: sendFileToBucket: Setting InputStream...");
            InputStream in = GoogleControl.class.getClassLoader().getResourceAsStream(credentialsFileName);
            if (in == null) {
                Logger.info("GoogleControl: sendFileToBucket: InputStream is null");
            }
            Logger.info("GoogleControl: sendFileToBucket: InputStream set...");

            try {
                storage = StorageOptions.newBuilder().setCredentials(ServiceAccountCredentials.fromStream(in)).build()
                        .getService();
            } catch (Exception se) {
                System.out.println("--- START ERROR WITH SETTING STORAGE OBJECT ---");
                se.printStackTrace();
                System.out.println("--- END ERROR WITH SETTING STORAGE OBJECT ---");
            }

            // Modify access list to allow all users with link to read file
            acls = new ArrayList<>();
            acls.add(Acl.of(Acl.User.ofAllUsers(), Acl.Role.READER));

            try {
                Logger.info("GoogleControl: sendFileToBucket: Setting Blob object...");
                blob = storage.create(BlobInfo.newBuilder(BUCKET_NAME, fileName).setAcl(acls).build(), fileStream);
                Logger.info("GoogleControl: sendFileToBucket: Blob Object set...");
            } catch (Exception se) {
                System.out.println("--- START ERROR WITH SETTING BLOB OBJECT ---");
                se.printStackTrace();
                System.out.println("--- END ERROR WITH SETTING BLOB OBJECT ---");
            }

            Logger.info("GoogleControl: sendFileToBucket: blob.getMediaLink() = " + blob.getMediaLink());

            // Let's build a java.io.file to send back...
            returnFile = createFileFromURL(blob.getMediaLink(), fileName);

        } catch (Exception ex) {
            System.out.println("--- START ERROR SENDFILETOBUCKET ---");
            ex.printStackTrace();
            System.out.println("--- END ERROR SENDFILETOBUCKET ---");
        }
        return returnFile;
        // return outputFileName;
    }

    public static String uploadFile(java.io.File file, String folderIDToFind) throws IOException {
        String fileID = "";
        String fileName = "";
        try {
            Logger.info("GoogleControl: uploadFile: Starting File Upload...");
            // Build a new authorized API client service.
            Drive service = getDriveService();
            Logger.info("GoogleControl: uploadFile: Completed Drive Service...");

            // Set the folder...
            String folderID = Configuration.root().getString("google.drive.folderid");
            Logger.info("GoogleControl: uploadFile: Folder ID = " + folderID);

            String folderIDToUse = getSubfolderID(service, folderID, folderIDToFind);

            String fullFilePath = file.getAbsolutePath();
            Logger.info("GoogleControl: uploadFile: Full File Path: " + fullFilePath);
            File fileMetadata = new File();

            // Let's see what slashes exist to get the correct file name...
            if (fullFilePath.contains("/")) {
                fileName = StringControl.rightBack(fullFilePath, "/");
            } else {
                fileName = StringControl.rightBack(fullFilePath, "\\");
            }
            String fileContentType = getContentType(fileName);
            Logger.info("GoogleControl: uploadFile: File Content Type: " + fileContentType);
            fileMetadata.setName(fileName);
            Logger.info("GoogleControl: uploadFile: File Name = " + fileName);

            Logger.info("GoogleControl: uploadFile: Setting the folder...");
            fileMetadata.setParents(Collections.singletonList(folderIDToUse));
            Logger.info("GoogleControl: uploadFile: Folder set...");

            // Team Drive settings...
            fileMetadata.set("supportsTeamDrives", true);

            FileContent mediaContent = new FileContent(fileContentType, file);

            File fileToUpload = service.files().create(fileMetadata, mediaContent).setSupportsTeamDrives(true)
                    .setFields("id, parents").execute();

            fileID = fileToUpload.getId();
            Logger.info("GoogleControl: uploadFile: File ID: " + fileID);
        } catch (Exception ex) {
            System.out.println(ex.toString());
            ex.printStackTrace();
        }
        Logger.info("GoogleControl: uploadFile: Ending File Upload...");
        return fileID;
    }

}