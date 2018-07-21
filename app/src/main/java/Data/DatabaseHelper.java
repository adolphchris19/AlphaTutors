package Data;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import Data.AlphaTutorsContract.FeedEntry;

public class DatabaseHelper extends SQLiteOpenHelper {
    // If you change the database schema, you must increment the database version.
    public static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "AlphaTutors.db";

    private static final String SQL_CREATE_ENTRIES =
            "CREATE TABLE " + AlphaTutorsContract.FeedEntry.TABLE_NAME + " (" +
                    AlphaTutorsContract.FeedEntry._ID + " INTEGER PRIMARY KEY," +
                    FeedEntry.COLUMN_NAME_LOGIN + " TEXT," +
                    FeedEntry.COLUMN_NAME_PASSWORD + " TEXT," +
                    FeedEntry.COLUMN_NAME_USERTYPE + " TEXT," +
                    FeedEntry.COLUMN_NAME_FULLNAME + " TEXT," +
                    FeedEntry.COLUMN_NAME_ADDRESS + " TEXT," +
                    FeedEntry.COLUMN_NAME_CITY + " TEXT," +
                    FeedEntry.COLUMN_NAME_STATE + " TEXT," +
                    FeedEntry.COLUMN_NAME_GENDER + " TEXT," +
                    FeedEntry.COLUMN_NAME_DOB + " DATE," +
                    FeedEntry.COLUMN_NAME_MOBILE + " INT)";

    private static final String SQL_DELETE_ENTRIES =
            "DROP TABLE IF EXISTS " + AlphaTutorsContract.FeedEntry.TABLE_NAME;

    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    public void onCreate(SQLiteDatabase db) {
        db.execSQL(SQL_CREATE_ENTRIES);
    }

    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // This database is only a cache for online data, so its upgrade policy is
        // to simply to discard the data and start over
        db.execSQL(SQL_DELETE_ENTRIES);
        onCreate(db);
    }

    public void onDowngrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        onUpgrade(db, oldVersion, newVersion);
    }
}

