package com.example.example;

import android.app.ListActivity;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.ContextThemeWrapper;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ScrollView;
import android.widget.Toast;


public class ListView extends ListActivity {
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		
		String[] values = {"Aplle", "Apricot", "Avocado", "Banana",
				"Blackberry","Blueberry","Cherry","Coconut",
				"Cranberry","cat","dog","Grape Raisin","Honeydew",
				"JackFruit","Lemon","Lime","Mango","Watermelon"};
		
		ArrayAdapter<String> adapter = new ArrayAdapter<String>
		(this, R.layout.listview,R.id.label,values);

		setListAdapter(adapter);
	}
	
	@Override
	protected void onListItemClick(android.widget.ListView l, View v,
			int position, long id) {
		// TODO Auto-generated method stub

		String item = (String)getListAdapter().getItem(position);
		ImageView imageview = (ImageView)findViewById(R.id.listviewImage);
		//Drawable draw = getResources().getDrawable(R.drawable.heart);
		imageview.setImageResource(R.drawable.heart);
		Toast.makeText(this,"현재 포지션 : " + position + "//" + item + "을 선택하셨습니다.", Toast.LENGTH_SHORT).show();
	
	}
}