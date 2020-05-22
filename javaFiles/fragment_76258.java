StringBuffer sb = new StringBuffer();

for (String property : textService.getAnswer()) {
    sb.append(property);
    sb.append('\n');
}