onAuthorize: function(data, actions) {

        // Get the payment details

        return actions.payment.get().then(function(data) {

            // Display the payment details and a confirmation button. You may want to save the queried data to your server, make sure to do this here

            var shipping = data.payer.payer_info.shipping_address;

            document.querySelector('#recipient').innerText = shipping.recipient_name;
            document.querySelector('#line1').innerText     = shipping.line1;
            document.querySelector('#city').innerText      = shipping.city;
            document.querySelector('#state').innerText     = shipping.state;
            document.querySelector('#zip').innerText       = shipping.postal_code;
            document.querySelector('#country').innerText   = shipping.country_code;

            document.querySelector('#paypal-button-container').style.display = 'none';
            document.querySelector('#confirm').style.display = 'block';

            // Listen for click on confirm button

            document.querySelector('#confirmButton').addEventListener('click', function() {

                // Button click event code

                // Execute the payment

                return actions.payment.execute().then(function() {

                    // payment executed code
                    // display confirmation, thank you notes and whatnot
                });
            });
        });
    }