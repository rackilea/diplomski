try {

        doc.insertString(0, "First Line aligned left\n", left);
        doc.insertString(doc.getLength(), "Second line Aligned right\n", right);

    } catch (Exception e) {
        e.printStackTrace();
    }