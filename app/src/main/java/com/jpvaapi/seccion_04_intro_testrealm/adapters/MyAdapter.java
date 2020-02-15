package com.jpvaapi.seccion_04_intro_testrealm.adapters;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

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

        return convertView;
    }
}
