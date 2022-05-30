package sg.edu.np.mad.madpractical;

import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.Random;
import java.util.jar.Attributes;

public class db_handler extends SQLiteOpenHelper {

    private String tableName = "User";
    private String col0 = "Name";
    private String col1 = "Desc";
    private String col2 = "Id";
    private String col3 = "Followed";

    public db_handler(Context c) {
        super(c, "Users.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        // CREATE TABLE MESSAGE
        final String query =
                " CREATE TABLE " + tableName + " ( "
                        + col2 + "INTEGER PRIMARY KEY AUTOINCREMENT, "
                        + col0 + "TEXT, "
                        + col1 + "TEXT, "
                        + col3 + "INTEGER"
                        + " ) ";
        db.execSQL(query);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        db.execSQL("DROP TABLE IF EXISTS USER");
        db.close();

    }

    public ArrayList<User> getUsers( ) {

        String query = "SELECT * FROM USER";

        SQLiteDatabase db = this.getWritableDatabase();

        Cursor cursor = db.rawQuery(query, null);

        ArrayList<User> userList = new ArrayList<>();

        while (cursor.moveToNext()){
            User user = new User();

            user.name = cursor.getString(0);
            user.description = cursor.getString(1);
            user.id = cursor.getInt(2);
            user.followed = 1 == cursor.getInt(3);

            userList.add(user);
        }

        db.close();
        return userList;

    }

    public void updateUser(User user){
        SQLiteDatabase db = this.getWritableDatabase();

        Integer intfollowed;

        if (user.followed){
            intfollowed = 1;
        }

        else{
            intfollowed =  0;
        }

        String query = "UPDATE USER SET FOLLOWED = \"" + intfollowed + "\" WHERE ID = \"" + user.id + "\"";

        db.execSQL(query);
        db.close();
    }

    public User oneUser(Integer id){

        String query = "SELECT * FROM USER WHERE ID = " + "\"" + id + "\"";
        SQLiteDatabase db = this.getWritableDatabase();

        Cursor cursor = db.rawQuery(query,null);

        User user = new User();

        if (cursor.moveToFirst()){

            int intfollowed = cursor.getInt(3);
            Boolean boolfollowed;

            boolfollowed = intfollowed == 1;

            user.name = cursor.getString(0);
            user.description = cursor.getString(1);
            user.id = cursor.getInt(2);
            user.followed = boolfollowed;
        }

        return user;

    }

}
