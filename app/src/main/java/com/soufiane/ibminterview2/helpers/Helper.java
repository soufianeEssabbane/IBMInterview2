package com.soufiane.ibminterview2.helpers;

import android.content.Context;

/**
 * Created by Soufiane on 15/09/2017.
 */
public class Helper {

    private Context mContext;

    private static Helper ourInstance = new Helper();

    public static Helper getInstance() {
        return ourInstance;
    }

    private Helper() {

    }

    public void setContext (Context context)
    {
        this.mContext = context;
    }

    public Context getContext(){

        return this.mContext;
    }
}
