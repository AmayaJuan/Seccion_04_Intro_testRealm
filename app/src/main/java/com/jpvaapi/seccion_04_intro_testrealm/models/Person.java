package com.jpvaapi.seccion_04_intro_testrealm.models;

import com.jpvaapi.seccion_04_intro_testrealm.application.MyApplication;

import io.realm.RealmList;
import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

/**
 * Created by Juan P on 15/02/20
 */
public class Person extends RealmObject {

    @PrimaryKey
    private int Id;
    private String Name;
    private RealmList<Dog> Dogs;

    public Person() {
    }//Only for Realm

    public Person(String name) {
        Id = MyApplication.PersonID.incrementAndGet();
        Name = name;
        Dogs = new RealmList<Dog>();
    }

    public int getId() {
        return Id;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public RealmList<Dog> getDogs(){
        return Dogs;
    }
}
