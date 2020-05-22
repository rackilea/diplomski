function addCombo() {
    var textb = document.getElementById("txtCombo");
    var combo = document.getElementById("combo");

    var option = document.createElement("option");
    <c:forEach var="state" items="${stateList}" varStatus="status">  
    option.text = "${state}";
    option.value = "${state}";
    try {
        combo.add(option, null); //Standard
    }catch(error) {
        combo.add(option); // IE only
    }
    </c:forEach>
    textb.value = "";
}