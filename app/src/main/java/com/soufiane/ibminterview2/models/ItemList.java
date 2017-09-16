package com.soufiane.ibminterview2.models;

/**
 * Created by Soufiane on 15/09/2017.
 */

import java.util.ArrayList;
import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ItemList {

    @SerializedName("data")
    @Expose
    private ArrayList<Item> data = null;

    public ArrayList<Item> getData() {
        return data;
    }

    public void setData(ArrayList<Item> data) {
        this.data = data;
    }

}