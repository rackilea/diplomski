if (status == 200) {
    wrapper = response.readEntity(Releases.class);
    ...
} else { 
    handleOtherStatus();   
}