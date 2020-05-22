$('#submitForm').submit(function(e) {

            var frm = $('#submitForm');
            e.preventDefault();

            var data = {};
            var dt=[];
            var newdt = {};
            var Form = this;

            $.each(this, function(i, v) {
                var input = $(v);
                if(data.hasOwnProperty("fkcl")) //mapped all dropdown values to fkcl and fkdiv inorder to use `TestDto` variables
                    {
                    if(data.hasOwnProperty("fkdiv"))
                        {
                        dt.push(data);
                        data={};
                        }
                    }
                data[input.attr("name")] = input.val();
                delete data["undefined"];
            });


            newdt['list']=dt;
            alert(JSON.stringify(newdt));

            $.ajax({
                 async : false,
                global : false, 
                contentType : 'application/json; charset=utf-8',
                type : 'post',
                url : frm.attr('action'),
                data : JSON.stringify(newdt),

                success : function(callback) {
                    window.location.reload();
                },
                error : function() {
                    $(this).html("Error!");
                } 
            });