package com.cis470.lakiel.contactmanagefragments;

import android.support.v4.app.FragmentActivity;
import android.os.Bundle;

public class MainActivity extends FragmentActivity
        implements ContactEntryFragment.OnSaveContactListener, ContactListFragment.OnListFragmentInteractionListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onArticleSelected(Contact contact) {
        // The user selected the headline of an article from the HeadlinesFragment
        // Do something here to display that article
        Bundle args = new Bundle();
        args.putString("name", contact.name);
        args.putString("email", contact.email);
        args.putString("number", contact.number);

        ContactListFragment contactlistFrag = (ContactListFragment) getSupportFragmentManager().findFragmentByTag("contactlist");
        contactlistFrag.setArguments(args);
        contactlistFrag.UpdateList();
    }

    public void onListFragmentInteraction(Contact contact) {
        // The user selected the headline of an article from the HeadlinesFragment
        // Do something here to display that article
        ContactDetailsFragment contactDetailFrag = (ContactDetailsFragment) getSupportFragmentManager().findFragmentByTag("contactdetail");
        Bundle args = new Bundle();
        args.putString("name", contact.name);
        args.putString("email", contact.email);
        args.putString("number", contact.number);

        contactDetailFrag.setArguments(args);
        contactDetailFrag.UpdateText();
    }
}
