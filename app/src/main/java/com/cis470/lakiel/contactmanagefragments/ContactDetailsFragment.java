package com.cis470.lakiel.contactmanagefragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;



public class ContactDetailsFragment extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_contact_details, container, false);
    }

    public void UpdateText()
    {
        if(getArguments() != null)
        {
            Bundle bundle = getArguments();
            String name = bundle.getString("name");
            String email = bundle.getString("email");
            String number = bundle.getString("number");

            TextView nameView = (TextView) getActivity().findViewById(R.id.nameDetailTextView);
            TextView emaiView = (TextView) getActivity().findViewById(R.id.emailDetailTextView);
            TextView numberView = (TextView) getActivity().findViewById(R.id.numberDetailTextView);

            nameView.setText("Name: " + name);
            emaiView.setText("Email: " + email);
            numberView.setText("Number: " + number);
        }
    }

}
