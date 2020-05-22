for (int k = 0; k < CourseNodeList.getLength(); k++) {
    if (CourseNodeList.item(k).getNodeType() == Node.ELEMENT_NODE && CourseNodeList != null) {
        classGrades.put(CourseNodeList.item(k).getNodeName(),
        CourseNodeList.item(k).getNodeValue());
    }
}