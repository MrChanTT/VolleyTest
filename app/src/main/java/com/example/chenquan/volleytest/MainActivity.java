package com.example.chenquan.volleytest;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.Volley;

import utils.GsonRequest;

public class MainActivity extends AppCompatActivity {
    private String TAG="CQ";

    private RequestQueue requestQueue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        requestQueue = Volley.newRequestQueue(this);
        String url = "************";
        getNetworkDatas(url);
        postNetworkDatas(url);
//        StringRequest request = new StringRequest(Request.Method.GET,url, new Response.Listener<String>() {
//            @Override
//            public void onResponse(String s) {
//                Log.i(TAG,""+s);
//
//            }
//        }, new Response.ErrorListener() {
//            @Override
//            public void onErrorResponse(VolleyError volleyError) {
//                Log.i(TAG,""+volleyError.getMessage());
//            }
//        });
//        requestQueue.add(request);
//
//        String urlpost="http://api.m.panda.tv/ajax_get_all_subcate";
//        StringRequest stringRequest = new StringRequest(Request.Method.POST, urlpost, new Response.Listener<String>() {
//            @Override
//            public void onResponse(String s) {
//                Log.i(TAG,"post:"+s);
//            }
//        }, new Response.ErrorListener() {
//            @Override
//            public void onErrorResponse(VolleyError volleyError) {
//                Log.i(TAG,"post:"+volleyError.getMessage());
//            }
//        }){
//            @Override
//            protected Map<String, String> getParams() throws AuthFailureError {
//                HashMap<String, String> params = new HashMap<String,String>();
//                params.put("__version", "1.0.1.1300");
//                params.put("__plat", "android");
//                return params;
//            }
//        };
//        requestQueue.add(stringRequest);



    }
    /**
     *  根据请求的url的返回的数据格式编写对应格式的实体类来代替String类
     * */
    private void getNetworkDatas(String url){
        GsonRequest<String> gsonRequest = new GsonRequest<String>(Request.Method.GET, url, String.class, new Response.Listener<String>() {
            @Override
            public void onResponse(String string) {
                Log.i(TAG,string+"");
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError volleyError) {
                Log.i(TAG,volleyError.getMessage()+"");
            }
        });
        requestQueue.add(gsonRequest);
    }
    private void postNetworkDatas(String url){
        GsonRequest<String> gsonRequest = new GsonRequest<String>(Request.Method.POST, url, String.class, new Response.Listener<String>() {
            @Override
            public void onResponse(String string) {
                Log.i(TAG,string+"");
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError volleyError) {
                Log.i(TAG,volleyError.getMessage()+"");
            }
        });
        requestQueue.add(gsonRequest);
    }

    

}
