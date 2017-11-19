package android.cuong.surveymvp.data;

import android.content.Context;
import android.cuong.surveymvp.data.model.DaoMaster;
import android.database.sqlite.SQLiteDatabase;

/**
 * Created by QUOC CUONG on 19/11/2017.
 */

//TODO: @Singleton
public class DbOpenHelper extends DaoMaster.OpenHelper {

    //TODO: @inject
    public DbOpenHelper(Context context, String name, SQLiteDatabase.CursorFactory factory) {
        super(context, name, factory);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        super.onUpgrade(db, oldVersion, newVersion);
        //TODO: AppLogger
        switch (oldVersion) {
            case 1:
            case 2:
        }
    }
}
