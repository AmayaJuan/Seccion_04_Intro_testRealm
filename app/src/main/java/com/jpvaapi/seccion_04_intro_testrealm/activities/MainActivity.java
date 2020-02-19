package com.jpvaapi.seccion_04_intro_testrealm.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;
import android.widget.TextView;

import com.jpvaapi.seccion_04_intro_testrealm.R;
import com.jpvaapi.seccion_04_intro_testrealm.adapters.MyAdapter;
import com.jpvaapi.seccion_04_intro_testrealm.models.Dog;
import com.jpvaapi.seccion_04_intro_testrealm.models.Person;

import io.realm.Realm;
import io.realm.RealmChangeListener;
import io.realm.RealmResults;

public class MainActivity extends AppCompatActivity implements RealmChangeListener<RealmResults<Person>> {

    private ListView listView;
    private MyAdapter adapter;

    private Realm realm;
    private RealmResults<Person> people;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        realm = Realm.getDefaultInstance();
        listView = findViewById(R.id.listView);

        people = getAllPeople();
        people.addChangeListener(this);

        adapter = new MyAdapter(people, R.layout.list_item_view, this);

        listView.setAdapter(adapter);
    }

    @Override
    public void onChange(RealmResults<Person> element) {
        adapter.notifyDataSetChanged();
    }

    @Override
    protected void onDestroy() {
        realm.removeAllChangeListeners();
        realm.close();
        super.onDestroy();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.options, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()) {
            case R.id.item_add:
                addPeople();
                return true;
            case R.id.item_delete:
                removeAll();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    private RealmResults<Person> getAllPeople() {
        return realm.where(Person.class).findAll();
    }

    private void removeAll() {
        realm.beginTransaction();
        realm.deleteAll();
        realm.commitTransaction();
    }

    private void addPeople() {
        realm.executeTransaction(new Realm.Transaction() {
            @Override
            public void execute(Realm realm) {
                Dog dog1 = new Dog("BOBY");
                Dog dog2 = new Dog("TEDDY");
                Dog dog3 = new Dog("RAMBO");
                Dog dog4 = new Dog("CHUCHO");
                Dog dog5 = new Dog("MICHEL");
                Dog dog6 = new Dog("TJ");
                Dog dog7 = new Dog("BART");
                Dog dog8 = new Dog("GOKU");
                Dog dog9 = new Dog("PIESITO");

                Person p1 = new Person("Alejandro");
                Person p2 = new Person("Asian");
                Person p3 = new Person("Fernando");

                p1.getDogs().add(dog1);
                p1.getDogs().add(dog2);
                p1.getDogs().add(dog3);

                p2.getDogs().add(dog4);
                p2.getDogs().add(dog5);
                p2.getDogs().add(dog6);

                p3.getDogs().add(dog7);
                p3.getDogs().add(dog8);
                p3.getDogs().add(dog9);

                realm.copyToRealmOrUpdate(dog1);
                realm.copyToRealmOrUpdate(dog2);
                realm.copyToRealmOrUpdate(dog3);
                realm.copyToRealmOrUpdate(dog4);
                realm.copyToRealmOrUpdate(dog5);
                realm.copyToRealmOrUpdate(dog6);
                realm.copyToRealmOrUpdate(dog7);
                realm.copyToRealmOrUpdate(dog8);
                realm.copyToRealmOrUpdate(dog9);

                realm.copyToRealmOrUpdate(p1);
                realm.copyToRealmOrUpdate(p2);
                realm.copyToRealmOrUpdate(p3);

                people = getAllPeople();
            }
        });
    }
}
