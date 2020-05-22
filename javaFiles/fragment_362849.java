String storyIdStr = req.getParameter("story_id");
if (storyIdStr == null || storyIdStr.length() == 0) {
    // Deal with the error
}
Integer story_id = null;
try {
    story_id = Integer.valueOf(storyIdStr);
} catch (NumberFormatException nfe) {
    // Deal with the error
}