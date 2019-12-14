package com.example.crimeapp.Networking;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class CrimeAppClient {
    public static Retrofit instance;
    private static final String BASE_URL="https://cloud.mongodb.com/";
    private static final String DATABASE_NAME="";
    private static final String COLLECTION_NAME="";
    private static final String API_KEY="";

    public static Retrofit getInstance() {
        if(instance==null){
            instance=new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return instance;
    }
}
