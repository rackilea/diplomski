package org.springframework.social.facebook.connect;

import java.io.IOException;
import java.util.Collections;
import java.util.HashMap;

import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.http.MediaType;
import org.springframework.http.converter.FormHttpMessageConverter;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.social.oauth2.AccessGrant;
import org.springframework.social.oauth2.OAuth2Template;
import org.springframework.social.support.ClientHttpRequestFactorySelector;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

public class FacebookOAuth2Template extends OAuth2Template {

    private static final Logger LOGGER = LogManager.getLogger(FacebookOAuth2Template.class);

    public FacebookOAuth2Template(String clientId, String clientSecret) {
        super(clientId, clientSecret, "https://www.facebook.com/v1.0/dialog/oauth", "https://graph.facebook.com/v1.0/oauth/access_token");
        setUseParametersForClientAuthentication(true);
    }

    @Override
    protected RestTemplate createRestTemplate() {
        RestTemplate restTemplate = new RestTemplate(ClientHttpRequestFactorySelector.getRequestFactory());
        FormHttpMessageConverter messageConverter = new FormHttpMessageConverter() {
            @Override
            public boolean canRead(Class<?> clazz, MediaType mediaType) {
                // always read as x-www-url-formencoded even though Facebook sets contentType to text/plain
                return true;
            }
        };
        restTemplate.setMessageConverters(Collections.<HttpMessageConverter<?>> singletonList(messageConverter));
        return restTemplate;
    }

    @Override
    @SuppressWarnings("unchecked")
    protected AccessGrant postForAccessGrant(String accessTokenUrl, MultiValueMap<String, String> parameters) {
        MultiValueMap<String, String> response = getRestTemplate().postForObject(accessTokenUrl, parameters, MultiValueMap.class);
        String expires = response.getFirst("expires");
        String accessToken = response.getFirst("access_token");
        if(!response.keySet().isEmpty() && (StringUtils.isEmpty(expires) || StringUtils.isEmpty(accessToken))) {
            for(String key : response.keySet()) {
                boolean valuesFound = false;
                HashMap<String, String> map;
                try {
                    //map = (HashMap<String, String>) JSONUtil.fromJSON(key, HashMap.class);
                    ObjectMapper objectMapper = new ObjectMapper();
                    map = objectMapper.readValue(key, HashMap.class);

                    if(StringUtils.isEmpty(expires)) {
                        expires = String.valueOf(map.get("expires_in"));
                        valuesFound = true;
                    }

                    if(StringUtils.isEmpty(accessToken)) {
                        accessToken = map.get("access_token");
                        valuesFound = true;
                    }

                    if(valuesFound) {
                        break;
                    }
                } catch(IOException e) {
                    LOGGER.error(e.getMessage(), e);
                }
            }
        }
        return new AccessGrant(accessToken, null, null, expires != null ? Long.valueOf(expires) : null);
    }
}