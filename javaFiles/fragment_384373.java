privileges = new Privilege[] {
                                    accessControlManager
                                            .privilegeFromName(Privilege.JCR_ADD_CHILD_NODES),
                                    accessControlManager
                                            .privilegeFromName(Privilege.JCR_READ),
                                    accessControlManager
                                            .privilegeFromName(Privilege.JCR_WRITE),
                                    accessControlManager
                                            .privilegeFromName(Privilege.JCR_NODE_TYPE_MANAGEMENT) };