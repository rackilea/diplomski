// key=value
parsedDataMap = parsedDataMap.replaceAll("([,\\{\\[]{1})([^,\\{\\[=]+)=([^,\\{\\}\\[\\]]+)([,\\}\\]]{1})",
    "$1\"$2\":\"$3\"$4");
// key=value 2nd time because some of the values were missed 1st time because of intersection of ranges
parsedDataMap = parsedDataMap.replaceAll("([,\\{\\[]{1})([^\",\\{\\[=]+)=([^\",\\{\\}\\[\\]]+)([,\\}\\]]{1})",
    "$1\"$2\":\"$3\"$4");
// key=[ or key={
parsedDataMap = parsedDataMap.replaceAll("([,\\{\\[]{1})([^,\\{\\[=]+)=([\\[\\{])", "$1\"$2\":$3");
// key=[ or key={ 2nd time because some of the values were missed 1st time because of intersection of ranges
parsedDataMap = parsedDataMap.replaceAll("([,\\{\\[]{1})([^\",\\{\\[=]+)=([\\[\\{])", "$1\"$2\":$3");