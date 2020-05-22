LocationBean temp_location_bean = this.locations_as_beans_list.get(params[0]);
if (temp_location_bean != null) {
    master_location = temp_location_bean.getCity() + "," 
            + temp_location_bean.getState() 
            + ", (" + temp_location_bean.getZip_code() +")";
}