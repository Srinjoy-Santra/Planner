package com.example.newu.planner;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

public class CustomAdapter extends ArrayAdapter<String> {

    private Context context;
    private String resource[];

    public CustomAdapter(@NonNull Context context, String resource[]) {
        super(context, R.layout.activity_custom_adapter,resource);
        this.context=context;
        this.resource=resource;

    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        LayoutInflater layoutInflater= (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View customView = layoutInflater.inflate(R.layout.activity_custom_adapter, parent, false);

        TextView textView=(TextView)customView.findViewById(R.id.textView);
        //Toast.makeText(getContext(), "rs"+resource[position] , Toast.LENGTH_LONG).show();
        textView.setText(resource[position]);

        return customView;
    }


    //public View getView(){}
}
