function checkSelected() {
    var ids = "9, 133";
    var idsArr = ids.split(", ");
    var checkboxes = document.getElementsByClassName('gridCheck');
    for (var i = 0; i < checkboxes.length; 
        var index = idsArr.indexOf(checkboxes[i].
        if (index >= 0) {
            var foundId = idsArr[index];
            if (checkboxes[i].value == foundId) {
                checkboxes[i].checked = true;
            }
        }
    }
}