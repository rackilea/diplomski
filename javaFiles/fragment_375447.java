<sites
        jcr:primaryType="nt:unstructured"
        sling:resourceType="granite/ui/components/coral/foundation/form/multifield"
        class="full-width"
        composite="{Boolean}true"
        fieldDescription="Click '+' to add a new page"
        fieldLabel="Sites">
    <field
            jcr:primaryType="nt:unstructured"
            sling:resourceType="granite/ui/components/coral/foundation/container"
            name="./sites">
        <layout
                jcr:primaryType="nt:unstructured"
                sling:resourceType="granite/ui/components/foundation/layouts/fixedcolumns"
                method="absolute"/>
        <items jcr:primaryType="nt:unstructured">
            <column
                    jcr:primaryType="nt:unstructured"
                    sling:resourceType="granite/ui/components/foundation/container">
                <items jcr:primaryType="nt:unstructured">
                    <state
                            jcr:primaryType="nt:unstructured"
                            sling:resourceType="granite/ui/components/coral/foundation/form/textfield"
                            fieldLabel="Site"
                            fieldDescription="Enter name of specific site"
                            name="./site"/>
                    <path
                            jcr:primaryType="nt:unstructured"
                            sling:resourceType="granite/ui/components/coral/foundation/form/textfield"
                            fieldLabel="Path"
                            fieldDescription="Select Path"
                            name="./path"/>
                </items>
            </column>
        </items>
    </field>
</sociallist>