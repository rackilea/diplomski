stubVoid(mock)
  .toAnswer(new Answer() {
                public Object answer(InvocationOnMOck invocation) {
                    Visitor v = (Visitor) invocation.getArguments()[0];
                    v.visitMock(invocation.getMock());

                    return null;
                }
            })
   .on().accept(any());