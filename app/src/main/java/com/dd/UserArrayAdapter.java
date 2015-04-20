package com.dd;

import com.dd.data.User;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

/**
 * Created by user_sca on 20.04.2015.
 */
public class UserArrayAdapter extends android.widget.ArrayAdapter<com.dd.data.User> {

    private Context mContext;

    public UserArrayAdapter(Context context, int resource,
            List<User> objects) {
        super(context, resource, objects);
        mContext = context;
    }

    @Override
    public int getItemViewType(int position) {
        //for example we can display
        return position%2;
        //return super.getItemViewType(position);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        int itemViewType = getItemViewType(position);
        //sure we can use viewholder here, but it is simple approach
        //we can even inject any viewholder(as singleton) as a dependency
        return viewFactory(mContext, itemViewType, getItem(position));


    }
    private View viewFactory(Context context, int itemViewType, User item) {
        LayoutInflater systemService = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        View inflate = systemService.inflate(itemViewType==0?R.layout.first_user_layout:R.layout.second_user_layout, null);

        TextView textView = (TextView)inflate.findViewById(R.id.name);

        TextView email = (TextView)inflate.findViewById(R.id.email);

        textView.setText(item.getName());

        email.setText(item.getName());

        return inflate;
    }
}
