switch (Binder.getCallingUid()) {
                case android.os.Process.SHELL_UID:
                case android.os.Process.ROOT_UID:
                case android.os.Process.SYSTEM_UID:
                    break;
                default:
                    throw new SecurityException(
                            "Reverse mode only supported from shell or system");
            }