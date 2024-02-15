package aa.bb.demoretrofit;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {
Button btn1,btn2,btn3;
EditText editId;
TextView txtTitle;
ListView lv1,lv2;
Retrofit retro;
JsonPlaceHolderApi phApi;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn1=findViewById(R.id.btn1);
        btn3=findViewById(R.id.btn3);
        lv1=findViewById(R.id.LV1);
        btn2=findViewById(R.id.btn2);
        lv2=findViewById(R.id.LV2);
        retro = new Retrofit.Builder()
                .baseUrl("https://jsonplaceholder.typicode.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
phApi=retro.create(JsonPlaceHolderApi.class);

btn1.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View view) {
        Call<List<Post>> call1 = phApi.listePosts();
call1.enqueue(new Callback<List<Post>>() {
    @Override
    public void onResponse(Call<List<Post>> call, Response<List<Post>> response) {
        Log.i("aa","ok1");
        if (response.isSuccessful()) {
            Log.i("aa","ok2");
            List<Post> lst = response.body();
            ArrayAdapter<Post> AA = new ArrayAdapter<Post>(getApplicationContext(), android.R.layout.simple_list_item_1, lst);
            lv1.setAdapter(AA);
        }
    }

    @Override
    public void onFailure(Call<List<Post>> call, Throwable t) {

    }
});
    }
});

btn2.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View view) {
        Call<List<Photo>> call= phApi.getListePhotos();
        call.enqueue(new Callback<List<Photo>>() {
            @Override
            public void onResponse(Call<List<Photo>> call, Response<List<Photo>> response) {

                if (response.isSuccessful()) {
                      List<Photo> lst = response.body();
                    ArrayAdapter<Photo> AA = new ArrayAdapter<Photo>(getApplicationContext(), android.R.layout.simple_list_item_1, lst);
                    lv2.setAdapter(AA);
                }
            }

            @Override
            public void onFailure(Call<List<Photo>> call, Throwable t) {

            }
        });
    }
});
btn3.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View view) {
        txtTitle=findViewById(R.id.txtTitle);
        editId=findViewById(R.id.editId);
        Call<Post> call= phApi.getPostById(Integer.parseInt(editId.getText().toString()));
        call.enqueue(new Callback<Post>() {
            @Override
            public void onResponse(Call<Post> call, Response<Post> response) {
                if (response.isSuccessful()) {
                    Post P = response.body();
                    txtTitle.setText(P.getTitle());
                }
            }

            @Override
            public void onFailure(Call<Post> call, Throwable t) {

            }
        });
    }
});
    }
}