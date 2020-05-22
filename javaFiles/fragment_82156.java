@Override
public String toString() {
    final StringBuilder sb = new StringBuilder("{");
    sb.append("\"httpErrorCode\":").append(httpErrorCode);
    sb.append(", \"data\":").append(data.toString());
    sb.append(", \"errorMessage\":").append(errorMessage);
    sb.append('}');
    return sb.toString();
}