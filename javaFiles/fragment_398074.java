@PUT
@Path("/generateXls")
@Consumes("text/plain")
@Produces({ "application/xls" })
public Response sendWorkBook(String json) throws Exception {
    System.out.println("json: " + json);
    createWorkbook(json);

getFile: function() {
    var urlXls = 'http://localhost:8080/KodiakWebS/Kodiak/KodiakXls/generateXls';
    //var json =  '{"xls":[{"name":"Pokemon","row":[{"data":"Lugia"},{"data":"Charzard"}]},{"name":"Types","row":[{"data":"Special"},{"data":"Fire"}]}]}';   //encodeURI();
    var json = this.get('tempJSON');
    urlXls = urlXls.replace(/\s/g, "");
    $.ajax({
        type: "PUT",
        url: urlXls,
        data: json,
        contentType: 'text/plain; charset=utf-8',   // ;charset=utf-8',
        success: function(json, status) {
            window.location.href = json.url;
            //window.location.assign(json.url);
            //alert("yay");
        },
        error: function(xhr, err) {
           debugger;
            alert(xhr+ " || " + err);
        }
    });
},