Gson gson = new Gson();
AnalysisResult result = gson.fromJson(data, AnalysisResult.class);
boolean hasTag = false;
for (Tag t : result.tags) {
    if (Enum.hasTag(t.getTagName())) {
        hasTag = true;
        break;
    }
}

if (hasTag) {
    Intent in1 = new Intent(Analyze.this, Analyze2.class);
    startActivity(in1);
} else {
    for (final Caption caption : result.description.captions) {
        final Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                speakOut("Result:" + caption.text);
            }
        }, 100);
    }
}