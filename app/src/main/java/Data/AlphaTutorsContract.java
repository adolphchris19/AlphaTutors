package Data;

import android.provider.BaseColumns;

public final class AlphaTutorsContract {

    // To prevent someone from accidentally instantiating the contract class,
    // make the constructor private.
    private AlphaTutorsContract() {
    }

    /* Inner class that defines the table contents */
    public static class FeedEntry implements BaseColumns {
        public static final String TABLE_NAME = "userbiodata";
        public static final String _ID = BaseColumns._ID;
        public static final String COLUMN_NAME_LOGIN = "email";
        public static final String COLUMN_NAME_PASSWORD = "password";
        public static final String COLUMN_NAME_USERTYPE = "usertype";
        public static final String COLUMN_NAME_FULLNAME = "name";
        public static final String COLUMN_NAME_MOBILE = "mobile";
        public static final String COLUMN_NAME_GENDER = "gender";
        public static final String COLUMN_NAME_DOB = "dateofbirth";
        public static final String COLUMN_NAME_ADDRESS = "address";
        public static final String COLUMN_NAME_CITY = "city";
        public static final String COLUMN_NAME_STATE = "state";
    }

    /* Inner class that defines the sign up table contents */
    public static class LogonEntry implements BaseColumns {
        public static final String _ID = BaseColumns._ID;
        public static final String TABLE_NAME = "userdata";
        public static final String COLUMN_NAME_LOGIN = "email";
        public static final String COLUMN_NAME_PASSWORD = "password";
    }


}


