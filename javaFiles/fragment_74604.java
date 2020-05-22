for (CorefChain cc : document.get(CorefCoreAnnotations.CorefChainAnnotation.class).values()) {
    CorefChain.CorefMention representativeMention = cc.getRepresentativeMention();
    for (CorefChain.CorefMention cm : cc.getMentionsInTextualOrder()) {
      String position = "sentence num: "+cm.sentNum+" position: "+cm.startIndex;
      System.out.println(cm.mentionSpan + "\t" + position + "\t" + representativeMention.mentionSpan);
}