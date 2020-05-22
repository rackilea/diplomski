package forum9881188;

import java.io.*;
import javax.xml.bind.annotation.*;
import org.eclipse.persistence.oxm.annotations.*;

@XmlRootElement(name = "UseCaseView")
public class FindRequestDTO implements Serializable {

    private static final long serialVersionUID = 5528726225975606325L;

    private ApiRequestDTO apiRequest;

    @XmlPath("FindCandidates/CandidatesRequest/APIRequest")
    public ApiRequestDTO getAPIRequest() {
        return apiRequest;
    }

    public void setAPIRequest(ApiRequestDTO apiRequest) {
        this.apiRequest = apiRequest;
    }

}