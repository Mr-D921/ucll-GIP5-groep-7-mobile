package ucll.java.mobile.ucll_gip5_groep7;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.PopupMenu;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.google.android.material.bottomappbar.BottomAppBar;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import org.json.JSONObject;

import java.util.ArrayList;

import ucll.java.mobile.ucll_gip5_groep7.databinding.ActivityHomeBinding;

public class HomeActivity extends AppCompatActivity implements PopupMenu.OnMenuItemClickListener{

    private AppBarConfiguration appBarConfiguration;
    private ActivityHomeBinding binding;

    private static final String TAG = "HomeActivity";
    private FloatingActionButton fab;
    private BottomAppBar btmAppBar;
    private BottomNavigationView btmNavView;

    public String url = "";
    private RequestQueue queue = Volley.newRequestQueue(this);

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        Log.d(TAG, "Application run successful!");

        NavController navController = Navigation.findNavController(this, R.id.nav_fragment1);
        appBarConfiguration = new AppBarConfiguration.Builder(navController.getGraph()).build();
        NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration);

        // floating action button
        fab = findViewById(R.id.fab);

        btmAppBar = findViewById(R.id.bottomAppBar2);
        btmNavView = findViewById(R.id.btmNavBar);

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(HomeActivity.this, "onclick fab works!", Toast.LENGTH_LONG).show();
                Log.d(TAG,"FAB onclick event successful!");
                showPopupMenu(view);
            }
        });

    }
    public void mainScreen(View view){
        Intent intentMain = new Intent(getApplicationContext(), MainActivity.class);
        startActivity(intentMain);
    }
    public void showPopupMenu(View view){
        PopupMenu popup = new PopupMenu(this, view);
        MenuInflater inflater = popup.getMenuInflater();
        inflater.inflate(R.menu.fab_menu, popup.getMenu());
        popup.show();
    }

    @Override
    public boolean onMenuItemClick(MenuItem menuItem) {
        Toast.makeText(this, "Geselecteerde item: " + menuItem.getTitle(), Toast.LENGTH_SHORT).show();
        switch (menuItem.getItemId()){
            case R.id.uploadVideo:
            case R.id.downloadVideo:
            case R.id.copyUrl:
            case R.id.deleteVideo:
                return true;
            default:
                return false;
        }
    }

    // REST API request(s)
    JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.GET, url, null, new Response.Listener<JSONObject>() {
        @Override
        public void onResponse(JSONObject response) {
            JSONObject jsono = (JSONObject) response;
            Log.d(TAG, jsono.toString());

//            WeatherSearch ws = new Gson().fromJson(jsono.toString(), WeatherSearch.class);

        }
    }, new Response.ErrorListener() {
        @Override
        public void onErrorResponse(VolleyError error) {
//            showAlert(R.string.message_network, error.getMessage());
            Log.e(TAG, error.getMessage());
        }
    });
//     queue.add(jsonObjectRequest);
}
