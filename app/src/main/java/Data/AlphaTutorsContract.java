package Data;

import android.provider.BaseColumns;

public final class AlphaTutorsContract {

    // To prevent someone from accidentally instantiating the contract class,
    // make the constructor private.
    private AlphaTutorsContract() {
    }

    /* Inner class that defines the table contents */
    public static class FeedEntry implements BaseColumns {
        public static final String _ID = BaseColumns._ID;
        public static final String COLUMN_NAME_LOGIN = "email";
        public static final String COLUMN_NAME_PASSWORD = "password";
        public static final String TABLE_NAME = "biodata";
        public static final String COLUMN_NAME_TITLE = "title";
        public static final String COLUMN_NAME_SUBTITLE = "subtitle";
    }

    /* Inner class that defines the sign up table contents */
    public static class LogonEntry implements BaseColumns {
        public static final String _ID = BaseColumns._ID;
        public static final String TABLE_NAME = "userdata";
        public static final String COLUMN_NAME_LOGIN = "email";
        public static final String COLUMN_NAME_PASSWORD = "password";
    }


}


