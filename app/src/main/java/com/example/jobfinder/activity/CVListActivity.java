package com.example.jobfinder.activity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.jobfinder.R;
import com.example.jobfinder.model.CV;
import com.example.jobfinder.retrofit.CVApi;
import com.example.jobfinder.retrofit.RetrofitService;
import com.example.jobfinder.adapter.CVAdapter;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CVListActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private CVAdapter cvAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cv);

        recyclerView = findViewById(R.id.recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        FloatingActionButton floatingActionButton = findViewById(R.id.cvList_fab);
        floatingActionButton.setOnClickListener(view -> {
            Intent intent = new Intent(this, CVForm.class);
            startActivity(intent);
        });

    }

    private void loadCVs() {
        RetrofitService retrofitService = new RetrofitService();
        CVApi cvApi = retrofitService.getRetrofit().create(CVApi.class);
        cvApi.getAllCVs()
                .enqueue(new Callback<List<CV>>() {
                    @Override
                    public void onResponse(Call<List<CV>> call, Response<List<CV>> response) {
                        populateListView(response.body());
                    }

                    @Override
                    public void onFailure(Call<List<CV>> call, Throwable t) {
                        Toast.makeText(CVListActivity.this, "Failed to load CVs " + t.getMessage(), Toast.LENGTH_SHORT).show();
                    }
                });
    }

    private void populateListView(List<CV> cvList) {
        CVAdapter cvAdapter = new CVAdapter(cvList);
        Toast.makeText(CVListActivity.this, " Size : " + cvList.get(0).toString() , Toast.LENGTH_SHORT).show();
        recyclerView.setAdapter(cvAdapter);
    }

    @Override
    protected void onResume() {
        super.onResume();
        loadCVs();
    }

}