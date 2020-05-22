function additionalParameters(data, type) {
    if (type === "read") {
        return "id=" + data + "&param=" + JSON.stringify(data);
    }
    return "param= "+ JSON.stringify(data);
}