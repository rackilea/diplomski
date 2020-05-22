public class MatchesPropertyFunctionFactory implements PropertyFunctionFactory {
    @Override
    public PropertyFunction create(final String uri)
    {   
        return new PFuncSimpleAndList()
        {
            @Override
            public QueryIterator execEvaluated(final Binding parent, final Node subject, final Node predicate, final PropFuncArg object, final ExecutionContext execCxt) 
            {   
                /* TODO insert your stuff to perform testing. Note that you'll need
                 * to validate that things like subject/predicate/etc are bound
                 */
                final boolean nonzeroPercentMatch = true; // XXX example-specific kludge
                final Double percent = 0.75; // XXX example-specific kludge
                if( nonzeroPercentMatch ) {
                    final Binding binding = 
                                BindingFactory.binding(parent, 
                                                       Var.alloc(object.getArg(1)),
                                                       NodeFactory.createLiteral(percent.toString(), XSDDatatype.XSDdecimal));
                    return QueryIterSingleton.create(binding, execCtx);
                }
                else {
                    return QueryIterNullIterator.create(execCtx);
                }
            }
        };
    }

}