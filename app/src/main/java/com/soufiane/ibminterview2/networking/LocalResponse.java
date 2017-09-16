package com.soufiane.ibminterview2.networking;

import android.content.Context;
import android.content.res.AssetManager;
import android.util.Log;

import com.soufiane.ibminterview2.BuildConfig;
import com.soufiane.ibminterview2.activities.ProductsListActivity;
import com.soufiane.ibminterview2.helpers.Helper;

import java.io.IOException;
import java.io.InputStream;

import okhttp3.Interceptor;
import okhttp3.MediaType;
import okhttp3.Protocol;
import okhttp3.Response;
import okhttp3.ResponseBody;

/**
 * Created by Soufiane on 15/09/2017.
 */

public class LocalResponse implements Interceptor {

    private static String JSON_FILE = "response.json";

    @Override
    public Response intercept(Chain chain) throws IOException {

        String stringReponse = parseFileToString(Helper.getInstance().getContext(),JSON_FILE);
        Response response  = new Response.Builder()
                    .code(200)
                    .message(stringReponse)
                    .request(chain.request())
                    .protocol(Protocol.HTTP_1_0)
                    .body(ResponseBody.create(MediaType.parse("application/json"), stringReponse.getBytes()))
                    .addHeader("content-type", "application/json")
                    .build();

        return response;
    }


    public static String parseFileToString( Context context, String filename )
    {
        try
        {
            InputStream stream = context.getAssets().open( filename );
            int size = stream.available();

            byte[] bytes = new byte[size];
            stream.read(bytes);
            stream.close();

            return new String( bytes );

        } catch ( IOException e ) {
            Log.i("FormData", "IOException: " + e.getMessage() );
        }
        return null;
    }
}