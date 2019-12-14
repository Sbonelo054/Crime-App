package com.example.crimeapp.ui;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import com.example.crimeapp.R;

public class ProfileFragment extends Fragment {
    EditText textEmail;
    EditText textPassword;
    EditText textContact;

    public ProfileFragment() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.fragment_profile, container, false);
        textEmail = view.findViewById(R.id.username);
        textPassword = view.findViewById(R.id.password);
        textContact = view.findViewById(R.id.contact);
        Button buttonSave = view.findViewById(R.id.save);

        buttonSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                saveProfile();
            }
        });
        return view;
    }

    public void saveProfile() {
        final String email = textEmail.getText().toString().trim();
        final String password = textPassword.getText().toString().trim();
        final String contact = textContact.getText().toString().trim();
        if (email.trim().isEmpty() || password.trim().isEmpty() || contact.isEmpty()) {
            Toast.makeText(getContext(), "Please enter full details!", Toast.LENGTH_SHORT).show();
        }
    }
}