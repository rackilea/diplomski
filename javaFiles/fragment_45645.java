<image scaleImage="Clip" hAlign="Center" vAlign="Middle" isUsingCache="false" onErrorType="Blank">
    <reportElement positionType="Float" x="112" y="67" width="315" height="95" uuid="b90b1ec8-1483-4677-8db4-4556ecdad6b3">
        <printWhenExpression><![CDATA[new Boolean($F{GS1_128}!=null)]]></printWhenExpression>
    </reportElement>
    <imageExpression><![CDATA[my.package.MyBarcodeGenerator.getGS1_128($F{GS1_128})]]></imageExpression>
</image>