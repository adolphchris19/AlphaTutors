package com.alphatutors.android.alphatutors;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Spinner;

import Data.AlphaTutorsContract.FeedEntry;
import Data.DatabaseHelper;

public class SignUpActivity extends AppCompatActivity {
    private Spinner gender_sp, city_sp, state_sp;
    private EditText fn_et, e_mail_et, mn_et, pw_et, dob_et, add_et;
    private RadioGroup userty_rg;
    private CheckBox terms_cb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        gender_sp = findViewById(R.id.gender);
        city_sp = findViewById(R.id.city);
        state_sp = findViewById(R.id.state);
        fn_et = findViewById(R.id.fullname);
        e_mail_et = findViewById(R.id.email);
        mn_et = findViewById(R.id.mobile);
        pw_et = findViewById(R.id.password_1);
        dob_et = findViewById(R.id.datebirth);
        add_et = findViewById(R.id.address);
        userty_rg = findViewById(R.id.usertype);
        terms_cb = findViewById(R.id.switches_ch);

// Create an ArrayAdapter using the string array and a default spinner layout
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.gender, android.R.layout.simple_spinner_item);
// Specify the layout to use when the list of choices appears
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
// Apply the adapter to the spinner
        gender_sp.setAdapter(adapter);

        ArrayAdapter<CharSequence> city_adapter = ArrayAdapter.createFromResource(this,
                R.array.city, android.R.layout.simple_spinner_item);
// Specify the layout to use when the list of choices appears
        city_adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
// Apply the adapter to the spinner
        city_sp.setAdapter(city_adapter);

        ArrayAdapter<CharSequence> state_adapter = ArrayAdapter.createFromResource(this,
                R.array.state, android.R.layout.simple_spinner_item);
// Specify the layout to use when the list of choices appears
        state_adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
// Apply the adapter to the spinner
        state_sp.setAdapter(state_adapter);

        DatabaseHelper mDbHelper = new DatabaseHelper(this);

        // Gets the data repository in write mode
        final SQLiteDatabase db = mDbHelper.getWritableDatabase();

// Create a new map of values, where column names are the keys
        final ContentValues values = new ContentValues();
        values.put(FeedEntry.COLUMN_NAME_FULLNAME, fn_et.getText().toString());
        values.put(FeedEntry.COLUMN_NAME_LOGIN, e_mail_et.getText().toString());
        values.put(FeedEntry.COLUMN_NAME_ADDRESS, add_et.getText().toString());
        values.put(FeedEntry.COLUMN_NAME_DOB, dob_et.getText().toString());
        values.put(FeedEntry.COLUMN_NAME_PASSWORD, pw_et.getText().toString());

        userty_rg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId) {
                    case R.id.tutor:
                        // do operations specific to this selection
                        values.put(FeedEntry.COLUMN_NAME_USERTYPE, "Tutor");
                        break;
                    case R.id.learner:
                        // do operations specific to this selection
                        values.put(FeedEntry.COLUMN_NAME_USERTYPE, "Learner");
                        break;
                }

            }
        });

        // Insert the new row, returning the primary key value of the new row
        long newRowId = db.insert(FeedEntry.TABLE_NAME, null, values);

    }


}
