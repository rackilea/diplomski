<page view-id="/home.xhtml">
        <action execute="#{identity.login}" if="#{not identity.loggedIn}" />
        <param name="username" />
        <navigation from-action="#{identity.login}">
            <rule if="#{identity.loggedIn}">
                <redirect view-id="/home.xhtml"/>
            </rule>
            <rule if="#{not identity.loggedIn}">
                <redirect view-id="/error.xhtml"/>
            </rule>
        </navigation>
    </page>