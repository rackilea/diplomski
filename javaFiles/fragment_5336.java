<style name="ZFieldStyle">
    <conditionalStyle>
        <conditionExpression><![CDATA[$F{Z} < $F{Y}]]></conditionExpression>
        <style forecolor="#000000"/>
    </conditionalStyle>
    <conditionalStyle>
        <conditionExpression><![CDATA[$F{Z}>$F{X}]]></conditionExpression>
        <style forecolor="#FF0000"/>
    </conditionalStyle>
</style>
...
<field name="X" class="java.lang.Integer"/>
<field name="Y" class="java.lang.Integer"/>
<field name="Z" class="java.lang.Integer"/>
...
<textField>
    <reportElement style="ZFieldStyle" x="200" y="0" width="100" height="20"/>
    <textElement/>
    <textFieldExpression><![CDATA[$F{Z}]]></textFieldExpression>
</textField>