MessageContext msgCtxt = wsCtxt.getMessageContext();
Subject subj = SubjectAccessor.getRequesterSubject(msgCtxt);
Set set = subj.getPrincipals();
Iterator i = set.iterator();
while (i.hasNext()) {
   Principal p = (Principal) i.next();
   username = p.getName();
}