Session session = resourceResolver.adaptTo(Session.class);
Node formRootNode = JcrUtil.createPath("/content/usergenerated/content/formPage", true, "sling:Folder", "cq:Page", session, false);
Node formNode = formRootNode.addNode("jcr:content", "cq:PageContent");
formNode.setProperty("name", "John");
session.save();
formNode.setProperty("cq:distribute", true);
formNode.setProperty("cq:lastModified", Calendar.getInstance());
formNode.setProperty("cq:lastModifiedBy", session.getUserID());
session.save();