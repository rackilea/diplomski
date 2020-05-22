public class NikeIdgenRes implements Serializable{

    @JsonProperty("bundleID")
    private String bundleID;
    @JsonProperty("ids")
    private List<Id> ids = null;
    @JsonProperty("gtin")
    private String gtin;
    @JsonProperty("quantity")
    private Integer quantity;
    @JsonProperty("types")
    private List<String> types = null;
    @JsonProperty("meta")
    private Meta meta;

    // getters & setters
    }

public NikeIdgenRes addNikeIdgen(NikeIdgenRq nikeIdgenRq) { 

            String url = "https://idgen-dev.connected-product.edflab.nikecloud.net/sensors/id_bundle/v1";

            HttpEntity<NikeIdgenRq> httpEntity = new HttpEntity<>(nikeIdgenRq, getHttpHeaders());
            ResponseEntity<NikeIdgenRes> result = restTemplateBuilder.build().postForEntity(url, httpEntity, NikeIdgenRes.class);

            NikeIdgenRes nikeIdgenRes = new NikeIdgenRes();
            nikeIdgenRes.setBundleID(result.getBody().getBundleID());
            nikeIdgenRes.setIds(result.getBody().getIds());
            nikeIdgenRes.setGtin(result.getBody().getGtin());
            nikeIdgenRes.setQuantity(result.getBody().getQuantity());
            nikeIdgenRes.setTypes(result.getBody().getTypes());
            nikeIdgenRes.setMeta(result.getBody().getMeta());

           return nikeIdgenRes;
       }