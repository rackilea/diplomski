<!-- Root node -->
<xsl:template match="/">
    <div class="element">
        &lt;<span class="name"><xsl:value-of select="name()"/></span><xsl:apply-templates select="@*"/>
        <!-- Grab all namespaces and declare them.  distinct-values() is XPath 2.0, however. -->
        <xsl:for-each select="distinct-values(//namespace::*)">
            xmlns:<xsl:value-of select="name()" />="<xsl:value-of select="." />"
        </xsl:for-each>
        &gt;
        <xsl:apply-templates select="node()"/>
        &lt;/<span class="name"><xsl:value-of select="name()"/></span>&gt;
    </div>
</xsl:template>