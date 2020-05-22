package backend;

import com.google.api.server.spi.config.Api;
import com.google.api.server.spi.config.ApiMethod;
import com.google.api.server.spi.response.CollectionResponse;

import javax.annotation.Nullable;
import javax.inject.Named;

//Changing api name
@Api(name = "generalendpoint")
public class GroupEndpoint {

    @ApiMethod(name = "listContact")
    public CollectionResponse<Group> listGroup(
            @Nullable @Named("cursor") String cursorString,
            @Nullable @Named("limit") Integer limit) {
        return null;
    }
}