<ice:panelGrid columns="2" rendered="#{nameBean.studentDetails.visible }">
                <ice:outputLabel value="Name"></ice:outputLabel>
                <ice:outputText value="#{nameBean.studentDetails.name }"></ice:outputText>
                <ice:outputLabel value="Age"></ice:outputLabel>
                <ice:outputText value="#{nameBean.studentDetails.age }"></ice:outputText>
                <ice:outputLabel value="Gender"></ice:outputLabel>
                <ice:outputText value="#{nameBean.studentDetails.gender }"></ice:outputText>
                <ice:outputLabel value="Location"></ice:outputLabel>
                <ice:outputText value="#{nameBean.studentDetails.location }"></ice:outputText>
            </ice:panelGrid>