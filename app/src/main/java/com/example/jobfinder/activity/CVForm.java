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
    MaterialButton buttonSave = findViewById(R.id.form_buttonSave);
    TextInputEditText et_nom = findViewById(R.id.form_tv_nom);
    TextInputEditText et_prenom = findViewById(R.id.form_tv_prenom);
    TextInputEditText et_specialite = findViewById(R.id.form_tv_specialite);
    TextInputEditText et_email = findViewById(R.id.form_tv_email);
    TextInputEditText et_telephone = findViewById(R.id.form_tv_telephone);
    TextInputEditText et_adresse = findViewById(R.id.form_tv_adresse);
    TextInputEditText et_age = findViewById(R.id.form_tv_age);
    TextInputEditText et_experience = findViewById(R.id.form_tv_experience_pro);
    TextInputEditText et_niveau_etude = findViewById(R.id.form_tv_niveau_etude);


    RetrofitService retrofitService = new RetrofitService();
    CVApi cvApi = retrofitService.getRetrofit().create(CVApi.class);

    buttonSave.setOnClickListener(view -> {
      String nom = String.valueOf(et_nom.getText());
      String prenom = String.valueOf(et_prenom.getText());
      String specialite = String.valueOf(et_specialite.getText());
      String email = String.valueOf(et_email.getText());
      String telephone = String.valueOf(et_telephone.getText());
      String adresse = String.valueOf(et_adresse.getText());
      String age = String.valueOf(et_age.getText());
      String experience = String.valueOf(et_experience.getText());
      String niveau_etude = String.valueOf(et_niveau_etude.getText());

      CV cv = new CV(nom, prenom, Integer.parseInt(age),adresse, email,telephone, specialite , niveau_etude, experience);

      cvApi.saveCV(cv)
          .enqueue(new Callback<CV>() {
            @Override
            public void onResponse(Call<CV> call, Response<CV> response) {
              Toast.makeText(CVForm.this, "Save successful!", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onFailure(Call<CV> call, Throwable t) {
              Toast.makeText(CVForm.this, "Save failed!!!", Toast.LENGTH_SHORT).show();
              Logger.getLogger(CVForm.class.getName()).log(Level.SEVERE, "Error occurred", t);
            }
          });
    });
  }
}