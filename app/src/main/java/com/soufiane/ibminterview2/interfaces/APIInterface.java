package com.soufiane.ibminterview2.interfaces;

import com.soufiane.ibminterview2.models.ItemList;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by Soufiane on 15/09/2017.
 */

public interface APIInterface {

    String ENDPOINT = "http://www.soufianeessabbane.com/";

    @GET("/")
    Call<ItemList> processGetItems();
}
