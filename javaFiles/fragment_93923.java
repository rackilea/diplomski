function forceStop()
        {

            var checkboxes = document.getElementsByName('toBeDeleted');
            var selected = new Array();
            for (var i=0; i<checkboxes.length; i++) {
                if (checkboxes[i].checked) {
                    selected.push(checkboxes[i].value);
                }
            }

                $.ajax({
                    url:"PlayerController",
                    type:"POST",
                    dataType:'json',
                    data: {toDelete:selected},
                    success:function(data){
                      alert("SUCCESS");
                    },
                });

        }