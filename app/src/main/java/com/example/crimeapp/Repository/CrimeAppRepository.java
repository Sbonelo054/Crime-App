package com.example.crimeapp.Repository;

import androidx.lifecycle.MutableLiveData;

import com.example.crimeapp.Model.UserDetails;

public class CrimeAppRepository {

   public MutableLiveData<UserDetails> UserData;
   public CrimeAppRepository(){
   }

   public MutableLiveData<UserDetails> getUserReports() {
      refreshData();
      return UserData;
   }

   private void refreshData(){
      new Thread(new Runnable() {
         @Override
         public void run() {
             try {
                 getUserReports();
                 Thread.sleep(5000);
             } catch (InterruptedException e) {
                 e.printStackTrace();
             }
         }
      }).start();
   }
}
