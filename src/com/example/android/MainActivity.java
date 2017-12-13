package com.example.android;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.example.android.bean.Message1;
import com.example.android.bean.ResponeMessage;
import com.example.android.utils.listview.CommonAdapter;
import com.example.android.utils.listview.ViewHolder;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.show.api.ShowApiRequest;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;


public class MainActivity extends Activity {
	
	private String appid = "51979";
	private String secret ="743bdc65ff4541f7af1cfc049ab5dba6";
	private Button button;
	private ListView listView;
	private CommonAdapter<ResponeMessage> adapter;
	private List<ResponeMessage> mList;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		button = (Button) findViewById(R.id.bt);
		listView = (ListView) findViewById(R.id.listview);
		mList = new ArrayList<ResponeMessage>();
		button.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				new Thread(){
					@Override
					public void run() {
						final String res=new ShowApiRequest( "http://route.showapi.com/119-42", appid, secret)
				        .addTextPara("date", "").post();
						Log.w("MainActivity","onClick :");
							Message msg = new Message();
							msg.what = 1;
							msg.obj = res;
							mHandler.sendMessage(msg);
					}
				}.start();
			}
		});
		
	}
	private Handler mHandler = new Handler(){

		@Override
		public void handleMessage(Message msg) {
			switch (msg.what) {
			case 1:
				String str = (String) msg.obj;
				try {
					JSONObject obje = new JSONObject(str);
					JSONObject oh = obje.getJSONObject("showapi_res_body");
					Gson mGson = new Gson();
					Message1 msg1 = mGson.fromJson(oh.toString(), Message1.class);
					ResponeMessage[] res = msg1.getList();
					mList.clear();
					for (int i = 0; i < res.length; i++) {
						Log.w("MainActivity", " url : " + res[i].getImg());
						mList.add(res[i]);
					}
					setAdapter(mList);
				} catch (JSONException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				break;

			default:
				break;
			}
		}
	};
	
	private void setAdapter(List<ResponeMessage> list){
		adapter = new CommonAdapter<ResponeMessage>(getApplicationContext(),mList,R.layout.item_layout) {
			
			@Override
			public void convert(ViewHolder helper, ResponeMessage item) {
				// TODO Auto-generated method stub
				helper.setText(R.id.title, item.getTitle());
				Log.w("MainActivity", " url : " + item.getImg());
				helper.setImageByUrl(R.id.imageView, item.getImg());
				helper.setText(R.id.date, item.getYear() + "年" + item.getMonth() + "月" + item.getDay()+ "日");
			}
		};
		listView.setAdapter(adapter);
	}
}
