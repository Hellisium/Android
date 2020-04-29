package fr.epsi.demo;

import android.os.AsyncTask;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import javax.net.ssl.HttpsURLConnection;

public class HttpAsyTask extends AsyncTask<Void,Void,Object> {

    interface HttpAsyTaskListener{
        void webServiceDone(String result);
        void webServiceError(Exception e);
    }

    private HttpAsyTaskListener httpAsyTaskListener;
    private String urlStr="";

    public HttpAsyTask(String url,HttpAsyTaskListener listener){
        httpAsyTaskListener=listener;
        urlStr=url;
    }

    @Override
    protected Object doInBackground(Void... voids) {
        return call(urlStr);
    }

    @Override
    protected void onPostExecute(Object o) {
        super.onPostExecute(o);
        if(o instanceof Exception){
            httpAsyTaskListener.webServiceError((Exception)o);
        }
        else
            httpAsyTaskListener.webServiceDone(o.toString());
    }


    public Object call(String urlStr) {
        try {
            URL url = null;
            url = new URL(urlStr);
            HttpURLConnection urlConnection;
            if(urlStr.startsWith("https:")){
                urlConnection = (HttpsURLConnection) url.openConnection();
            }
            else{
                urlConnection = (HttpURLConnection) url.openConnection();
            }
            try {
                InputStream in = new BufferedInputStream(urlConnection.getInputStream());
                return convertStreamToString(in);
            } finally {
                urlConnection.disconnect();
            }
        } catch (MalformedURLException e) {
            e.printStackTrace();
            return e;
        } catch (IOException e) {
            e.printStackTrace();
            return e;
        }
    }

    private String convertStreamToString(InputStream is){
        try {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(is));

            StringBuffer stringBuffer = new StringBuffer("");
            String line;

            String NL = System.getProperty("line.separator");
            while ((line = bufferedReader.readLine()) != null)
            {
                stringBuffer.append(line + NL);
            }
            bufferedReader.close();
            return stringBuffer.toString();
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

}
