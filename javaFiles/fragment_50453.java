function incrementAge(){

    var person = {name:"Hubert",age:32};

    $.ajax({

        dataType: "json",
        url: "/myapp/MyAction",
        type: "POST",
        data: {
            person: JSON.stringify(person)
        }

    })
    .done(function (response, textStatus, jqXHR) {

        alert(response.name);//Hubert
        alert(response.age);//33
        //Do stuff here
    });
}