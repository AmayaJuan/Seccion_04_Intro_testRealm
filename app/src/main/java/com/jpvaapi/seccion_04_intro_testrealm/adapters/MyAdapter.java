package com.jpvaapi.seccion_04_intro_testrealm.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.jpvaapi.seccion_04_intro_testrealm.R;
import com.jpvaapi.seccion_04_intro_testrealm.models.Dog;
import com.jpvaapi.seccion_04_intro_testrealm.models.Person;

import java.util.List;

/**
 * Created by Juan P 15/02/20
 */
public class MyAdapter extends BaseAdapter {

    private List<Person> list;
    private int layout;
    private Context context;

    public MyAdapter(List<Person> list, int layout, Context context) {
        this.list = list;
        this.layout = layout;
        this.context = context;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int id) {
        return id;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        ViewHolder vh:
        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(layout, null);
            vh = new ViewHolder();
            vh.id = convertView.findViewById(R.id.textVIewId);
            vh.name = convertView.findViewById(R.id.textViewName);
            vh.dogs = convertView.findViewById(R.id.textViewDogs);
            convertView.setTag(vh);
        } else {
            vh = (ViewHolder) convertView.getTag();
        }

        Person p = list.get(position);

        vh.id.setText(p.getId() + "");
        vh.name.setText(p.getName());
        String dogsInfo = "";
        for (Dog dog : p.getDogs())
            dogsInfo += dog.getId() + "-" + dog.getName() + "\n";

        vh.dogs.setText(dogsInfo);
        return convertView;
    }

    public class ViewHolder {
        TextView id;
        TextView name;
        TextView dogs;
    }
}
