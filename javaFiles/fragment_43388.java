// Optional: certify
        // can be done only if version is at least 1.5 and if not already set
        // doing this on a PDF/A-1b file fails validation by Adobe preflight (PDFBOX-3821)
        // PDF/A-1b requires PDF version 1.4 max, so don't increase the version on such files.
        if (doc.getVersion() >= 1.5f && accessPermissions == 0)
        {
            SigUtils.setMDPPermission(doc, signature, 2);
        }