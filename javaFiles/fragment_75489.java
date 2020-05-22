$.ajax({
                            dataType: "json",
                            type: 'GET',
                            url: 'servleturl',
                            data: {"personName": marker.getTitle()},
                            success: function(response) {
                              //do stuff here to perform the unique action to the marker}

                       });