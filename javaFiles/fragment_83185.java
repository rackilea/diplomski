class StyledCompletionProposal 
    implements ICompletionProposal, ICompletionProposalExtension6 
{

  ...

  @Override
  public StyledString getStyledDisplayString() {
    return new StyledString("test").append(" [10%]", Styler.QUALIFIER_STYLER);
  }

}