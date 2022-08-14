package bd.edu.rifat.exam.repos;

import android.content.Context;

import androidx.lifecycle.LiveData;

import java.util.List;

import bd.edu.rifat.exam.daos.BloodDao;
import bd.edu.rifat.exam.db.BloodDonarDb;
import bd.edu.rifat.exam.entities.Blood;

public class BloodLocalRepository {

    private BloodDao bloodDao;

    public BloodLocalRepository(Context context){

        bloodDao= BloodDonarDb.getDb(context).getStudentDao();
    }

    public void addStudent(Blood blood){

        bloodDao.insertBloodDonar(blood);

    }


    public LiveData<List<Blood>> getAllDonars(){
        return bloodDao.getAllDonars();
    }

}
