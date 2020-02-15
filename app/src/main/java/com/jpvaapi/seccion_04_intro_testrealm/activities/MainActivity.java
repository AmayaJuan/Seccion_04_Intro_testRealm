package com.jpvaapi.seccion_04_intro_testrealm.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

import com.jpvaapi.seccion_04_intro_testrealm.R;
import com.jpvaapi.seccion_04_intro_testrealm.adapters.MyAdapter;

public class MainActivity extends AppCompatActivity {

    private ListView listView;
    private MyAdapter adapter;

    private Realm realm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
