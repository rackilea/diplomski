$(".button-details").click(function (e) {
        e.preventDefault();
            let user_id = $(this).data('iduser');
            let debut = $(this).data('debut');
            let fin = $(this).data('fin');
            let project_id = $(this).data('idproject');

            $.ajaxSetup({
            headers: {
                'X-CSRF-TOKEN': $('meta[name="csrf-token"]').attr('content')
                }
        });

        $.ajax( {
            url: '/details_project',
            type: 'POST',
            data: {
                user_id: user_id,
                project_id: project_id,
                debut: debut,
                fin: fin
            },
            success: function (data) {
                    console.log(data);
            },
            error : function() {
                console.log('ERROR');
            }
        });
    });