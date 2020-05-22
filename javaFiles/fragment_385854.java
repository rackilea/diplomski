<rich:dataTable id="acadCertList"
value="#{myCertBean.employeeCertEventObjects}"
var="_certs" rowKeyVar="row" >

  <f:facet name="header">

<rich:columnGroup>
    <rich:column>
        <h:outputText value="Row" />
    </rich:column>
    <rich:column>
    <h:outputText value="Name" />
    </rich:column>

  <!-- dynamically create the certType1, certType2 …  column headers -->
    <rich:columns value="#{myCertBean.selectedCertTypeList}"
            var="_selCrtType" colspan="2">
        <h:outputText value="#{_selCrtType.certType}" />
    </rich:columns>
</rich:columnGroup>
 </f:facet>

 <rich:subTable value="#{_certs}" var="_cEmpObj">
<f:facet name="header">
  <!-- repeat start end column headers for each certType -->

    <rich:columnGroup>
        <rich:column>
 </rich:column>
        <rich:column>
        </rich:column>
        <c:forEach items="#{myCertBean.selectedCertTypeList}">
 <rich:column>
                <h:outputText value="Start" />
            </rich:column>
 <rich:column 
                <h:outputText value="End" />
            </rich:column>
 </c:forEach>
    </rich:columnGroup>
</f:facet>
 <!-- load data for each row -->

<rich:column id="row_#{row}">
    <h:outputText value="#{row+1}" />
</rich:column>
<rich:column id="name_#{row}">
    <h:outputText value="#{_cEmpObj.name}/>
</rich:column>

<c:forEach items="#{myCertBean.selectedCertTypeList}" varStatus="status">
    <rich:column id="curexp_#{status.index}" 
        <h:outputText
 value="#{_cEmpObj.certEventsByCertTypeSysid[status.index].startDate}" />
    </rich:column>
    <rich:column id="curexp_#{status.index}" 
        <h:outputText
 value="#{_cEmpObj.certEventsByCertTypeSysid[status.index].endDate}" />
    </rich:column>
 </c:forEach> 

 </rich:subTable>

 </rich:dataTable>