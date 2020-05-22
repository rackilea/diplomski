import com.google.api.client.googleapis.auth.oauth2.GoogleCredential;
import com.google.api.client.http.HttpTransport;
import com.google.api.client.http.javanet.NetHttpTransport;
import com.google.api.client.json.JsonFactory;
import com.google.api.client.json.jackson.JacksonFactory;

import com.google.api.services.bigquery.Bigquery;
import com.google.api.services.bigquery.BigqueryScopes;
import com.google.api.services.bigquery.Bigquery.Projects;
import com.google.api.services.bigquery.model.*;

import java.io.File;
import java.io.IOException;
import java.security.GeneralSecurityException;
import java.util.List;

public class BigQueryJavaServiceAccount {

  public static void main(String[] args) throws IOException, InterruptedException, GeneralSecurityException {

    final HttpTransport TRANSPORT = new NetHttpTransport();
    final JsonFactory JSON_FACTORY = new JacksonFactory();

    GoogleCredential credential = new  GoogleCredential.Builder()
      .setTransport(TRANSPORT)
      .setJsonFactory(JSON_FACTORY)
      .setServiceAccountId("SOMETHING@developer.gserviceaccount.com")
      .setServiceAccountScopes(BigqueryScopes.BIGQUERY)
      .setServiceAccountPrivateKeyFromP12File(new File("key.p12"))
      .build();

    Bigquery bigquery = Bigquery.builder(TRANSPORT, JSON_FACTORY)
      .setHttpRequestInitializer(credential)
      .build();

    Projects.List projectListRequest = bigquery.projects().list();
    ProjectList projectList = projectListRequest.execute();
    List<ProjectList.Projects> projects = projectList.getProjects();
    System.out.println("Available projects\n----------------\n");
    for (ProjectList.Projects project : projects) {
      System.out.format("%s\n", project.getProjectReference().getProjectId());
    }
  }
}