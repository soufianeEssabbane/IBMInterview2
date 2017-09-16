package com.soufiane.ibminterview2.models;

/**
 * Created by Soufiane on 15/09/2017.
 */

import android.content.res.Resources;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.Locale;

public class Description implements Serializable {

    @SerializedName("en-CA")
    @Expose
    private String enCA;
    @SerializedName("fr-CA")
    @Expose
    private String frCA;

    public String getEnCA() {
        return enCA;
    }

    public void setEnCA(String enCA) {
        this.enCA = enCA;
    }

    public String getFrCA() {
        return frCA;
    }

    public void setFrCA(String frCA) {
        this.frCA = frCA;
    }

    public String getDescriptionBasedOnUserPreferences(){

        Locale locale = null;

        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.N) {
            locale = Resources.getSystem().getConfiguration().getLocales().get(0);
        }else{
            locale = Resources.getSystem().getConfiguration().locale;
        }

        if (locale.getDefault().toString().equalsIgnoreCase("fr-CA")){

            return this.getFrCA();
        }

        return this.getEnCA();
    }

}