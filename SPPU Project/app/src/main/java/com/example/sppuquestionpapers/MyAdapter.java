package com.example.sppuquestionpapers;


import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;

import java.util.List;

public class MyAdapter extends FirebaseRecyclerAdapter<ViewModel, MyAdapter.MyViewHolder> {
    RecyclerView rView;
    private ViewModel viewModel;
    private List<ViewModel> viewModelList;
    private Context mCtx;

    public MyAdapter(@NonNull FirebaseRecyclerOptions<ViewModel> options, Context mCtx, List<ViewModel> viewModelList) {
        super(options);
        this.mCtx = mCtx;
        this.viewModelList = viewModelList;
    }

    @Override
    protected void onBindViewHolder(@NonNull MyViewHolder holder, final int position, @NonNull ViewModel model) {

        viewModel = viewModelList.get(position);

        holder.txt.setText(model.getName());
        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(v.getContext(), pdf.class);

                i.putExtra("link", viewModelList.get(position).getUrl());
                mCtx.startActivity(i);


            }
        });
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.single_row, parent, false);
        return new MyViewHolder(view);
    }

    class MyViewHolder extends RecyclerView.ViewHolder {
        TextView txt;

        CardView cardView;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            txt = (TextView) itemView.findViewById(R.id.paperName);
            cardView = (CardView) itemView.findViewById(R.id.cv);
        }
    }





}