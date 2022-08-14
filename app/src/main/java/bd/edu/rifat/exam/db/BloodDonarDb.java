package bd.edu.rifat.exam.db;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import bd.edu.rifat.exam.daos.BloodDao;
import bd.edu.rifat.exam.entities.Blood;

@Database(entities = {Blood.class}, version = 1)
public abstract class BloodDonarDb extends RoomDatabase {

    public abstract BloodDao getStudentDao();

    private static BloodDonarDb db;


    public static BloodDonarDb getDb(Context context){

        if (db ==null){
            db= Room.databaseBuilder(context,BloodDonarDb.class,"blood_db")
                    .allowMainThreadQueries()
                    .build();
            return db;
        }
        return db;
    }


}
