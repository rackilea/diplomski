<div th:if="${Users == true}"  >
   <header th:include="../templates/SellerTemplate :: header" id="header">
   </header>
</div>
<div th:if="${Users == false}" >
   <header  th:include="../templates/homeTemplate :: header" id="header">
   </header> 
</div>