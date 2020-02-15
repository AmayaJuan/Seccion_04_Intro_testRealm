package com.jpvaapi.seccion_04_intro_testrealm.application;

import android.app.Application;

import java.util.concurrent.atomic.AtomicInteger;

import io.realm.Realm;
import io.realm.RealmConfiguration;
import io.realm.RealmObject;
import io.realm.RealmResults;

/**
 * Created by Juan P on 15/02/20
 */
public class MyApplication extends Application {

    public static AtomicInteger PersonID = new AtomicInteger();
    public static AtomicInteger DogID = new AtomicInteger();

    @Override
    public void onCreate() {
        super.onCreate();

        //Initialize Realm
        Realm.init(getApplicationContext());
        //create your Realm configuration
        RealmConfiguration config = new RealmConfiguration
                .Builder()
                .deleteRealmIfMigrationNeeded()
                .build();
        Realm.setDefaultConfiguration(config);
    }

    private <T extends RealmObject> AtomicInteger setAtomicId(Realm realm, Class<T> anyClass) {
        RealmResults<T> results = realm.where(anyClass).findAll();
        return (results.size() > 0) ? new AtomicInteger(results.max("id").intValue()) : new AtomicInteger();
    }
}

