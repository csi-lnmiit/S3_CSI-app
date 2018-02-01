package com.example.android.csilnmiit;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;

public class MainActivity extends AppCompatActivity {
    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            FragmentManager fragmentManager = getSupportFragmentManager();
            FragmentTransaction transaction = fragmentManager.beginTransaction();
            switch (item.getItemId()) {
                case R.id.navigation_about_us:
                    transaction.replace(R.id.content,new AboutUsFragment()).commit();
                    return true;
                case R.id.navigation_events:
                    transaction.replace(R.id.content,new EventsFragment()).commit();
                    return true;
                case R.id.navigation_council:
                    transaction.replace(R.id.content,new CouncilFragment()).commit();
                    return true;
                case R.id.navigation_contact_us:
                    transaction.replace(R.id.content,new ContactUsFragment()).commit();
                    return true;
                case R.id.navigation_csi_india:
                    transaction.replace(R.id.content,new CSIIndiaFragment()).commit();
                    return true;
            }
            return false;
        }

    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);

    }

    /***
     * opens website of csi INDIA
     *
     */
    public void explore(View view){

        Uri webpage = Uri.parse("https://www.csi-india.org");
        Intent intent = new Intent(Intent.ACTION_VIEW, webpage);
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }
    }

    /***
     * mails to csi
     *
     */
    public void mailToCSI(View view){
        Intent intent = new Intent(Intent.ACTION_SENDTO);
        intent.setData(Uri.parse("mailto:csilnmiitcouncil@gmail.com")); // only email apps should handle this

        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }
    }

    /***
     * Opens CSI Facebook page
     *
     */
    public void FBCSI(View view) {
        Uri webpage = Uri.parse("https://www.facebook.com/CSIStudentChapterLnmiit");
        Intent intent = new Intent(Intent.ACTION_VIEW, webpage);
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }
    }

    /***
     *
     * should open csi lnmiit weeb page but not working
     */
    public void CSIWeb(View view){
        Uri webpage = Uri.parse("http://csi.lnmiit.ac.in");
        Intent intent = new Intent(Intent.ACTION_VIEW, webpage);
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }
    }
}