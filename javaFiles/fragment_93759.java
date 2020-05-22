$('#testButton').click(function(){
               var testList= [];

            $('.submit').filter(':checked').each(function() {
            var checkedFrom= $(this).closest('form');
            var testPojo= checkedFrom.serializeObject();
            testList.push(testPojo);
            });

            $.ajax({
            'type': 'POST',
                'url':"testMethod",
                'contentType': 'application/json',
                'data': JSON.stringify(testList),
                'dataType': 'json',
                success: function(data) {

                if (data == 'SUCCESS')
                {
                alert(data);
                }
                else
                    {
                    alert(data);
                    }

                }
            });

        });