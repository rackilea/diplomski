function GetCitizenTypeDescription(citizenTypeId){                 
  $.ajax({
    type:'GET',
    url:'getCitizenTypeDescription.htm',
    data:{citizenTypeId:citizenTypeId},
    dataType: 'text',
    success: function (data) {       
       $('.citizenTypeId').each(function(i){                
             //does this value match the parameter
             if($(this).val() === citizenTypeId){ 
                 //find the parent div, in this case .table
                 var parent = $(this).parent();
                 //search for a child with class .citizenTypeDesc
                 var thisCitizenTypeDesc = parent.children('.citizenTypeDesc');

                 thisCitizenTypeDesc.text(data);
             }
       });
    }
  });
}