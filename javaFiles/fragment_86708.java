rules : {
    'email': {
        required: true,
        email: true,
        remote: {
            url: "/user/registered/email/" + $('#email').val(),
            processData: false
        }
    },
},