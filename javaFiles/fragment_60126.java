<xsl:template match="/*">
    <xsl:copy>
        <xsl:element name="{string[1]}">
            <xsl:value-of select="string[2]" />
        </xsl:element>
    </xsl:copy>
</xsl:template>