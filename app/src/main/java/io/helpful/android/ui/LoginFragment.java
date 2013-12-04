package io.helpful.android.ui;

import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.EditorInfo;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import io.helpful.android.R;

/**
 * Created by Feras Alnatsheh on 11/23/13.
 */
public class LoginFragment extends Fragment {

    public LoginFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_login, container, false);
        final EditText email = (EditText) rootView.findViewById(R.id.et_email);
        final EditText password = (EditText) rootView.findViewById(R.id.et_password);
        password.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                boolean handled = false;
                if (actionId == EditorInfo.IME_ACTION_DONE) {
                    login(email, password);
                    handled = true;
                }
                return handled;
            }
        });
        Button loginButton = (Button) rootView.findViewById(R.id.b_login);
        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                login(email, password);
            }
        });
        return rootView;
    }

    private void login(EditText email, EditText password){
        if(TextUtils.isEmpty(email.getText()) || TextUtils.isEmpty(password.getText())){
            Toast.makeText(getActivity(), R.string.invalid_email_or_password,Toast.LENGTH_SHORT).show();
            return;
        }
        // TODO login to Helpful
    }

}