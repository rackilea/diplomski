$("#myEntryForm").submit(function(e){
               $.ajax({
                    url: 'your form action url',
                    type: 'post',
                    data:$(this).serialize(),
                    success: function() {
                        alert('success');
                    }
                })        
           });