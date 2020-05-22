$("input").each(function(){



if(id!='sexo' || id!='civil'){

     var id = $(this).attr("name");
     var value = $(this).val();

     var item = {};
    item ["name"] = id;
    item ["value"] = value;

    form.push(item);

}


});

 var value1 =$('input:radio[name=sexo]:checked').val();
 var value2 =$('input:radio[name=civil]:checked').val();

    var item = {};
    item ["name"] = "sexo";
    item ["value"] = value1;

    form.push(item);

    var item = {};
    item ["name"] = "civil";
    item ["value"] = value2;

    form.push(item);


return JSON.stringify(form);