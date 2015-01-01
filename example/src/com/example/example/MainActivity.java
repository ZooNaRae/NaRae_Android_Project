package com.example.example;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends Activity{
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    
    public void mOnClick(View target) {
    	Intent intent = null;
    	switch (target.getId()) {
    	case R.id.ListviewBt:
    		intent = new Intent(getApplicationContext(),
        			ListView.class);
    		break;
    	case R.id.CallBt:
    		intent = new Intent(Intent.ACTION_DIAL,Uri.parse("tel:(+82)123456789"));
    		break;
    	case R.id.ActivityBt:
    		intent = new Intent(getApplicationContext(),
        			SubMain.class);
    		break;
    	}  	
    	if(intent != null) {
    		startActivity(intent);
    	}
    }

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// TODO Auto-generated method stub
		super.onCreateOptionsMenu(menu);
		
		MenuItem item = menu.add(0, 1, 0, "고양이1");
		menu.add(0 , 2, 0, "고양이2");
		menu.add(0, 3, 0, "고양이3");
		menu.add(0, 4, 0, "처음 고양이");
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// TODO Auto-generated method stub
		ImageView imageview = (ImageView)findViewById(R.id.Image);
	    Drawable drawcat1, drawcat2, drawcat3, drawcat4;
	    drawcat1 = getResources().getDrawable(R.drawable.catt);
        drawcat2 = getResources().getDrawable(R.drawable.cattt);
        drawcat3 = getResources().getDrawable(R.drawable.ccat);
        drawcat4 = getResources().getDrawable(R.drawable.cat);
		switch (item.getItemId()) {
		case 1:
			Toast.makeText(this, "고양이1을 선택하셨습니다.", Toast.LENGTH_SHORT).show();
			imageview.setImageDrawable(drawcat1);
			break;
		case 2:
			Toast.makeText(this, "고양이2을 선택하셨습니다.", Toast.LENGTH_SHORT).show();
			imageview.setImageDrawable(drawcat2);
			break;
		case 3:
			Toast.makeText(this, "고양이3을 선택하셨습니다.", Toast.LENGTH_SHORT).show();
			imageview.setImageDrawable(drawcat3);
			break;
		case 4:
			Toast.makeText(this, "처음 고양이를 선택하셨습니다.", Toast.LENGTH_SHORT).show();
			imageview.setImageDrawable(drawcat4);
			break;
		}
		return super.onOptionsItemSelected(item);
	}

	@Override
	public void onBackPressed() {
		// TODO Auto-generated method stub
		AlertDialog.Builder builder = new AlertDialog.Builder(this);
		builder.setTitle("종료 확인 대화 상자")
		.setMessage("종료하시겠습니까?")
		.setCancelable(false)
		.setPositiveButton("YES", new DialogInterface.OnClickListener() {
			
			@Override
			public void onClick(DialogInterface dialog, int which) {
				// TODO Auto-generated method stub
				MainActivity.this.finish();
			}
		})
		.setNegativeButton("No", new DialogInterface.OnClickListener() {
			
			@Override
			public void onClick(DialogInterface dialog, int which) {
				// TODO Auto-generated method stub
				dialog.cancel();
			}
		}).show();
		AlertDialog alert = builder.create();
	}	
	
}
