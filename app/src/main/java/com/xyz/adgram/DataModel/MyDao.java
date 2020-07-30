package com.xyz.adgram.DataModel;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;
@Dao
public interface MyDao {
    @Insert
    public void addProfile(User user);

    @Query("Select * from Users")
    List<User> getAllUsersProfille();

}
