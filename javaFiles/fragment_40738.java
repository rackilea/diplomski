package com.skype.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.text.SpannableString;
import android.text.style.UnderlineSpan;
import android.text.util.Linkify;
import android.util.AttributeSet;
import android.util.Log;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnFocusChangeListener;
import android.view.View.OnHoverListener;
import android.view.View.OnLongClickListener;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.TextView.OnEditorActionListener;
import android.widget.ViewSwitcher;

import com.skype.ref.R;
import com.skype.ref.RemoteKeys;

public class TextBoxOnDemand extends ViewSwitcher implements OnClickListener, OnLongClickListener, OnFocusChangeListener, OnHoverListener,
        OnEditorActionListener
{
    public static final String  LOGTAG          = "TextBoxOnDemand";

    private View                btmGuard;
    private ImageButton         cancel, accept;
    private EditText            editor;
    private RelativeLayout      editorLayout;
    private TextView            face;
    private String              hint            = new String();
    private boolean             inEditMode      = false;                    //normally this is in textview mode
    private boolean             inputReady      = false;
    private String              ourData         = new String();
    private String              prefillData     = new String();
    private String              tag             = new String();         //usually tag is empty.
    private View                topGuard;
    private int                 autoLinkMask;// = Linkify.EMAIL_ADDRESSES;  //Linkify.ALL;
    private ColorStateList      textColor, hintColor = null;

    public TextBoxOnDemand(Context context)
    {
        super(context);
        build(context);
        setEditable(false); //init
    }

    public TextBoxOnDemand(Context context, AttributeSet attrs)
    {
        super(context, attrs);
        build(context);
        init(context, attrs);
        setEditable(false); //init
    }

    public String getPrefillData()
    {
        return prefillData;
    }

    public String getTag()
    {
        return tag;
    }

    public String getText()
    {
        Log.d(LOGTAG, "getText() returning '" + ourData + "'");
        return ourData;
    }

    public boolean hasPrefillData()
    {
        return prefillData.isEmpty();
    }

    public boolean isEditable()
    {
        Log.d(LOGTAG, "isEditable() returning " + inEditMode);
        return inEditMode;
    }

    @Override
    public void onClick(View v)
    {
        Log.d(LOGTAG, "onClick(" + v + ")");
        if (inEditMode)
        {
            if (v.equals(accept))
            {
                if (editor.getEditableText().length() == 0 || editor.getEditableText().length() > 5)
                    ourData = editor.getEditableText().toString();

                setEditable(false);
            } else if (v.equals(cancel))
            {
                setEditable(false);
            }
        }
    }

    @Override
    public boolean onEditorAction(TextView v, int actionId, KeyEvent event)
    {
        //      Log.d(LOGTAG, "onEditorAction(" + v + ", " + actionId + ", " + event + ") fired!");
        Log.d(LOGTAG, "onEditorAction() fired, inputReady = " + inputReady);
        if (editor.getEditableText().length() > 0 && editor.getEditableText().length() < (prefillData.length() + 2)) return true;   //the user needs to enter something


        if (inputReady && (event.getKeyCode() == RemoteKeys.ENTER.keycode() || event.getKeyCode() == KeyEvent.KEYCODE_ENTER))   //always is
        {
            if (editor.getEditableText().length() > prefillData.length() || editor.getEditableText().length() == 0)
                ourData = editor.getEditableText().toString();

            setEditable(false);
            return false;
        }

        if ((editor.getEditableText().toString().compareToIgnoreCase(ourData) == 0 || editor.getEditableText().toString()
                .compareToIgnoreCase(prefillData) == 0)
                && !inputReady) //means we didn't just keep on holding enter
            return true;
        else
            inputReady = true;

        return true;
    }

    @Override
    public void onFocusChange(View v, boolean hasFocus)
    {
        Log.d(LOGTAG, "onFocusChange(" + v + ", " + hasFocus + ")\tinEditMode = " + inEditMode);
        if (inEditMode)
        {
            if (hasFocus && (v.equals(topGuard) || v.equals(btmGuard)))
            {
                setEditable(false);
                requestFocus();
            }

            if (hasFocus && (v.equals(editor) || v.equals(accept) || v.equals(cancel)))
            {
                //do nothing, you should be able to browse freely here
                if (ourData.isEmpty() && editor.getEditableText().length() < prefillData.length())
                {
                    Log.d(LOGTAG, "adding prefill, before = " + editor.getEditableText());
                    editor.setText("");
                    editor.append(prefillData);
                    Log.d(LOGTAG, "now is = " + editor.getEditableText());
                }
            }
        } else
        {
            String text = (ourData.isEmpty()) ? hint : ourData;
            ColorStateList color;
            if (hintColor != null && ourData.isEmpty())
                color = hintColor;
            else
                color = textColor;
            face.setTextColor(color);
            if (hasFocus)
            {
                SpannableString ss = new SpannableString(text);
                ss.setSpan(new UnderlineSpan(), 0, text.length(), 0);
                face.setText(ss);
            } else
                face.setText(text);
        }
    }

    @Override
    public boolean onHover(View v, MotionEvent event)
    {
        //      Log.d(LOGTAG, "onHover()");
        String text = (ourData.isEmpty()) ? hint : ourData;
        ColorStateList color;
        if (hintColor != null && ourData.isEmpty())
            color = hintColor;
        else
            color = textColor;
        face.setTextColor(color);
        switch (event.getAction())
        {
            case MotionEvent.ACTION_HOVER_ENTER:
                SpannableString ss = new SpannableString(text);
                ss.setSpan(new UnderlineSpan(), 0, text.length(), 0);
                face.setText(ss);
                break;
            case MotionEvent.ACTION_HOVER_EXIT:
                face.setText(text);
                break;
        }
        return true;
    }

    @Override
    public boolean onLongClick(View v)
    {
        Log.d(LOGTAG, "onLongClick()\tinEditMode = " + inEditMode);
        if (!inEditMode) //implies that getDisplayedChild() == 0, meaning the textview
        {
            setEditable(true);
            return true;
        } else
            return false;
    }

    public void setEditable(boolean value)
    {
        Log.d(LOGTAG, "setEditable(" + value + ")");
        inEditMode = value;
        if (inEditMode)
        {
            //display the editorLayout
            face.setOnLongClickListener(null);
            face.setOnHoverListener(null);
            face.setOnFocusChangeListener(null);    //because of GC.
            face.setOnClickListener(null);
            face.setVisibility(View.GONE);
            setDisplayedChild(1);
            editorLayout.setVisibility(View.VISIBLE);
            editor.setOnFocusChangeListener(this);
            editor.setOnEditorActionListener(this);
            cancel.setOnClickListener(this);
            accept.setOnClickListener(this);
            accept.setOnFocusChangeListener(this);
            cancel.setOnFocusChangeListener(this);
        } else
        {
            editor.setOnFocusChangeListener(null);
            editor.setOnEditorActionListener(null);
            cancel.setOnClickListener(null);
            accept.setOnClickListener(null);
            accept.setOnFocusChangeListener(null);
            cancel.setOnFocusChangeListener(null);
            editorLayout.setVisibility(View.GONE);
            setDisplayedChild(0);
            face.setVisibility(View.VISIBLE);
            face.setOnLongClickListener(this);
            face.setOnHoverListener(this);
            face.setOnFocusChangeListener(this);
            face.setOnClickListener(this);
            face.setFocusable(true);
            face.setFocusableInTouchMode(true);
        }
        updateViews();
    }

    @Override
    public void setNextFocusDownId(int nextFocusDownId)
    {
        super.setNextFocusDownId(nextFocusDownId);
        face.setNextFocusDownId(nextFocusDownId);
        //      editor.setNextFocusDownId(nextFocusDownId);
        accept.setNextFocusDownId(nextFocusDownId);
        cancel.setNextFocusDownId(nextFocusDownId);
    }

    @Override
    public void setNextFocusForwardId(int nextFocusForwardId)
    {
        super.setNextFocusForwardId(nextFocusForwardId);
        face.setNextFocusForwardId(nextFocusForwardId);
        editor.setNextFocusForwardId(nextFocusForwardId);
    }

    @Override
    public void setNextFocusLeftId(int nextFocusLeftId)
    {
        super.setNextFocusLeftId(nextFocusLeftId);
        face.setNextFocusLeftId(nextFocusLeftId);
        editor.setNextFocusLeftId(nextFocusLeftId);
    }

    @Override
    public void setNextFocusRightId(int nextFocusRightId)
    {
        super.setNextFocusRightId(nextFocusRightId);
        face.setNextFocusRightId(nextFocusRightId);
        cancel.setNextFocusRightId(nextFocusRightId);
    }

    @Override
    public void setNextFocusUpId(int nextFocusUpId)
    {
        super.setNextFocusUpId(nextFocusUpId);
        face.setNextFocusUpId(nextFocusUpId);
        //      editor.setNextFocusUpId(nextFocusUpId);
        accept.setNextFocusUpId(nextFocusUpId);
        cancel.setNextFocusUpId(nextFocusUpId);
    }

    public void setPrefillData(String prefillData)
    {
        this.prefillData = new String(prefillData);
    }

    public String setTag()
    {
        return tag;
    }

    public void setText(String text)
    {
        Log.d(LOGTAG, "setText(" + text + ")");
        ourData = text;
        updateViews();
    }

    private void build(Context context)
    {
        Log.d(LOGTAG, "build()");
        addView(View.inflate(context, R.layout.textboxondemand, null));
        setFocusable(true);
        setFocusableInTouchMode(true);
        setDescendantFocusability(FOCUS_AFTER_DESCENDANTS);
        setOnFocusChangeListener(this);
        setOnLongClickListener(this);

        face = (TextView) findViewById(R.id.TBOD_textview);
        editorLayout = (RelativeLayout) findViewById(R.id.TBOD_layout);
        editor = (EditText) findViewById(R.id.TBOD_edittext);
        accept = (ImageButton) findViewById(R.id.TBOD_accept);
        cancel = (ImageButton) findViewById(R.id.TBOD_cancel);
        topGuard = (View) findViewById(R.id.TBOD_top);
        btmGuard = (View) findViewById(R.id.TBOD_bottom);

        face.setFocusable(true);
        face.setFocusableInTouchMode(true);

        face.setOnLongClickListener(this);
        face.setOnHoverListener(this);
        face.setOnFocusChangeListener(this);
        face.setOnClickListener(this);

        editor.setOnFocusChangeListener(this);
        editor.setOnEditorActionListener(this);
        editor.setHint(hint);
        editor.setFocusable(true);
        editor.setFocusableInTouchMode(true);

        accept.setOnClickListener(this);
        accept.setOnFocusChangeListener(this);
        accept.setFocusable(true);
        cancel.setFocusable(true);
        cancel.setOnFocusChangeListener(this);
        cancel.setOnClickListener(this);

        topGuard.setFocusable(true);
        topGuard.setOnFocusChangeListener(this);
        btmGuard.setFocusable(true);
        btmGuard.setOnFocusChangeListener(this);

        editor.setNextFocusRightId(R.id.TBOD_accept);
        editor.setNextFocusDownId(R.id.TBOD_bottom);
        editor.setNextFocusUpId(R.id.TBOD_top);

        accept.setNextFocusLeftId(R.id.TBOD_edittext);
        accept.setNextFocusRightId(R.id.TBOD_cancel);
        cancel.setNextFocusLeftId(R.id.TBOD_accept);
    }

    private void init(Context context, AttributeSet attrs)
    {
        TypedArray a = context.obtainStyledAttributes(attrs, R.styleable.TextBoxOnDemand);
        //Use a
        Log.d(LOGTAG, "init()");
        if (a == null) Log.d(LOGTAG, "Did you include 'xmlns:app=\"http://schemas.android.com/apk/res-auto\"' in your root layout?");

        final int N = a.getIndexCount();
        for (int i = 0; i < N; ++i)
        {
            int attr = a.getIndex(i);
            switch (attr)
            {
                case R.styleable.TextBoxOnDemand_android_hint:
                    hint = new String(a.getString(attr));
                    editor.setHint(a.getString(attr));
                    break;
                case R.styleable.TextBoxOnDemand_android_text:
                    ourData = new String(a.getString(attr));
                    break;
                case R.styleable.TextBoxOnDemand_android_inputType:
                    int inputType = a.getInt(attr, -1);
                    if (inputType != -1) editor.setInputType(inputType);
                    break;
                case R.styleable.TextBoxOnDemand_android_textColor:
                    textColor = a.getColorStateList(attr);
                    face.setTextColor(textColor);
                    break;
                case R.styleable.TextBoxOnDemand_android_linksClickable:
                    face.setLinksClickable(a.getBoolean(attr, true));
                    break;
                case R.styleable.TextBoxOnDemand_android_textColorHint:
                    hintColor = a.getColorStateList(attr);
                    break;
                case R.styleable.TextBoxOnDemand_android_autoLink:
                    autoLinkMask = a.getInt(attr, 0);
                    face.setAutoLinkMask(autoLinkMask);
                    break;

                default:
                    Log.d(LOGTAG, "Skipping attribute " + attr);
            }
        }

        //Don't forget this
        a.recycle();
    }

    private void updateViews()
    {
        Log.d(LOGTAG, "updateViews()");
        //      if (getDisplayedChild() == 0)   //first child - textview
        if (!inEditMode)    //first child - textview
        {
            if (ourData.isEmpty())
            {
                if (hintColor != null) face.setTextColor(hintColor);
                face.setText(hint);
            } else
            {
                face.setTextColor(textColor);
                face.setText(ourData);
            }
            face.setFocusable(true);
            face.setFocusableInTouchMode(true);
            face.setAutoLinkMask(autoLinkMask);
        } else
        {   //second child - edittext
            editor.setFocusable(true);
            editor.setFocusableInTouchMode(true);
            if (ourData.startsWith(prefillData) || ourData.length() >= prefillData.length())
                editor.setText("");
            else
                editor.setText(prefillData);

            editor.append(ourData);
            inputReady = false;

            editor.requestFocus();
        }
    }

    public void setAutoLinkMask(LinkifyEnum linkifyEnumConstant)
    {
        switch (linkifyEnumConstant)
        {
            case ALL:
                autoLinkMask = Linkify.ALL;
                break;
            case EMAIL_ADDRESSES:
                autoLinkMask = Linkify.EMAIL_ADDRESSES;
                break;
            case MAP_ADDRESSES:
                autoLinkMask = Linkify.MAP_ADDRESSES;
                break;
            case PHONE_NUMBERS:
                autoLinkMask = Linkify.PHONE_NUMBERS;
                break;
            case WEB_URLS:
                autoLinkMask = Linkify.WEB_URLS;
                break;

            case NONE:
            default:
                autoLinkMask = 0;
                break;
        }
        //set it now
        face.setAutoLinkMask(autoLinkMask);
    }

    public enum LinkifyEnum
    {
        ALL, EMAIL_ADDRESSES, MAP_ADDRESSES, PHONE_NUMBERS, WEB_URLS, NONE
    };

}