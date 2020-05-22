public Response postJSON(String postData) {
    JSONObject data = JSONObject.fromObject(postData);
    if (data.has("resourceB")) {
        ResourceB resourceB = new ResourceB(/* pass here the modified query param */ "my new param 1");
        // let the DI provider inject the JAX-RS annotated fields only
        resourceB = rc.initResource(resourceB);
        // resourceB.setQueryParams("param1", "my new param 1");
        resourceB.postJSON(data.getJSONArray("resourceB"));
    }
}