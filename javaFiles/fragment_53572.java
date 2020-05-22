<xsl:transform xmlns:xsl="http://www.w3.org/1999/XSL/Transform version="2.0">
  <xsl:template match="/">
    <xsl:for-each-group select="//row" group-adjacent="deptId">
      <xsl:result-document href="{current-grouping-key()}.xml">
        <ABC>
         <END />
          <Tables>
           <START>
            <xsl:copy-of select="current-group()"/>
           </START>
          </Tables>
        </ABC>
      </xsl:result-document>
    </xsl:for-each-group>
  </xsl:template>
</xsl:transform>