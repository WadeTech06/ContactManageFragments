package com.cis470.lakiel.contactmanagefragments.dummy;

import com.cis470.lakiel.contactmanagefragments.Contact;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Helper class for providing sample content for user interfaces created by
 * Android template wizards.
 * <p>
 * TODO: Replace all uses of this class before publishing your app.
 */
public class ContactContent {

    /**
     * An array of sample (dummy) items.
     */
    public static final List<Contact> ITEMS = new ArrayList<Contact>();


    public static void addItem(Contact contact) {
        ITEMS.add(contact);
    }

    private static Contact createContact(String name,String email,String number) {
        return new Contact( name,email,number);
    }

    private static String makeDetails(int position) {
        StringBuilder builder = new StringBuilder();
        builder.append("Details about Item: ").append(position);
        for (int i = 0; i < position; i++) {
            builder.append("\nMore details information here.");
        }
        return builder.toString();
    }


}
