package database.MyDBData;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Build;

/**
 * Created by yueuy on 17-11-24.
 */

public class MyDataBaseHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "myDataBase.db";
    private static final int VERSION = 0;
    private Context mContext;

    public MyDataBaseHelper(Context context){
        super(context,DATABASE_NAME,null, VERSION);
        mContext = context;
    }

    @Override
    public void onCreate(SQLiteDatabase db){
        db.execSQL("create table" + DATABASE_NAME + "("
                + MyDBData.MyData.Cols.RESULT + ".");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion){

    }
}
