$(".bt").on("click", function(e) {
    e.preventDefault();

    var value1 = $("#novoPlastico").val();
    var value2 = $("#grupoAfinidade").val();

    window.location.href = ctx + "/parametros/migrCanais.do?plastNovo=" + value1 + "&grp=" + value2;
})