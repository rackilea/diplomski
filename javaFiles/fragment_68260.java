package com.myproject.bundle.core.services.impl;

import java.io.IOException;
import java.net.URI;
import java.nio.charset.Charset;

import org.apache.commons.io.IOUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.http.HttpStatus;
import org.apache.http.entity.ContentType;
import org.apache.jackrabbit.util.Base64;
import org.apache.sling.api.resource.ValueMap;
import org.apache.sling.commons.json.JSONArray;
import org.apache.sling.commons.json.JSONException;
import org.apache.sling.commons.json.JSONObject;
import org.apache.sling.commons.osgi.PropertiesUtil;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.akamai.edgegrid.signer.ClientCredential;
import com.akamai.edgegrid.signer.exceptions.RequestSigningException;
import com.akamai.edgegrid.signer.googlehttpclient.GoogleHttpClientEdgeGridRequestSigner;
import com.day.cq.replication.AgentConfig;
import com.day.cq.replication.ReplicationActionType;
import com.day.cq.replication.ReplicationException;
import com.day.cq.replication.ReplicationResult;
import com.day.cq.replication.ReplicationTransaction;
import com.day.cq.replication.TransportContext;
import com.day.cq.replication.TransportHandler;
import com.myproject.bundle.core.configuration.BaseConfigurationService;
import com.myproject.bundle.core.constants.MyConstants;
import com.myproject.bundle.core.search.services.MyProjectConfigurationService;
import com.google.api.client.http.ByteArrayContent;
import com.google.api.client.http.GenericUrl;
import com.google.api.client.http.HttpHeaders;
import com.google.api.client.http.HttpRequest;
import com.google.api.client.http.HttpRequestFactory;
import com.google.api.client.http.HttpResponse;
import com.google.api.client.http.HttpTransport;
import com.google.api.client.http.apache.ApacheHttpTransport;

/**
 * Transport handler to send test and purge requests to Akamai and handle
 * responses. The handler sets up basic authentication with the user/pass from
 * the replication agent's transport config and sends a GET request as a test
 * and POST as purge request. A valid test response is 200 while a valid purge
 * response is 201.
 * 
 * The transport handler is triggered by setting your replication agent's
 * transport URL's protocol to "akamai://".
 *
 * The transport handler builds the POST request body in accordance with
 * Akamai's Fast Purge REST API {@link https://developer.akamai.com/api/core_features/fast_purge/v3.html}
 * using the replication agent properties. 
 */
@Component(service = TransportHandler.class, immediate = true)
public class AkamaiTransportHandler implements TransportHandler {

    /**The Solr Server Configuration Service.*/
    @Reference
    MyProjectConfigurationService myProjectConfigurationService;

    @Reference
    BaseConfigurationService baseConfigurationService;

    /**Logger Instantiation for Akamai Transport Handler*/
    private static final Logger LOGGER = LoggerFactory.getLogger(AkamaiTransportHandler.class);

    /** Protocol for replication agent transport URI that triggers this transport handler. */
    private static final String AKAMAI_PROTOCOL = "akamai://";

    /**Config Pid for Akamai Flush*/
    private static final String AKAMAI_FLUSH_CONFIG_PID = "com.myproject.bundle.core.configuration.AkamaiFlushConfiguration";

    /** Replication agent type property name. Valid values are "arl" and "cpcode". */
    private static final String PROPERTY_AKAMAI_TYPE = "type";

    /** Replication agent multifield CP Code property name.*/
    private static final String PROPERTY_AKAMAI_CP_CODES = "4321xxx";

    /** Replication agent domain property name. Valid values are "staging" and "production". */
    private static final String PROPERTY_AKAMAI_DOMAIN = "domain";

    /** Replication agent action property name. Valid values are "remove" and "invalidate". */
    private static final String PROPERTY_AKAMAI_ACTION = "action";

    /** Replication agent default type value */
    private static final String PROPERTY_AKAMAI_TYPE_DEFAULT = "url";

    /** Replication agent default domain value */
    private static final String PROPERTY_AKAMAI_DOMAIN_DEFAULT = "production";

    /** Replication agent default action value */
    private static final String PROPERTY_AKAMAI_ACTION_DEFAULT = "invalidate";

