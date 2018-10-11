package com.cis470.lakiel.contactmanagefragments;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class ContactEntryFragment extends Fragment {
    OnSaveContactListener mCallback;

    public interface OnSaveContactListener {
        void onArticleSelected(Contact contact);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        final View fragmentView = inflater.inflate(R.layout.fragment_contact_entry,
                container, false);

        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_contact_entry, container, false);
    }

    public void onStart() {
        super.onStart();
        //---Button view---
        Button btnGetText = getActivity().findViewById(R.id.saveButton);
        btnGetText.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                EditText nameTextView = getActivity().findViewById(R.id.nameText);
                EditText emailTextView = getActivity().findViewById(R.id.emailText);
                EditText pnumberTextView = getActivity().findViewById(R.id.pnumberText);

                if (TextUtils.isEmpty(nameTextView.getText())) {
                    Toast.makeText(getActivity(), "Name is Required.",
                            Toast.LENGTH_SHORT)
                            .show();

                    nameTextView.setError("Name is required!");

                } else {
                    Contact contact = new Contact(nameTextView.getText().toString()
                            , emailTextView.getText().toString(), pnumberTextView.getText().toString());
                    mCallback.onArticleSelected(contact);
                    nameTextView.setText("");
                    emailTextView.setText("");
                    pnumberTextView.setText("");
                    Toast.makeText(getActivity(), "Added",
                            Toast.LENGTH_SHORT)
                            .show();
                }
            }
        });
    }


    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof ContactEntryFragment.OnSaveContactListener) {
            mCallback = (ContactEntryFragment.OnSaveContactListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnListFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mCallback = null;
    }

}
