task addImportStatement << {
    ant.replace(dir: 'yourSrcDirHere', token: 'existing value', value:'<![CDATA[existing value
    new import statement here]]>')
}

task regExpressionSub << {
    ant.replaceRegExp(...)
}
regExpressionSub.dependsOn addImportStatement