    /**Transport URI*/
    private static final String TRANSPORT_URI = "transportUri";

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean canHandle(AgentConfig config) {
        final String transportURI = config.getTransportURI();

        return (transportURI != null) && (transportURI.toLowerCase().startsWith(AKAMAI_PROTOCOL));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ReplicationResult deliver(TransportContext ctx, ReplicationTransaction tx)
            throws ReplicationException {

        final ReplicationActionType replicationType = tx.getAction().getType();

        if (replicationType == ReplicationActionType.TEST) {
            return ReplicationResult.OK;
        } else if (replicationType == ReplicationActionType.ACTIVATE ||
                replicationType == ReplicationActionType.DEACTIVATE ||
                replicationType == ReplicationActionType.DELETE) {
            LOGGER.info("Replication  Type in Akamai Handler: {}", replicationType);
            String resourcePath = tx.getAction().getPath();
            if (StringUtils.startsWith(resourcePath, myProjectConfigurationService.getContentpath()) 
                || StringUtils.startsWith(resourcePath, myProjectConfigurationService.getAssetpath())) {
// checking for my project specific root page and root dam path.
                LOGGER.info("Calling activate in Akamai for path: {}", resourcePath);
                try {
                    return doActivate(ctx, tx);
                } catch (RequestSigningException e) {
                    LOGGER.error("Signing ceremony unsuccessful....");
                    throw new ReplicationException("Signing ceremony unsuccessful: {}", e);
                } catch (IOException e) {
                    LOGGER.error("IO Exception in deliver \n");
                    throw new ReplicationException("IO Exception in deliver: {}", e);
                }
            }
            return ReplicationResult.OK;
        } else {
            throw new ReplicationException("Replication action type " + replicationType + " not supported.");
        }
    }

    private String getTransportURI(TransportContext ctx) throws IOException {
        LOGGER.info("Entering getTransportURI method.");
        final ValueMap properties = ctx.getConfig().getProperties();
        final String AKAMAI_HOST = baseConfigurationService.getPropValueFromConfiguration(AKAMAI_FLUSH_CONFIG_PID, "akamaiHost");
        final String domain = PropertiesUtil.toString(properties.get(PROPERTY_AKAMAI_DOMAIN), PROPERTY_AKAMAI_DOMAIN_DEFAULT);
        final String action = PropertiesUtil.toString(properties.get(PROPERTY_AKAMAI_ACTION), PROPERTY_AKAMAI_ACTION_DEFAULT);
        final String type = PropertiesUtil.toString(properties.get(PROPERTY_AKAMAI_TYPE), PROPERTY_AKAMAI_TYPE_DEFAULT);
        String defaultTransportUri = MyConstants.HTTPS + AKAMAI_HOST + "/ccu/v3/"
                                    + action + MyConstants.BACK_SLASH + type + MyConstants.BACK_SLASH + domain;
        String transporturi = PropertiesUtil.toString(properties.get(TRANSPORT_URI), defaultTransportUri);

        if(StringUtils.isEmpty(transporturi)) {
            return defaultTransportUri;
        }
        if (transporturi.startsWith(AKAMAI_PROTOCOL)) {
            transporturi = transporturi.replace(AKAMAI_PROTOCOL, MyConstants.HTTPS);
        }
        transporturi =  transporturi + "/ccu/v3/"
                + action + MyConstants.BACK_SLASH + type + MyConstants.BACK_SLASH + domain;
        LOGGER.info("Exiting getTransportURI method of Akamai Transport Handler : {}", transporturi);
        return transporturi;
    }

    /**
     * Send purge request to Akamai via a POST request
     *
     * Akamai will respond with a 201 HTTP status code if the purge request was
     * successfully submitted.
     *
     * @param ctx Transport Context
     * @param tx Replication Transaction
     * @return ReplicationResult OK if 201 response from Akamai
     * @throws ReplicationException
     * @throws RequestSigningException 
     * @throws IOException 
     * @throws JSONException 
     */
    private ReplicationResult doActivate(TransportContext ctx, ReplicationTransaction tx)
            throws ReplicationException, RequestSigningException, IOException {
        LOGGER.info("Inside doActivate of Akamai");
        final String AKAMAI_ACCESS_TOKEN = baseConfigurationService.getPropValueFromConfiguration(AKAMAI_FLUSH_CONFIG_PID, "akamaiAccessToken");
        final String AKAMAI_CLIENT_TOKEN = baseConfigurationService.getPropValueFromConfiguration(AKAMAI_FLUSH_CONFIG_PID, "akamaiClientToken");
        final String AKAMAI_CLIENT_SECRET = baseConfigurationService.getPropValueFromConfiguration(AKAMAI_FLUSH_CONFIG_PID, "akamaiClientSecret");
        final String AKAMAI_HOST = baseConfigurationService.getPropValueFromConfiguration(AKAMAI_FLUSH_CONFIG_PID, "akamaiHost");

        ClientCredential clientCredential = ClientCredential.builder().accessToken(AKAMAI_ACCESS_TOKEN).
                clientToken(AKAMAI_CLIENT_TOKEN).clientSecret(AKAMAI_CLIENT_SECRET).host(AKAMAI_HOST).build();


        HttpTransport httpTransport = new ApacheHttpTransport();
        HttpRequestFactory httpRequestFactory = httpTransport.createRequestFactory();

        JSONObject jsonObject = createPostBody(ctx, tx);


        URI uri = URI.create(getTransportURI(ctx));

        HttpRequest request = httpRequestFactory.buildPostRequest(new GenericUrl(uri), ByteArrayContent.fromString("application/json", jsonObject.toString()));
        final HttpResponse response = sendRequest(request, ctx, clientCredential);


        if (response != null) {
            final int statusCode = response.getStatusCode();
            LOGGER.info("Response code recieved: {}", statusCode);
            if (statusCode == HttpStatus.SC_CREATED) {
                return ReplicationResult.OK;
            }
        }
        return new ReplicationResult(false, 0, "Replication failed");
    }

    /**
     * Build preemptive basic authentication headers and send request.
     *
     * @param request The request to send to Akamai
     * @param ctx The TransportContext containing the username and password
     * @return JSONObject The HTTP response from Akamai
     * @throws ReplicationException if a request could not be sent
     * @throws RequestSigningException 
     */
    private HttpResponse sendRequest(final HttpRequest request, final TransportContext ctx,
            ClientCredential clientCredential)
            throws ReplicationException, RequestSigningException {

        LOGGER.info("Inside Send Request method of Akamai");
        final String auth = ctx.getConfig().getTransportUser() + ":" + ctx.getConfig().getTransportPassword();
        final String encodedAuth = Base64.encode(auth);

         HttpHeaders httpHeaders = new HttpHeaders();
         httpHeaders.setAuthorization("Basic " + encodedAuth);
         httpHeaders.setContentType(ContentType.APPLICATION_JSON.getMimeType());

         request.setHeaders(httpHeaders);

         GoogleHttpClientEdgeGridRequestSigner requestSigner = new GoogleHttpClientEdgeGridRequestSigner(clientCredential);
         requestSigner.sign(request);

         HttpResponse response;

         try {
             response = request.execute();
         } catch (IOException e) {
             LOGGER.error("IO Exception in sendRequest");
             throw new ReplicationException("Could not send replication request.", e);
         }
         LOGGER.info("Sucessfully executed Send Request for Akamai");
         return response;
    }

    /**
     * Build the Akamai purge request body based on the replication agent
     * settings and append it to the POST request.
     *
     * @param request The HTTP POST request to append the request body
     * @param ctx TransportContext
     * @param tx ReplicationTransaction
     * @throws ReplicationException if errors building the request body 
     */
    private JSONObject createPostBody(final TransportContext ctx,
            final ReplicationTransaction tx) throws ReplicationException {
        final ValueMap properties = ctx.getConfig().getProperties();
        final String type = PropertiesUtil.toString(properties.get(PROPERTY_AKAMAI_TYPE), PROPERTY_AKAMAI_TYPE_DEFAULT);
        JSONObject json = new JSONObject();
        JSONArray purgeObjects = null;

        if (type.equals(PROPERTY_AKAMAI_TYPE_DEFAULT)) {
            try {
                String content = IOUtils.toString(tx.getContent().getInputStream(), Charset.defaultCharset());

                if (StringUtils.isNotBlank(content)) {
                    LOGGER.info("Content of Akamai is:\n {}", content);
                    purgeObjects = new JSONArray(content);
                }
            } catch (JSONException | IOException e) {
                throw new ReplicationException("Could not retrieve content from content builder", e);
            }
        }
        if (null != purgeObjects && purgeObjects.length() > 0) {
            try {
                json.put("objects", purgeObjects);
            } catch (JSONException e) {
                throw new ReplicationException("Could not build purge request content", e);
            }
        } else {
            throw new ReplicationException("No CP codes or pages to purge");
        }
        return json;
    }
}