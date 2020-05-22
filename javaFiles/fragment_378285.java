<div class="ui-widget ui-widget-content ui-corner-all" style="padding: 10px; margin-bottom: 10px;">
        <label><b>Search Client(*):</b></label>
        <s:url id="loadClientURL" action="loadClient"/>
        <sj:autocompleter
                id="client"
                name="idClient"
                list="listClient"
                href="%{loadClientURL}"
                loadMinimumCount="2" 
                size="70"
        />
        <s:url id="autocompleteClientURL" action="autocompleteClient"/>
        <sj:a href="%{autocompleteClientURL}" cssClass="btn" targets="errorMsg" formIds="saveForm" dataType="json" onCompleteTopics="checkError">Mostrar Información del Cliente</sj:a>
   </div>
   <div>
       <%-- label showing some customer information --%>
   </div>