package com.kama.pol;

import android.app.Activity;
import android.app.*;
import android.os.*;
import android.view.*;
import android.view.View.*;
import android.widget.*;
import android.content.*;
import android.graphics.*;
import android.media.*;
import android.net.*;
import android.text.*;
import android.util.*;
import android.webkit.*;
import android.animation.*;
import android.view.animation.*;
import java.util.*;
import java.text.*;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.EditText;
import android.widget.Button;
import android.content.Intent;
import android.net.Uri;
import android.view.View;

public class MainActivity extends Activity {
	
	
	private String password = "";
	private double soplo = 0;
	
	private LinearLayout linear4;
	private LinearLayout linear5;
	private LinearLayout linear7;
	private LinearLayout linear8;
	private TextView about;
	private EditText passwd;
	private Button checkpass;
	private TextView status;
	private LinearLayout linear6;
	private TextView textview1;
	
	private RequestNetwork getrequest;
	private RequestNetwork.RequestListener _getrequest_request_listener;
	private Intent go = new Intent();
	@Override
	protected void onCreate(Bundle _savedInstanceState) {
		super.onCreate(_savedInstanceState);
		setContentView(R.layout.main);
		initialize(_savedInstanceState);
		initializeLogic();
	}
	
	private void initialize(Bundle _savedInstanceState) {
		
		linear4 = (LinearLayout) findViewById(R.id.linear4);
		linear5 = (LinearLayout) findViewById(R.id.linear5);
		linear7 = (LinearLayout) findViewById(R.id.linear7);
		linear8 = (LinearLayout) findViewById(R.id.linear8);
		about = (TextView) findViewById(R.id.about);
		passwd = (EditText) findViewById(R.id.passwd);
		checkpass = (Button) findViewById(R.id.checkpass);
		status = (TextView) findViewById(R.id.status);
		linear6 = (LinearLayout) findViewById(R.id.linear6);
		textview1 = (TextView) findViewById(R.id.textview1);
		getrequest = new RequestNetwork(this);
		
		checkpass.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				if (password.equals(passwd.getText().toString())) {
					status.setText("Successfull authorization.");
					status.setTextColor(0xFF4CAF50);
					soplo = 1;
				}
				else {
					status.setText("Not valid password.");
					status.setTextColor(0xFFF44336);
					soplo = 0;
				}
			}
		});
		
		linear6.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				if (soplo == 1) {
					
					startActivity(go);
				}
				else {
					SketchwareUtil.showMessage(getApplicationContext(), "You need a password to go next!");
				}
			}
		});
		
		_getrequest_request_listener = new RequestNetwork.RequestListener() {
			@Override
			public void onResponse(String _param1, String _param2) {
				final String _tag = _param1;
				final String _response = _param2;
				
			}
			
			@Override
			public void onErrorResponse(String _param1, String _param2) {
				final String _tag = _param1;
				final String _message = _param2;
				
			}
		};
	}
	private void initializeLogic() {
	}
	
	@Override
	protected void onActivityResult(int _requestCode, int _resultCode, Intent _data) {
		super.onActivityResult(_requestCode, _resultCode, _data);
		
		switch (_requestCode) {
			
			default:
			break;
		}
	}
	
	private void _WebviewError (final WebView _view, final String _msg) {
		//Put this on OnCreate
		//Code credits to Ann Gabriel
		_view.setWebViewClient(new WebViewClient() { public void onReceivedError(WebView _view, int errorCode, String description, String failingUrl) { 
				_view.loadUrl("data:text/html,<!DOCTYPE><html>".concat(_msg.concat("</html>")));
				 } });
		//Block fixed by MIMachakata
	}
	
	
	@Deprecated
	public void showMessage(String _s) {
		Toast.makeText(getApplicationContext(), _s, Toast.LENGTH_SHORT).show();
	}
	
	@Deprecated
	public int getLocationX(View _v) {
		int _location[] = new int[2];
		_v.getLocationInWindow(_location);
		return _location[0];
	}
	
	@Deprecated
	public int getLocationY(View _v) {
		int _location[] = new int[2];
		_v.getLocationInWindow(_location);
		return _location[1];
	}
	
	@Deprecated
	public int getRandom(int _min, int _max) {
		Random random = new Random();
		return random.nextInt(_max - _min + 1) + _min;
	}
	
	@Deprecated
	public ArrayList<Double> getCheckedItemPositionsToArray(ListView _list) {
		ArrayList<Double> _result = new ArrayList<Double>();
		SparseBooleanArray _arr = _list.getCheckedItemPositions();
		for (int _iIdx = 0; _iIdx < _arr.size(); _iIdx++) {
			if (_arr.valueAt(_iIdx))
			_result.add((double)_arr.keyAt(_iIdx));
		}
		return _result;
	}
	
	@Deprecated
	public float getDip(int _input){
		return TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, _input, getResources().getDisplayMetrics());
	}
	
	@Deprecated
	public int getDisplayWidthPixels(){
		return getResources().getDisplayMetrics().widthPixels;
	}
	
	@Deprecated
	public int getDisplayHeightPixels(){
		return getResources().getDisplayMetrics().heightPixels;
	}
	
}
