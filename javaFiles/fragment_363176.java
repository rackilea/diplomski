360     protected void addWrapper(ContextVersion context, String path,
361             Object wrapper, boolean jspWildCard, boolean resourceOnly) {
362 
363         synchronized (context) {
364             Wrapper newWrapper = new Wrapper();
365             newWrapper.object = wrapper;
366             newWrapper.jspWildCard = jspWildCard;
367             newWrapper.resourceOnly = resourceOnly;
368             if (path.endsWith("/*")) {
369                 // Wildcard wrapper
370                 newWrapper.name = path.substring(0, path.length() - 2);
371                 Wrapper[] oldWrappers = context.wildcardWrappers;
372                 Wrapper[] newWrappers =
373                     new Wrapper[oldWrappers.length + 1];
374                 if (insertMap(oldWrappers, newWrappers, newWrapper)) {
375                     context.wildcardWrappers = newWrappers;
376                     int slashCount = slashCount(newWrapper.name);
377                     if (slashCount > context.nesting) {
378                         context.nesting = slashCount;
379                     }
380                 }
381             } else if (path.startsWith("*.")) {
382                 // Extension wrapper
383                 newWrapper.name = path.substring(2);
384                 Wrapper[] oldWrappers = context.extensionWrappers;
385                 Wrapper[] newWrappers =
386                     new Wrapper[oldWrappers.length + 1];
387                 if (insertMap(oldWrappers, newWrappers, newWrapper)) {
388                     context.extensionWrappers = newWrappers;
389                 }
390             } else if (path.equals("/")) {
391                 // Default wrapper
392                 newWrapper.name = "";
393                 context.defaultWrapper = newWrapper;
394             } else {
395                 // Exact wrapper
396                 if (path.length() == 0) {
397                     // Special case for the Context Root mapping which is
398                     // treated as an exact match
399                     newWrapper.name = "/";
400                 } else {
401                     newWrapper.name = path;
402                 }
403                 Wrapper[] oldWrappers = context.exactWrappers;
404                 Wrapper[] newWrappers =
405                     new Wrapper[oldWrappers.length + 1];
406                 if (insertMap(oldWrappers, newWrappers, newWrapper)) {
407                     context.exactWrappers = newWrappers;
408                 }
409             }
410         }
411     }