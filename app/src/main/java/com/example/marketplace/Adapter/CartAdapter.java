package com.example.marketplace.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.GranularRoundedCorners;
import com.example.marketplace.Domain.PopularDomain;
import com.example.marketplace.Helper.ChangeNumberItemsListener;
import com.example.marketplace.Helper.ManagmentCart;
import com.example.marketplace.databinding.ViewholderCartBinding;

import java.util.ArrayList;

public class CartAdapter extends RecyclerView.Adapter<CartAdapter.Viewholder> {
    ArrayList<PopularDomain> items;
    Context context;
    ChangeNumberItemsListener changeNumberItemsListener;
    ManagmentCart managmentCart;

    public CartAdapter(ArrayList<PopularDomain> items, ChangeNumberItemsListener changeNumberItemsListener) {
        this.items = items;
        this.changeNumberItemsListener = changeNumberItemsListener;
    }

    @NonNull
    @Override
    public CartAdapter.Viewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        context = parent.getContext();
        managmentCart = new ManagmentCart(context);
        ViewholderCartBinding binding = ViewholderCartBinding.inflate(LayoutInflater.from(context), parent, false);
        return new Viewholder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull CartAdapter.Viewholder holder, int position) {
        holder.bind(items.get(position), position);
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    public class Viewholder extends RecyclerView.ViewHolder {
        ViewholderCartBinding binding;

        public Viewholder(ViewholderCartBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }

        public void bind(PopularDomain item, int position) {
            binding.titleTxt.setText(item.getTitle());
            binding.feeEachItem.setText("$" + item.getPrice());
            binding.totalEachItem.setText("$" + Math.round(item.getNumberInCart() * item.getPrice()));
            binding.numberItemTxt.setText(String.valueOf(item.getNumberInCart()));

            int drawableResource = itemView.getResources().getIdentifier(item.getPicUrl(),
                    "drawable", itemView.getContext().getPackageName());

            Glide.with(context)
                    .load(drawableResource)
                    .transform(new GranularRoundedCorners(30, 30, 0, 0))
                    .into(binding.pic);

            binding.plusCartBtn.setOnClickListener(v -> managmentCart.plusNumberItem(items, position, () -> {
                notifyDataSetChanged();
                changeNumberItemsListener.change();
            }));

            binding.minusCartBtn.setOnClickListener(v -> managmentCart.minusNumberItem(items, position, () -> {
                notifyDataSetChanged();
                changeNumberItemsListener.change();
            }));
        }
    }
}

