package backend;

import com.google.api.server.spi.config.Api;
import com.google.api.server.spi.config.ApiMethod;
import com.google.api.server.spi.config.ApiNamespace;
import com.google.api.server.spi.response.CollectionResponse;

import javax.annotation.Nullable;
import javax.inject.Named;

@Api(name = "generalendpoint")
public class ContactEndpoint {

    @ApiMethod(name = "listContact")
    public CollectionResponse<Contact> listContact(
            @Nullable @Named("cursor") String cursorString,
            @Nullable @Named("limit") Integer limit) {
        return null;
    }
}