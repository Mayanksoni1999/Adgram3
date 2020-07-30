package com.xyz.adgram.DataModel;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName="authentication")
public class Authetication {
    @NonNull
    @PrimaryKey
    @ColumnInfo(name = "pid")
    String id;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    @ColumnInfo(name = "passw")
    String pass;
}
