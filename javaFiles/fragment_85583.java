File file = request.getServletContext().getRealPath("/pdfsdir/" + filename);
        if (!file.canRead()) {
            // Log this with filename...
            response.sendError(HttpServletResponse.SC_NOT_FOUND);
            return;
        }
        long fileLength = file.length();
        if (fileLength > Integer.MAX_VALUE) { // Too large
            // Log this with filename...
            response.sendError(HttpServletResponse.SC_CONFLICT);
            return;
        }
        int length = (int) fileLength;