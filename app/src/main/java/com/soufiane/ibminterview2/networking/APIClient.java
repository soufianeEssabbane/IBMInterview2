package com.soufiane.ibminterview2.networking;

import com.soufiane.ibminterview2.interfaces.APIInterface;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Soufiane on 15/09/2017.
 */

public class APIClient {

    private static APIInterface apiInternface = null;

    public static APIInterface getClient() {
        if(apiInternface == null) {

            final OkHttpClient client = new OkHttpClient.Builder()
                    .addInterceptor(new LocalResponse())
                    .build();

            final Retrofit retrofit = new Retrofit.Builder()
                    .addConverterFactory(GsonConverterFactory.create())
                    .baseUrl(apiInternface.ENDPOINT)
                    .client(client)
                    .build();

            apiInternface = retrofit.create(APIInterface.class);
        }
        return apiInternface;
    }


}
