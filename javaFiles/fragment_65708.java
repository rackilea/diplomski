$.ajax({
    type : 'POST',
    url : serviceUrl + 'requestOrder',
    crossDomain : true,
    data : { order : $.toJSON({ ...orderdata... }) },
    contentType : 'application/json; charset=UTF-8'
});