function fetch_rollno(rollno)
{
     var st_roll_no="After fetching the result is ";    
     $.ajax({
                type: "POST",
                url: 'validate_rollno',
                data: {rollno: rollno},
                success: function(result) 
                {
                    st_roll_no+= (result == "found") ?"found" : "notfound";
                    alert("st_roll_no");
                }
            });
}