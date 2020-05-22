<select class="setting-input" name="artifactKey" id="genericArtifactKeys-${s.url}">
                                                <f:option value="nuget" selected="${instance.artifactoryKey =='nuget'}">nuget</f:option>
                                                <f:option value="zip" selected="${instance.artifactoryKey =='zip'}">zip</f:option>
                                                <f:option value="msi" selected="${instance.artifactoryKey =='msi'}">msi</f:option>
                                                <f:option value="rpm" selected="${instance.artifactoryKey =='rpm'}">rpm</f:option>
                            </select>