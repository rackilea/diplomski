<select class="form-control col-md-10">
    <option
        th:each="option : ${T(com.jequiti.JequitiIntegrador.controller.AtributoController).test(valorAtributo.sqlValidacao)}"
        th:value="${{option.valorAtributo}}"
        th:text="${option.significadoAtributo}"
        th:selected="${valorAtributo.valorUsuario == option.valorAtributo}" />
</select>