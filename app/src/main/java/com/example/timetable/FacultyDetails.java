package com.example.timetable;

import static com.example.timetable.FacultyActivity.SEL_FACULTY;

import androidx.appcompat.app.AppCompatActivity;

import android.net.wifi.p2p.WifiP2pManager;
import android.os.Build;
import android.os.Bundle;
import android.os.TestLooperManager;
import android.view.MenuItem;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toolbar;

import de.hdodenhof.circleimageview.CircleImageView;

public class FacultyDetails extends AppCompatActivity {

    private CircleImageView FacultyImage;
    private Toolbar toolbar;
    private TextView FacultyName;
    private TextView phoneNumber;
    private TextView email;
    private TextView place;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_faculty_details);

        setupUIViews();
        initToolbar();

        setupDetails();
    }

    private void setupUIViews(){

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            toolbar = (Toolbar) findViewById(R.id.ToolbarFacultyDetails);
        FacultyImage = (CircleImageView)findViewById(R.id.ivFaculty);
        FacultyName = (TextView)findViewById(R.id.FacultySelName);
        phoneNumber = (TextView)findViewById(R.id.tvPhoneNumber);
        email = (TextView)findViewById(R.id.tvEmail);
        place = (TextView)findViewById(R.id.tvPlace);}

    }
    private void initToolbar() {
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Faculty Details");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    private void setSupportActionBar(Toolbar toolbar) {
    }

    private void setupDetails(){
        int faculty_pos = FacultyActivity.sharedPreferences.getInt(SEL_FACULTY,0);
        String[] facultyNames = getResources().getStringArray(R.array.faculty_name);
        int[] facultyImages = new int[]{R.drawable.contact,  R.drawable.contact, R.drawable.contact,R.drawable.contact};
        int[] facultyArray = new int[]{R.array.faculty1,R.array.faculty2,R.array.faculty3,R.array.faculty4};
        String[] facultyDetails = getResources().getStringArray(facultyArray[faculty_pos]);
        phoneNumber.setText(facultyDetails[0]);
        email.setText(facultyDetails[1]);
        place.setText(facultyDetails[2]);
        FacultyImage.setImageResource(facultyImages[faculty_pos]);
        FacultyName.setText(facultyNames[faculty_pos]);


    }

    @Override
    public boolean onOptionsItemSelected( MenuItem item) {
        switch(item.getItemId()){
            case android.R.id.home:{
                onBackPressed();
            }

        }
        return super.onOptionsItemSelected(item);
    }
}