function countdown() {
    document.getElementById("btn_second_req").style.display = 'none';
    var flag = '';
    // all code to prepare for AJAX call

    // AJAX called, return also fetched in a variable "flag".
    if (XMLHttpRequestObject.readyState == 4 && XMLHttpRequestObject.status == 200) {
        flag = XMLHttpRequestObject.responseText;
    }

    if (flag == 'yes') {
        document.getElementById("btn_second_req").style.display = 'block';
    }
}