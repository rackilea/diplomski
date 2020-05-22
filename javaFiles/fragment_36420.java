cacheManager(CacheManager) { ... }

pdfDocumentCache(MethodInvokingFactoryBean) { bean ->
  bean.dependsOn = ['cacheManager']
  targetClass = CacheManager
  targetMethod = 'getROCache'
  arguments = ['somecache']
}

pdfProcessor(PDFProcessor) {
  documentCache = pdfDocumentCache
}