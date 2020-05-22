protected String getRestrictedOrClosedTerm() 
        {
            StringBuilder sb = new StringBuilder();
            if (isRestricted == null || "false".equals(isRestricted)) {
                sb.append("-status:restricted  -status:closed\n");
            }
            if (isRestricted.isEmpty()) {
                sb.append("empty\n");
            }
            if ("true".equals(isRestricted)) {
                sb.append("+status:restricted\n");
            }
            if (isClosed == null || "false".equals(isClosed)) {
                sb.append("-status:closed\n");
            }
            if (isClosed.isEmpty()) {
                sb.append("empty\n");
            }
            if ("true".equals(isClosed)) {
                sb.append("+status:closed\n");
            }

            return sb.toString();
        }