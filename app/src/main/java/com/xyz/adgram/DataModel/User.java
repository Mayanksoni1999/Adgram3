package com.xyz.adgram.DataModel;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;


@Entity(tableName="Users")
public class User {
    //ad
    @PrimaryKey(autoGenerate=true)
    private int uid;

    @ColumnInfo(name = "desp")
    private String desp;

    @ColumnInfo(typeAffinity = ColumnInfo.BLOB)
    byte[] image;

    @ColumnInfo(name = "tbids")
    private int tbids;

    @ColumnInfo(name = "abids")
    private int abids;



    //influ
    @ColumnInfo(name = "follo")
    private int folo;

    @ColumnInfo(name = "likes")
    private int likes;

    @ColumnInfo(name = "msgs")
    private int mags;

    @ColumnInfo(name = "posts")
    private int posts;

    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    public byte[] getImage() {
        return image;
    }

    public void setImage(byte[] image) {
        this.image = image;
    }

    public String getDesp() {
        return desp;
    }

    public void setDesp(String desp) {
        this.desp = desp;
    }

    public int getTbids() {
        return tbids;
    }

    public void setTbids(int tbids) {
        this.tbids = tbids;
    }

    public int getAbids() {
        return abids;
    }

    public void setAbids(int abids) {
        this.abids = abids;
    }

    public int getFolo() {
        return folo;
    }

    public void setFolo(int folo) {
        this.folo = folo;
    }

    public int getLikes() {
        return likes;
    }

    public void setLikes(int likes) {
        this.likes = likes;
    }

    public int getMags() {
        return mags;
    }

    public void setMags(int mags) {
        this.mags = mags;
    }

    public int getPosts() {
        return posts;
    }

    public void setPosts(int posts) {
        this.posts = posts;
    }


}
