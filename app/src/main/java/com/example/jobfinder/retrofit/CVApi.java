package com.example.jobfinder.retrofit;

import com.example.jobfinder.model.CV;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface CVApi {

    @GET("/api/cv/all")
    Call<List<CV>> getAllCVs();

    @GET("/api/cv/{id}")
    Call<CV> getCVById(@Path("id") long id);

    @POST("/api/cv/save")
    Call<CV> saveCV(@Body CV cv);

    @DELETE("/api/cv/delete/{id}")
    Call<Void> deleteCV(@Path("id") long id);

}
