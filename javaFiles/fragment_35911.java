function submitForm(formID, url) {
var assetIdList = [];
var assetIdObj;
$("#" + formID).find('.assetId').each(function () {
    assetIdObj = {};
    assetIdObj.assetID = $(this).val();
    assetIdList.push(assetIdObj);
});

$.ajax({
    dataType: 'json',
    url: url,
    data: {assetCategories: assetIdList},
    type: "POST",
    enctype: "multipart/form-data",
    processData: false,
    contentType: false,
    success: function (data) {
        if (data.status === 1) {
            openAlertDialog("Success", "The Asset type has been deleted!", "Continue", "manage-assets");
        } else {
            openAlertDialog("Error", data.message, "Continue", "manage-assets");
        }
    },
    error: function (data) {
        openAlertDialog("Error", data.message, "Continue", "manage-assets");
    },
});
}