package com.example.viewmodel;

import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import java.util.Random;

public class MainActivityViewModel extends ViewModel {


    private MutableLiveData<String> randomNumber;

    public MutableLiveData<String> getRandomNumber() {
        Log.i(this.getClass().getSimpleName(),"get my random number");
        if(randomNumber==null)
        {
            randomNumber=new MutableLiveData<>();
            createNumber();
        }
        return randomNumber;

    }

    public void createNumber()
    {
        Random random=new Random();
        Log.i(this.getClass().getSimpleName(),"Random number created");
        randomNumber.postValue("Number is "+random.nextInt(10));
    }


    @Override
    protected void onCleared() {
        Log.i(this.getClass().getSimpleName(),"Called clear");
        super.onCleared();
    }
}
