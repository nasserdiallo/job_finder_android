package com.example.jobfinder.activity;

import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

import com.example.jobfinder.R;
import com.example.jobfinder.model.CV;
import com.example.jobfinder.retrofit.CVApi;
import com.example.jobfinder.retrofit.RetrofitService;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.TextInputEditText;
import java.util.logging.Level;
import java.util.logging.Logger;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CVForm extends AppCompatActivity {

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_cv_form);

    initializeComponents();
  }

  private void initializeComponents() {
    TextInputEditText inputEditTextName = findViewById(R.id.form_textFieldName);
    TextInputEditText inputEditBranch = findViewById(R.id.form_textFieldBranch);
    TextInputEditText inputEditLocation = findViewById(R.id.form_textFieldLocation);
    MaterialButton buttonSave = findViewById(R.id.form_buttonSave);

    RetrofitService retrofitService = new RetrofitService();
    CVApi cvApi = retrofitService.getRetrofit().create(CVApi.class);

    buttonSave.setOnClickListener(view -> {
      String name = String.valueOf(inputEditTextName.getText());
      String branch = String.valueOf(inputEditBranch.getText());
      String location = String.valueOf(inputEditLocation.getText());

//      CV cv = new CV();
//      cv.setName(name);
//      cv.setBranch(branch);
//      cv.setLocation(location);
//
//      cvApi.save(cv)
//          .enqueue(new Callback<CV>() {
//            @Override
//            public void onResponse(Call<CV> call, Response<CV> response) {
//              Toast.makeText(CVForm.this, "Save successful!", Toast.LENGTH_SHORT).show();
//            }
//
//            @Override
//            public void onFailure(Call<CV> call, Throwable t) {
//              Toast.makeText(CVForm.this, "Save failed!!!", Toast.LENGTH_SHORT).show();
//              Logger.getLogger(CVForm.class.getName()).log(Level.SEVERE, "Error occurred", t);
//            }
//          });
    });
  }
}