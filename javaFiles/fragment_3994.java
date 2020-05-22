$(".uploadDocumentGeneral").on("click", function (evt) {
    IdToEdit = $(this).closest('tr').siblings().find('p.important').text();
    var url = "http://localhost:10110/MavenProject/api123/General123/upload/"+IdToEdit;
    evt.preventDefault();

    var documentData = new FormData();
    documentData.append('file', $('input#file.findDocumentOnboarding')[0].files[0]);
    $.ajax({
        url: url,
        type: 'POST',
        data: documentData,
        cache: false,
        contentType: false,
        processData: false,
        success: function (response) {
            alert("Document uploaded successfully.");
        }
    });

    return false;
});