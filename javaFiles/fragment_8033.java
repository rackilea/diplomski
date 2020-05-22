You need to wrap your pojo class in another containing an ExclusionList property.
Try this. The examples below uses lombok for getters , setters and default constructor.


import java.util.List;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

import lombok.Data;

@Data
public class ExclusionListWrapper {

    @JsonProperty("ExclusionList")
    private ExclusionList exclusionList;

    @Data
    class ExclusionList {
        List<String>    serviceLevel;
        List<String>    item;

    }

    public static void main(String[] args) throws Exception {
        String data = "{\"ExclusionList\" : {\"serviceLevel\" : [\"sl1\",\"sl2\",\"sl3\"], \"item\" : [\"ABC\",\"XYZ\"]}}";
        ObjectMapper mapper = new ObjectMapper();
        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        ExclusionListWrapper exclusionlistWrapper = mapper.readValue(data, ExclusionListWrapper.class);
        List<String> excllist = exclusionlistWrapper.getExclusionList().getServiceLevel();
        for (int i = 0; i < excllist.size(); i++) {
            System.out.println(excllist.get(i));
        }
    }

}