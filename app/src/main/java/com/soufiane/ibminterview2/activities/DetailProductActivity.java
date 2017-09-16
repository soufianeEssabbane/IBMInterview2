package com.soufiane.ibminterview2.activities;

import android.os.Bundle;
import android.widget.TextView;

import com.soufiane.ibminterview2.R;
import com.soufiane.ibminterview2.models.Item;

import java.io.Serializable;

public class DetailProductActivity extends BaseActivity {

    // -------------------------------
    // CONSTANTS
    // --------------------------------
    public static final String ITEM_EXTRA = "itemExtra";

    // ------------------------------
    // ATTRIBUTS
    // ------------------------------
    private TextView mTitle;
    private TextView mPrice;
    private TextView mDescription;

    // -------------------------------
    // LIFECYCLE
    // --------------------------------
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_product);

        setupView();

        Serializable itemExtra = this.getIntent().getSerializableExtra(ITEM_EXTRA);

        if (itemExtra instanceof Item) {
            setupViewWitItem(itemExtra);
        }
    }
    // -------------------------------
    // PUBLIC METHODS
    // --------------------------------

    public void setupView(){
        super.setupView();

        mTitle = (TextView)findViewById(R.id.item_title);
        mPrice = (TextView)findViewById(R.id.item_price);
        mDescription = (TextView)findViewById(R.id.item_description);
    }

    // -------------------------------
    // PRIVATE METHODS
    // --------------------------------

    /**
     * @param  serializable is an Item as Parcelable
     */
    private void setupViewWitItem(Serializable serializable){

        Item item = (Item)serializable;

        mTitle.setText(item.getTitle());
        mPrice.setText(item.getFormatedPrice());
        mDescription.setText(item.getDescription().getDescriptionBasedOnUserPreferences());
    }
}
