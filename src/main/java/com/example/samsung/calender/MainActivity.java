package com.example.samsung.calender;

import android.app.FragmentTransaction;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("My Schedule");



    }

    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.main_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }


    public boolean onOptionsItemSelected(MenuItem item) {
        final FragmentTransaction fragmentTransaction =
                getFragmentManager().beginTransaction();
        switch (item.getItemId()) {
            case R.id.action_frag_D:
                fragmentTransaction.replace(R.id.frame, new FragDay()).addToBackStack(null).commit();
                return true;
            case R.id.action_frag_W:
                fragmentTransaction.replace(R.id.frame, new FragWeek()).addToBackStack(null).commit();
                return true;
            case R.id.action_frag_M:
                fragmentTransaction.replace(R.id.frame, new FragMonth()).addToBackStack(null).commit();
                return true;
            case R.id.action_look:
                startActivity(new Intent(this, LookActivity.class));
                return true;
            case R.id.action_edit:
                startActivity(new Intent(this, EditActivity.class));
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
