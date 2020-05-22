for (Map.Entry<String, String> entry : scripts.entrySet()) {
    if (entry.getValue().equals(name)) {
        return entry.getKey();
    }
}

return null;