let newJSON = [];

//Assume the json variable is the parsed JSON file you posted.
for (let element of json) {

    //Must have at least one error
    if (element.errors.length > 0) {

        //Create a new object
        let newObj = {
            "product_id" : element.product_id,
            "errors" : []
        };

        //Add each errror

        for (let error of element.errors) {

            //Only copy across what we need
            newObj.errors.push({
                "property" : error.property,
                "message" : error.message
            });
        }

        //Add object to our new array of JSON
        newJSON.push(newObj);
    }
}

//newJSON is your processed JSON output