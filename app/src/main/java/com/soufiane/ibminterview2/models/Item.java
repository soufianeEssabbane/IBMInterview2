package com.soufiane.ibminterview2.models;

/**
 * Created by Soufiane on 15/09/2017.
 */

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.google.gson.internal.Streams;
import com.soufiane.ibminterview2.R;
import com.soufiane.ibminterview2.models.Description;

import java.io.Serializable;

public class Item implements Serializable {

    @SerializedName("itemId")
    @Expose
    private String itemId;
    @SerializedName("value")
    @Expose
    private String value;
    @SerializedName("currency")
    @Expose
    private String currency;
    @SerializedName("title")
    @Expose
    private String title;
    @SerializedName("description")
    @Expose
    private Description description;

    public String getItemId() {
        return itemId;
    }

    public void setItemId(String itemId) {
        this.itemId = itemId;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Description getDescription() {
        return description;
    }

    public void setDescription(Description description) {
        this.description = description;
    }

    public String getFormatedPrice(){
        return "$"+this.getValue()+" ("+this.getCurrency()+")";
    }

    public String getDataForListe(){

        return getTitle() + " : " +getFormatedPrice();

    }
}