$.ajax({
            type: "GET",
            url:"/demo_trial_application/json_source",
            dataType: "json",
            success: function (data) {
                $.each(data.aaData,function(i,obj)
                {
                 alert(obj.value+":"+obj.text);
                 var div_data="<option value="+obj.value+">"+obj.text+"</option>";
                alert(div_data);
                $(div_data).appendTo('#ch_user1'); 
                });  
                }
          });
        });