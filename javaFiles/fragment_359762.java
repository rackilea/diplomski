package net.njensen.stackoverflow;

import android.content.res.Resources;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.DecelerateInterpolator;
import android.widget.Button;
import android.widget.EditText;


/**
 * Created by Nicklas Jensen on 03/05/15.
 */
public class MainActivityFragment extends Fragment {

    private EditText mEtUsername;
    private EditText mEtPassword;
    private EditText mEtRepeatPassword;
    private Button mBtnRegister;
    private View mUsernamePasswordContainer;

    private final View.OnClickListener mDisplayRepeatPasswordListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            if (!isRepeatPasswordVisible()) {
                showRepeatPasswordAnimated();
            }
        }
    };

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_main, container, false);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        mEtUsername = (EditText) view.findViewById(R.id.et_username);
        mEtPassword = (EditText) view.findViewById(R.id.et_password);
        mEtRepeatPassword = (EditText) view.findViewById(R.id.et_repeat_password);
        mBtnRegister = (Button) view.findViewById(R.id.btn_register);
        mUsernamePasswordContainer = view.findViewById(R.id.username_password_container);

        mBtnRegister.setOnClickListener(mDisplayRepeatPasswordListener);
    }

    private boolean isRepeatPasswordVisible() {
        return mEtRepeatPassword.getVisibility() == View.VISIBLE;
    }

    private int getRepeatPasswordAnimationDuration() {
        return getResources().getInteger(android.R.integer.config_mediumAnimTime);
    }

    private void showRepeatPasswordAnimated() {
        RevealInPlaceAnimation animation = new RevealInPlaceAnimation(mUsernamePasswordContainer, mEtRepeatPassword);
        animation.setInterpolator(new DecelerateInterpolator());
        animation.setDuration(getRepeatPasswordAnimationDuration());
        animation.start();
    }
}