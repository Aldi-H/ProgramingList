package com.example.programinglist;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import java.util.ArrayList;

public class ProgramingListAdapter extends RecyclerView.Adapter<ProgramingListAdapter.ListViewHolder> {
    private ArrayList<Programing> programingArrayList;
    //private OnItemClickCallBack onItemClickCallBack;
    private  OnClick mOnClickListener;

    /*public void setOnItemClickCallBack(OnItemClickCallBack onItemClickCallBack) {
        this.onItemClickCallBack = onItemClickCallBack;
    }*/

    public ProgramingListAdapter(ArrayList<Programing> programingArrayList, OnClick mOnClickListener) {
        this.programingArrayList = programingArrayList;
        this.mOnClickListener = mOnClickListener;
    }

    @NonNull
    @Override
    public ListViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_row_programing, viewGroup,false);
        return new ListViewHolder(view, mOnClickListener);
    }

    @Override
    public void onBindViewHolder(@NonNull final ListViewHolder holder, int position) {
        Programing programing = programingArrayList.get(position);
        Glide.with(holder.itemView.getContext())
                .load(programing
                        .getImage())
                .apply(new RequestOptions()
                        .override(55, 55))
                .into(holder.imgPhoto);
        holder.tvName.setText(programing.getName());
        holder.tvDetail.setText(programing.getDetail());

        /*holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onItemClickCallBack.onItemClicked(programingArrayList.get(holder.getAdapterPosition()));
            }
        });*/
    }

    @Override
    public int getItemCount() {
        return programingArrayList.size();
    }

    //Inisialisasi view yang terdapat di layout item
    public class ListViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        ImageView imgPhoto;
        TextView tvName, tvDetail;
        OnClick onClickListener;

        public ListViewHolder(View itemView, OnClick onClickListener) {
            super(itemView);

            imgPhoto = itemView.findViewById(R.id.img_item_photo);
            tvName = itemView.findViewById(R.id.tv_item_name);
            tvDetail = itemView.findViewById(R.id.tv_item_detail);
            this.onClickListener = onClickListener;

            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            onClickListener.onClick(getAdapterPosition());
        }
    }

    /*public  interface OnItemClickCallBack {
        void onItemClicked(Programing data);
    }*/

    public interface OnClick {
        void onClick(int position);
    }
}
