package vn.daikon.myapplication.repository;

import android.content.SharedPreferences;
import android.util.Pair;

public class UserRepo {
    SharedPreferences sharedPreferences;
    public UserRepo(SharedPreferences sharedPreferences){
        this.sharedPreferences = sharedPreferences;
    }
    public Pair<String, String> getUser() {
        String user = sharedPreferences.getString("user", null);
        String msv = sharedPreferences.getString("msv" , null);
        if (user == null || msv == null) return new Pair<String, String>("Ten", "Msv" );
        else return new Pair<String, String>(user,msv);
    }
    public void updateUser(String user , String msv) {
        sharedPreferences.edit().putString("user", user).putString("msv",msv).apply();
    }
}
