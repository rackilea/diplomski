if (form.isValid()) {
        form.submit({

                    url: 'http://localhost:8080/WAR_project/rest/service/ticket/uploadfile',
                    waitMsg: 'Uploading Please Wait...',
                    method: 'POST',                    
                    success: function (r, a) {
                       console.log('success message here')
                    },
                    failure: function (r, a) {                    
                         console.log('failure message here')
                    }
                });
}