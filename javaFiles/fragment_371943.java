$.ajax({
    dataType: "json",
    method: "POST",
    url: 'publicProcurements/' + publicProcurementId + '/selectCandidates/informCandidacies/saveInformCandidacies.do',
    data: $('#informCandidaciesForm').serialize(),
    success: function (data) {
        //Whatever you want, like close the dialog
    }
});