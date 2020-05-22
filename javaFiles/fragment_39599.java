<form id="form" th:action="@{/buscarEmpresa}">
  <input type="hidden" id="empresasId" name="empresasId" value="<empresasId_value_from_select>">
  <input type="radio" name="filtro" value="dia" onclick="submitForm()"> Día
  <input type="radio" name="filtro" value="mes" onclick="submitForm()"> Mes
  <input type="radio" name="filtro" value="ano" onclick="submitForm()"> Año
</form>