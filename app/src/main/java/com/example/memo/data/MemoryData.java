package com.example.memo.data;

import android.net.Uri;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.concurrent.atomic.AtomicInteger;

public class MemoryData {
    public static final AtomicInteger count = new AtomicInteger(100000);
    private final int memoryID;
    private String password;
    private Uri logo;
    private String name;
    private String description;
    private ArrayList<Uri> contents;
    private Calendar date;

    public MemoryData(String name) {
        memoryID = count.getAndIncrement();
        this.password = null;
        this.name = name;
        contents = new ArrayList<>();
        this.date = Calendar.getInstance();
    }

    public MemoryData(String name, Uri logo) {
        memoryID = count.getAndIncrement();
        this.password = null;
        this.name = name;
        this.logo = logo;
        contents = new ArrayList<>();
        this.date = Calendar.getInstance();
    }

    public int getMemoryID() {
        return memoryID;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Uri getLogo() {
        return logo;
    }

    public void setLogo(Uri logo) {
        this.logo = logo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public ArrayList<Uri> getContents() {
        return contents;
    }

    public void setContents(ArrayList<Uri> contents) {
        this.contents = contents;
    }

    public Calendar getDate() {
        return date;
    }

    public void setDate(Calendar date) {
        this.date = date;
    }

    public JSONObject convertToJSONObject() {
        JSONObject jsonObj = new JSONObject();
        try{
            jsonObj.put("password", password);
            jsonObj.put("logo", logo);
            jsonObj.put("name", name);
            jsonObj.put("description", description);
            jsonObj.put("contents", contents);
            jsonObj.put("date", date);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return jsonObj;
    }
}



