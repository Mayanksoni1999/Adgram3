package com.xyz.adgram.DataModel;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

@Dao
public interface MyDao2 {
        @Insert
        public void addUser(Authetication authetication);

        @Query("Select * from authentication where pid LIKE :uid ")
        public List<Authetication> check(String uid);
    }

