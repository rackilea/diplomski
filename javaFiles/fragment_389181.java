Map<String, Boolean> communicationWays = new HashMap<String, Boolean>();
request.setAttribute("communicationWays", communicationWays);

for (String communicationWay : request.getParameterValues("communicationWay")) {
    communicationWays.put(communicationWay, true);
}