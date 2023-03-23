package ucll.java.mobile.ucll_gip5_groep7_mobile;

import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Locale;

import ucll.java.mobile.ucll_gip5_groep7_mobile.Models.Video;
import ucll.java.mobile.ucll_gip5_groep7_mobile.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";

    private String url = "http://localhost:8080/api/";

    private JsonObjectRequest jsonObjectRequest;

    private FloatingActionButton fab;

    private ArrayList<Video> videoList;

    private RecyclerView recyclerView;

    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        Toolbar toolbar = findViewById(R.id.toolBar);
        setSupportActionBar(toolbar);

        recyclerView = findViewById(R.id.myRecycleView);
        videoList = new ArrayList<>();

        fab = findViewById(R.id.fab);

        getVideos();
        addVideo();

        setAdapter(videoList);

        fab.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               addVideo();
               Log.d(TAG, "fab click worked!");
            }
        });

    }

    private void setAdapter(ArrayList<Video> videos){
        VideoAdapter adapter = new VideoAdapter(videos);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(adapter);
    }

    private void getVideos(){
        RequestQueue queue = Volley.newRequestQueue(this);
        jsonObjectRequest = new JsonObjectRequest(url, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                JSONObject jsono = null;
                Log.d(TAG, jsono.toString());

                for(int i = 0; i < jsono.length(); i++){
                    try {
                        jsono = response.getJSONObject(String.valueOf(i));

                        Video video = new Video();
                        video.setId(jsono.getInt("id"));
                        video.setName(jsono.getString("name"));
                        videoList.add(video);
                    }catch (JSONException e){
                        Log.e(TAG, e.getMessage());
                    }
                }
                setAdapter(videoList);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.e(TAG, error.getMessage());
            }
        });
        queue.add(jsonObjectRequest);
    }

    private void addVideo(){
        videoList.add(new Video(2, "Bunny movie"));
        videoList.add(new Video(3, "The Mummy"));
        videoList.add(new Video(4, "Hello darling"));
    }

    private void deleteVideo(){
        Button btnDeleteVideo = findViewById(R.id.deleteBtn);
    }

    private void updateVideo(){
        Button btnUpdateVideo = findViewById(R.id.deleteBtn);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    private void SetLocale(String language){
        Resources resources = getResources();
        DisplayMetrics displayMetrics = resources.getDisplayMetrics();
        Configuration configuration = resources.getConfiguration();
        configuration.locale = new Locale(language);
        resources.updateConfiguration(configuration, displayMetrics);
        onConfigurationChanged(configuration);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            settingsScreen();
        }

        if (id == R.id.action_languages) {
            return true;
        }

        if (id == R.id.action_logout) {
            loginScreen();
        }

        if(id == R.id.langEnglish){
            SetLocale("en");
        }

        if(id == R.id.langDutch){
            SetLocale("nl");
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onSupportNavigateUp() {
        return true;
    }

    public void loginScreen(){
        Intent loginIntent = new Intent(getApplicationContext(), LoginActivity.class);
        finish();
        startActivity(loginIntent);
    }

    public void settingsScreen(){
        Intent settingsIntent = new Intent(getApplicationContext(), SettingsActivity.class);
        startActivity(settingsIntent);
    }
}