<ui:fragment rendered="#{not empty extra.donwtime_notice}">
    <div class="pnx-msg pnx-msg-warning clearfix">
        <i class="pnx-msg-icon pnx-icon-msg-warning"/>
        <span class="pnx-msg-content"><h:outputText value="#{extra.downtime_notice}" escape="false"/></span>
    </div>
</ui:fragment>