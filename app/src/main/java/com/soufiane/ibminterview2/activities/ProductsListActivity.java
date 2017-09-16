package com.soufiane.ibminterview2.activities;


import android.content.Intent;
import android.os.Bundle;

import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.soufiane.ibminterview2.R;
import com.soufiane.ibminterview2.adapters.PorductsListRecycleViewAdapter;
import com.soufiane.ibminterview2.helpers.Helper;
import com.soufiane.ibminterview2.helpers.ItemClickListener;
import com.soufiane.ibminterview2.models.Item;
import com.soufiane.ibminterview2.models.ItemList;
import com.soufiane.ibminterview2.networking.APIClient;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class ProductsListActivity extends BaseActivity implements ItemClickListener {

    // ------------------------------
    // ATTRIBUTS
    // ------------------------------
    private RecyclerView mRecyclerView;
    private PorductsListRecycleViewAdapter mAdapter;
    private ItemList mItems;

    // -------------------------------
    // LIFECYCLE
    // --------------------------------
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_produt_list);

        setupView();
        processRequest();
    }

    // -------------------------------
    // PUBLIC METHODS
    // --------------------------------

    @Override
    public void setupView(){

        super.setupView();

        mRecyclerView = (RecyclerView) findViewById(R.id.listIems);

        mRecyclerView.setHasFixedSize(false);

        LinearLayoutManager mLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mLayoutManager);
        mRecyclerView.setItemAnimator(new DefaultItemAnimator());
    }

    // -------------------------------
    // PRIVATE METHODS
    // --------------------------------

    private void processRequest(){

        //Little trick to get the context in a static class
        Helper.getInstance().setContext(this.getApplicationContext());

        Call<ItemList>  call = APIClient.getClient().processGetItems();
        call.enqueue(new Callback<ItemList>() {
            @Override
            public void onResponse(Call<ItemList> call, Response<ItemList> response) {

                mItems = response.body();
                setupRecycleViewWithData();

                Helper.getInstance().setContext(null);
            }

            @Override
            public void onFailure(Call<ItemList> call, Throwable t) {

                call.cancel();
            }
        });
    }

    private void setupRecycleViewWithData(){
        mAdapter = new PorductsListRecycleViewAdapter(mItems);
        mRecyclerView.setAdapter(mAdapter);
        mAdapter.setClickListener(this);
    }

    @Override
    public void onClick(View view, int position) {
        final Item item = mItems.getData().get(position);
        Intent detailProductActivity = new Intent(this, DetailProductActivity.class);
        detailProductActivity.putExtra(DetailProductActivity.ITEM_EXTRA, item);
        startActivity(detailProductActivity);
    }


}
