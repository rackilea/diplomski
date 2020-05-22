for (IChange change : (List<IChange>) changeSet.changes()) {
                if (change.kind() == IChange.MODIFY) {
                    return "MODIFIED";
                }
                if (change.kind() == IChange.ADD) {
                    return "ADDED";
                }
            }