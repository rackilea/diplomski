int socketTimeout = 30000;
$.ajax(new AjaxOptions().url(cityListUrl)
                        .timeout(socketTimeout)
                        .success(new Function() {
                            public void invoke($ d, Object... args) {
                                JSONObject jsonResults = (JSONObject) args[0];
                                //Any call
                            }
                        })
                        .error(new Function() {
                            public void invoke($ d, Object... args) {
                                AjaxError error = (AjaxError) args[0];
                                Log.e("Ajax", error.toString());
                            }
                        }));