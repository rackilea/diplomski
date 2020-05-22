private void spannableOperationOnHastag() throws Exception{
        mPostMessage = edPostMessage.getText().toString()+" "; // extra space for spannable operations
        List<Integer> listStartPos = new ArrayList<>();
        List<Integer> listEndtPos = new ArrayList<>();

        if (mPostMessage.contains("#")){
            for (int i = 0; i < mPostMessage.length(); i++) {
                if (mPostMessage.charAt(i) == '#') {
                    listStartPos.add(i);
                    Log.d(TAG, "startIndex of # = " + i);
                }
            }
            for (int i = 0; i < listStartPos.size(); i++) {
                int endIndex = mPostMessage.indexOf(' ', listStartPos.get(i));
                listEndtPos.add(endIndex);
                Log.d(TAG, "endIndex of # " + (endIndex));
            }
            SpannableString spanned = SpannableString.valueOf(mPostMessage);
            for (int i = 0; i < listStartPos.size(); i++) {
                spanned = new SpannableString(spanned);
                spanned.setSpan(new ForegroundColorSpan(getResources().getColor(R.color.blue)), listStartPos.get(i), listEndtPos.get(i), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
                Log.d(TAG, "substring " + mPostMessage.substring(listStartPos.get(i), listEndtPos.get(i) + 1));
            }
            mPostMessage.trim(); // removing extra space.
            edPostMessage.setText(null);
            edPostMessage.setText(spanned);

        }
    }