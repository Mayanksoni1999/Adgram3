package com.xyz.adgram.DataModel;

import androidx.room.Database;
import androidx.room.RoomDatabase;

@Database(entities = {User.class,Authetication.class},version = 3,exportSchema = false)
public abstract class MyAppDatabase extends RoomDatabase {
    public abstract MyDao myDao();
    public abstract MyDao2 myDao2();
}
