package com.soufiane.ibminterview2.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.soufiane.ibminterview2.R;
import com.soufiane.ibminterview2.helpers.ItemClickListener;
import com.soufiane.ibminterview2.models.Item;
import com.soufiane.ibminterview2.models.ItemList;


/**
 * Created by Soufiane on 15/09/2017.
 */

public class PorductsListRecycleViewAdapter extends RecyclerView.Adapter<PorductsListRecycleViewAdapter.ViewHolder> {

    private final ItemList mItems;
    private ItemClickListener clickListener;

    public PorductsListRecycleViewAdapter(ItemList items) {
        mItems = items;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_list, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        holder.mItem = mItems.getData().get(position);
        holder.mDisplayableText.setText(mItems.getData().get(position).getDataForListe());
    }

    @Override
    public int getItemCount() {
        return mItems.getData().size();
    }

    public void setClickListener(ItemClickListener itemClickListener) {
        this.clickListener = itemClickListener;
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        public final View mView;
        public Item mItem;
        public final TextView mDisplayableText;

        public ViewHolder(View view) {
            super(view);
            mView = view;
            mDisplayableText = (TextView) view.findViewById(R.id.item_textView);
            mView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            if (clickListener != null) clickListener.onClick(view, getAdapterPosition());
        }
    }
}
