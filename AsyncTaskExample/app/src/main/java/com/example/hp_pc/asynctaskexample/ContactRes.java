package com.example.hp_pc.asynctaskexample;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

/**
 * Created by hp-pc on 23-07-2017.
 */

public class ContactRes extends BaseAdapter {
   private List<ContactModel> contacts;
    LayoutInflater inflater;

  public ContactRes(Context context,List<ContactModel> contacts)
  {
      this.contacts=contacts;
      inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
  }
   @Override
    public int getCount() {
        return contacts.size();
    }

    @Override
    public Object getItem(int position) {
        return contacts.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        if (convertView == null) {
            convertView = inflater.inflate(R.layout.list_item, parent,false);

        }


        TextView textViewItemName = (TextView)
                convertView.findViewById(R.id.name);
        TextView textViewItemDescription = (TextView)
                convertView.findViewById(R.id.email);
        TextView textViewItemmobile = (TextView)
                convertView.findViewById(R.id.mobile);

        ContactModel con = contacts.get(position);

        textViewItemName.setText(con.getName());
        textViewItemDescription.setText(con.getEmail());
        textViewItemmobile.setText((CharSequence) con.getPhone());


        return convertView;
    }
}
