package com.example.minh.contact.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.minh.contact.R;
import com.example.minh.contact.model.Contact;

import java.util.List;

public class ContactAdapter extends ArrayAdapter<Contact> {


    private Context context;
    private int resource;
    private List<Contact> arrContact;


    public ContactAdapter(@NonNull Context context, int resource, @NonNull List<Contact> objects) {
        super(context, resource, objects);
        this.context = context;
        this.resource = resource;
        this.arrContact = objects;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        ViewHolder viewHolder;
        if (convertView == null){
            viewHolder = new ViewHolder();
            convertView = LayoutInflater.from(context).inflate(R.layout.item_contact_listview,parent,false);
            viewHolder.imgAvatar = (ImageView) convertView.findViewById(R.id.img_avatar);
            viewHolder.tvName = (TextView) convertView.findViewById(R.id.tv_name);
            viewHolder.tvNumber = (TextView) convertView.findViewById(R.id.tv_number);

            convertView.setTag(viewHolder);


        }else  {
            viewHolder = (ViewHolder) convertView.getTag();
        }

        Contact contact = arrContact.get(position);

        viewHolder.tvName.setText(contact.getmName());
        viewHolder.tvNumber.setText(contact.getmNumber());


        if (contact.isMale()){
            viewHolder.imgAvatar.setBackgroundResource(R.drawable.ic_male);
        }else  {
            viewHolder.imgAvatar.setBackgroundResource(R.drawable.ic_female);
        }


        return convertView;
    }

    public class ViewHolder{
        ImageView imgAvatar;
        TextView tvName;
        TextView tvNumber;

    }
}
