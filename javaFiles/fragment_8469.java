AuthenticationUtil.runAs(new RunAsWork<String>() {

                @Override
                public String doWork() throws Exception {

                    NodeRef nodeRef = new NodeRef("workspace://SpacesStore/f1a5e908-80cb-4c6e-b919-cc80fe53b835");
                    if(contentService != null) {
                        ContentWriter writer = contentService.getWriter(nodeRef, ContentModel.PROP_CONTENT, true);
                        if(writer != null) {
                            writer.putContent(new ByteArrayInputStream("updated content".getBytes()));
                        } 
                    } 
                    return null;
                }

            }, AuthenticationUtil.getSystemUserName());