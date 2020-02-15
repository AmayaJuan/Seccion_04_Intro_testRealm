package com.jpvaapi.seccion_04_intro_testrealm.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

import com.jpvaapi.seccion_04_intro_testrealm.R;
import com.jpvaapi.seccion_04_intro_testrealm.adapters.MyAdapter;
import com.jpvaapi.seccion_04_intro_testrealm.models.Person;

public class MainActivity extends AppCompatActivity {

    private ListView listView;
    private MyAdapter adapter;

    private Realm realm;
    private RealmResultls<Person> people;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        realm = Realm.getDefaulInstance();
        listView = findViewById(R.id.listView);

        people = getAllPeople();
        people.addChangetListener(this);

        adapter = new MyAdapter(people, R.layout.list_item_view, this);

        listView.setAdapter(adapter);
    }
}
