package com.example.eissa.fetchjsondata;

import android.os.AsyncTask;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import javax.net.ssl.HttpsURLConnection;

public class FetchData extends AsyncTask<Void,Void,Void> {

      String data="";
      String singlePasre="";
      String dataPasre;
    @Override
    protected Void doInBackground(Void... voids)
    {

        try {
            URL url = new URL("https://api.myjson.com/bins/u9ktn");
            HttpURLConnection httpURLConnection=(HttpURLConnection)url.openConnection();
            InputStream inputStream=httpURLConnection.getInputStream();
            BufferedReader bufferedReader=new BufferedReader(new InputStreamReader(inputStream));
            String line="";
            while (line != null)
            {
                line=bufferedReader.readLine();
                data=data+line;
            }

            JSONArray jsonArray= new JSONArray(data);
            for (int i=0;i<jsonArray.length();i++)
            {
                JSONObject object= (JSONObject)jsonArray.get(i);
                singlePasre=" Name :"+object.get("name") + "\n"+
                            " Password :"+object.get("password") +"\n"+
                            " Contact :"+object.get("contact") +"\n";

                dataPasre=dataPasre+singlePasre+ "\n";


            }


        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        }


        return null;

    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
       MainActivity.data.setText(dataPasre);

    }
}
