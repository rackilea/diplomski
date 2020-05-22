function addOnclickToDatatableRows() {
    //gets all the generated rows in the html table
    var trs = document.getElementById('form:dataTable').getElementsByTagName('tbody')[0]
        .getElementsByTagName('tr');
    //on every row, add onclick function (this is what you're looking for)
    for (var i = 0; i < trs.length; i++) {
        trs[i].onclick = new Function("highlightAndSelectRow(this)");
    }
}