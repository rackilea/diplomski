for (final String image : new String[] { "images/registration/student.gif", "images/registration/student_highlight.gif",
                "images/registration/student_selected.gif" }) {

            String image2 = image;
            final boolean hasUndersore = image2.indexOf("_") > 0;
            if (hasUndersore) {
                image2 = image2.replaceAll("_highlight(\\.[^\\.]+)$", "_selected$1");
            } else {
                final String[] words = image2.split("\\.");
                image2 = words[0].concat("_selected.") + words[1];
            }
            System.out.println(image2);
        }