package com.example.jobfinder.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.jobfinder.R;
import com.example.jobfinder.model.CV;

import java.util.List;

public class CVAdapter extends RecyclerView.Adapter<CVHolder> {

    private final List<CV> cvs;

    public CVAdapter(List<CV> cvs) {
        this.cvs = cvs;
    }

    @NonNull
    @Override
    public CVHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.cv_item, parent, false);
        return new CVHolder(view);
    }
    @Override
    public void onBindViewHolder(@NonNull CVHolder holder, int position) {
        CV cv = cvs.get(position);
        holder.tvNom.setText(cv.getNom());
        holder.tvPrenom.setText(cv.getPrenom());
        holder.tvSpecialite.setText(cv.getSpecialite());
    }

    @Override
    public int getItemCount() {
        return cvs.size();
    }


}
