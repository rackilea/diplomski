function uploadFile(){
   $.ajaxForm({
        "formId": "frm-file",
        "method": "POST",
        "actionURL": context_path + "upload",
        "successFun": function (data) {

        }
    });
}