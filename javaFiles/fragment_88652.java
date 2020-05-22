rule "only do action if attribute is not null"
when
  Fact($att: attribute != null)             /* A */
  Fact($att: attribute, eval($att != null)) /* B */
  Fact($att: attribute, attribute != null)  /* C */
  Fact($att: attribute, $att != null)       /* D */
then
  rulesLogger.debug("Rule fires = " + $attribute);
end