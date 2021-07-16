package com.prabhakar.myapplication;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    private EditText userId;
    private Button button;
    private TextView name;
    private TextView firstName;
    private TextView lastName;
    private TextView email;
    private ImageView avatar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();
    }

    private void initViews() {
        userId = findViewById(R.id.etUserId);
        button = findViewById(R.id.btnCallApi);
        firstName = findViewById(R.id.tvfirstName);
        lastName = findViewById(R.id.tvLastName);
        email = findViewById(R.id.tvEmail);
        avatar = findViewById(R.id.ivAvatar);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ApiService apiService = Network.getInstance().create(ApiService.class);
                int id = Integer.parseInt(userId.getText().toString());
                apiService.getUser(id).enqueue(new Callback<ResponseDTO>() {
                    @Override
                    public void onResponse(Call<ResponseDTO> call, Response<ResponseDTO> response) {
                        ResponseDTO model = response.body();
                        if (response.body() != null && userId.getText().toString() != null) {
                            int userId = model.getData().getId();
                            String new_firstName = model.getData().getFirstName();
                            String new_lastName = model.getData().getLastName();
                            String new_email = model.getData().getEmail();
                            String new_pic = model.getData().getAvatar();
                            firstName.setText(new_firstName);
                            lastName.setText(new_lastName);
                            email.setText(new_email);
                            Glide.with(avatar).load(model.getData().getAvatar()).into(avatar);
                        } else {

                            firstName.setText("None");
                            lastName.setText("None");
                            email.setText("None");
                            avatar.setImageResource(R.drawable.failed_img);
                        }

                    }


                    @Override
                    public void onFailure(Call<ResponseDTO> call, Throwable t) {

                    }
                });
            }
        });
    }
}