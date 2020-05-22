//Assign your error handling function to a variable
                var iceErrorCallback = function iceHandleError(statusCode, responseTxt, responseDOM) {
                    //Handle all errors by simply redirecting to an error page
                    window.location.href = "./generalError.xhtml";
                }

                //Safely check if ICEfaces is available
                if (ice) {
                    //Turn off the popups as we plan to handle this ourselves
                    ice.configuration.disableDefaultIndicators = true;

                    //Register your error handler as a callback
                    ice.onServerError(iceErrorCallback);
                }