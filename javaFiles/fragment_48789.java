<af:commandButton text="Hidden Button" binding="#{pageFlowScope.myBean.btnHiddenButton}"
                  id="cb1" visible="false">
  <af:fileDownloadActionListener method="#{pageFlowScope.myBean.exportReport}"/>
</af:commandButton>

<af:commandButton text="Visible Button" 
                  id="cb2" 
                  action="#{pageFlowScope.myBean.saveSelection}/>