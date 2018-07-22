package com.alphatutors.android.alphatutors;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.provider.BaseColumns;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import Data.AlphaTutorsContract;
import Data.DatabaseHelper;

public class LoginActivity extends AppCompatActivity {
    private Button signup_bt;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        signup_bt = findViewById(R.id.sign_up);
        signup_bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LoginActivity.this, SignUpActivity.class);
                startActivity(intent);
            }
        });

        DatabaseHelper mDbHelper = new DatabaseHelper(getApplicationContext());

        SQLiteDatabase db = mDbHelper.getReadableDatabase();

// Define a projection that specifies which columns from the database
// you will actually use after this query.
        String[] projection = {
                BaseColumns._ID,
                AlphaTutorsContract.FeedEntry.COLUMN_NAME_LOGIN,
                AlphaTutorsContract.FeedEntry.COLUMN_NAME_FULLNAME
        };

// Filter results WHERE "title" = 'My Title'
        String selection = AlphaTutorsContract.FeedEntry.COLUMN_NAME_CITY + " = ?";
        String[] selectionArgs = {"My Title"};

// How you want the results sorted in the resulting Cursor
        String sortOrder =
                AlphaTutorsContract.FeedEntry.COLUMN_NAME_STATE + " DESC";

        Cursor cursor = db.query(
                AlphaTutorsContract.FeedEntry.TABLE_NAME,   // The table to query
                projection,             // The array of columns to return (pass null to get all)
                selection,              // The columns for the WHERE clause
                selectionArgs,          // The values for the WHERE clause
                null,                   // don't group the rows
                null,                   // don't filter by row groups
                sortOrder               // The sort order
        );
    }
}
