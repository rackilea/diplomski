function highlightAndSelectRow(tr) {
    //get all the datatable rows
    var trs = document.getElementById('form:dataTable').getElementsByTagName('tbody')[0]
        .getElementsByTagName('tr');
    //find the selected rowby using the tr parameter
    for (var i = 0; i < trs.length; i++) {
        if (trs[i] == tr) {
            //once found it, change the color (maybe you don't need this part)
            trs[i].bgColor = '#ff0000';
            //update a hidden value in the form (maybe you need this code)
            document.form.rowIndex.value = trs[i].rowIndex;
            //here, you can add js code to open a new window
            //or simulate a button/link click or something else you need.
        } else {
            trs[i].bgColor = '#ffffff';
        }
    }
}