oReq.onreadystatechange = function() {
                if (oReq.readyState == 4) {
                    if (oReq.status == 200) {
                        //This is where you should put the code (or function call) when everything went ok
                    }
                    if (oReq.status == 404) {
                        //this is when you got a 404 error
                    }
                }
            };