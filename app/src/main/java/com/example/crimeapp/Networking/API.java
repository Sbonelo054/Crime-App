package com.example.crimeapp.Networking;

import com.example.crimeapp.Model.UserDetails;

import retrofit2.Call;
import retrofit2.http.GET;

public interface API {
    @GET("https://cloud.mongodb.com/v2/5deffe15ff7a25b466511707?csrfTime=1576179042422&csrfToken=be5abb6604261a5c12ae3ad7e740c6fe3ffba797&currentOrgId=5deffc99f2a30baa568a4a8c&email=nhlanhlanqondo%40gmail.com&needsMfa=false&uId=5deffc99f2a30baa568a4a8b#metrics/replicaSet/5defff317b6691839318b893/explorer/CrimeAppDatabase/CrimeAppCollection/find")
     Call<UserDetails> getUserReports();
}