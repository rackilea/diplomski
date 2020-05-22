283   public long getSize() {
284        if (size >= 0) {
285            return size;
286        } else if (cachedContent != null) {
287            return cachedContent.length;
288        } else if (dfos.isInMemory()) {
289            return dfos.getData().length;
290        } else {
291            return dfos.getFile().length();
292        }
293    }