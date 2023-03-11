package com.example.jobfinder.adapter;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.jobfinder.R;

public class CVHolder extends RecyclerView.ViewHolder {

    TextView tvNom, tvPrenom, tvSpecialite;

    public CVHolder(@NonNull View itemView) {
        super(itemView);
        tvNom = itemView.findViewById(R.id.tv_nom);
        tvPrenom = itemView.findViewById(R.id.tv_prenom);
        tvSpecialite = itemView.findViewById(R.id.tv_specialite);
    }
}
