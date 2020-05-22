IWorkspaceDescription description = ResourcesPlugin.getWorkspace().getDescription();

description.setFileStateLongevity(...);
description.setMaxFileStates(...);
description.setMaxFileStateSize(...);
description.setApplyFileStatePolicy(...);

ResourcesPlugin.getWorkspace().setDescription(description);