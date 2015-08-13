package com.example.testing;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.Button;

import com.facebook.CallbackManager;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.FacebookSdk;
import com.facebook.share.Sharer;
import com.facebook.share.Sharer.Result;
import com.facebook.share.model.ShareLinkContent;
import com.facebook.share.widget.ShareDialog;

public class MainActivity extends ActionBarActivity {

	CallbackManager callbackManager;
    ShareDialog shareDialog;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		FacebookSdk.sdkInitialize(getApplicationContext());
        callbackManager = CallbackManager.Factory.create();
        shareDialog = new ShareDialog(this);
        // this part is optional
        shareDialog.registerCallback(callbackManager, new FacebookCallback<Sharer.Result>() {

			@Override
			public void onSuccess(Result result) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void onCancel() {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void onError(FacebookException error) {
				// TODO Auto-generated method stub
				
			} 
        	
        	
        	
        });
        
        Button b1 = (Button)findViewById(R.id.button1) ;
        
        b1.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				if (ShareDialog.canShow(ShareLinkContent.class)) {
		            ShareLinkContent linkContent = new ShareLinkContent.Builder()
		                    .setContentTitle("Hello Facebook")
		                    .setContentDescription(
		                            "")
		                    .setContentUrl(Uri.parse("http://developers.facebook.com/android"))
		                    .build();

		            shareDialog.show(linkContent);
		        }
			}
		}) ; 
        
        
	}

	@Override
	protected void onActivityResult(final int requestCode, final int resultCode, final Intent data) {
	    super.onActivityResult(requestCode, resultCode, data);
	    callbackManager.onActivityResult(requestCode, resultCode, data);
	}
}
