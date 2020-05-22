private void init(Context context, AttributeSet attrs, int defStyleAttr) {
    TypedArray a = context.getTheme().obtainStyledAttributes(attrs, R.styleable.ButtonWithCaption, 0, 0);

    try {
        mIconSrc = a.getResourceId(R.styleable.ButtonWithCaption_iconSrc, 0);
        mCaptionText = a.getString(R.styleable.ButtonWithCaption_captionText);
        mShowIcon = a.getBoolean(R.styleable.ButtonWithCaption_showIcon, mIconSrc != 0);
        mShowText = a.getBoolean(R.styleable.ButtonWithCaption_showText, !mCaptionText.isEmpty());

        View v = View.inflate(context, R.layout.ButtonWithCaption, this);   // add this line
        mImageView = (ImageView) findViewById(R.id.bwc_icon);
        mTextView = (TextView) findViewById(R.id.bwc_caption);

        mImageView.setImageResource(mIconSrc);
        mTextView.setText(mCaptionText);
    } finally {
        a.recycle();
    }
}