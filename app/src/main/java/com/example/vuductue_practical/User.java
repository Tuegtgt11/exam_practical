package com.example.vuductue_practical;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.io.Serializable;

@Entity(tableName = "user")
public class User implements Serializable {
    @PrimaryKey(autoGenerate = true)
    public int id;
    @ColumnInfo(name = "username")
    public String username;
    @ColumnInfo(name = "gender")
    public String gender;
    @ColumnInfo(name = "email")
    public String email;
    @ColumnInfo(name = "des")
    public String des;
    public User(){

    }

    public User(int id, String username, String gender, String email, String des) {
        this.id = id;
        this.username = username;
        this.gender = gender;
        this.email = email;
        this.des = des;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getDes() {
        return des;
    }

    public void setDes(String des) {
        this.des = des;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}

