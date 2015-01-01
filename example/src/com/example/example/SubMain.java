package com.example.example;

import java.util.Timer;
import java.util.TimerTask;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Toast;

public class SubMain extends Activity {
	private int a = 0, count = 0, onetwo = 0, temp1 = 0, temp2 = 0, jumsoo = 0, cardcount = 0;
	private Handler handler, handler2;
	private Runnable run1, run2;
	private int[] fb = new int[16];
	private int[] check = new int[16];
	ImageButton[] ib = new ImageButton[16];
	
	class DialogThread extends Thread {
		@Override
		public void run() {
			// TODO Auto-generated method stub
			try {
				Thread.sleep(30000);
				mHandler.sendEmptyMessage(0);
			} catch(Exception e) {
				Toast.makeText(SubMain.this, "에러", Toast.LENGTH_SHORT).show();
			}
		}
	}
	
	Handler mHandler = new Handler() {
		  public void handleMessage(Message msg) {
			  AlertDialog.Builder builder = new AlertDialog.Builder(SubMain.this);
				builder.setTitle("당신의 점수는" + jumsoo + "입니다.")
				.setMessage("끝내시겠습니까?")
				.setCancelable(false)
				.setPositiveButton("YES", new DialogInterface.OnClickListener() {
					
					@Override
					public void onClick(DialogInterface dialog, int which) {
						// TODO Auto-generated method stub
						SubMain.this.finish();
					}
				})
				.setNegativeButton("No", new DialogInterface.OnClickListener() {
					
					@Override
					public void onClick(DialogInterface dialog, int which) {
						// TODO Auto-generated method stub
						dialog.cancel();
						Restart();
					}
				}).show();
				AlertDialog alert = builder.create();
		  }
		 }; 

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub

		super.onCreate(savedInstanceState);
		setContentView(R.layout.submain);
		DialogThread dialogt = new DialogThread();
		dialogt.start();
		Change();
	}
	
	public void Restart() {
		DialogThread dialogt = new DialogThread();
		dialogt.start();
		a = 0; count = 0; onetwo = 0; temp1 = 0; temp2 = 0; cardcount = 0; jumsoo = 0;
		for(int k = 0; k < 16; k++) {
			fb[k] = 0;
		}
		Change();
	}

	public void Change() {
		
		int[] trash = new int[16];

		ib[0] = (ImageButton) findViewById(R.id.bt1);
		ib[1] = (ImageButton) findViewById(R.id.bt2);
		ib[2] = (ImageButton) findViewById(R.id.bt3);
		ib[3] = (ImageButton) findViewById(R.id.bt4);
		ib[4] = (ImageButton) findViewById(R.id.bt5);
		ib[5] = (ImageButton) findViewById(R.id.bt6);
		ib[6] = (ImageButton) findViewById(R.id.bt7);
		ib[7] = (ImageButton) findViewById(R.id.bt8);
		ib[8] = (ImageButton) findViewById(R.id.bt9);
		ib[9] = (ImageButton) findViewById(R.id.bt10);
		ib[10] = (ImageButton) findViewById(R.id.bt11);
		ib[11] = (ImageButton) findViewById(R.id.bt12);
		ib[12] = (ImageButton) findViewById(R.id.bt13);
		ib[13] = (ImageButton) findViewById(R.id.bt14);
		ib[14] = (ImageButton) findViewById(R.id.bt15);
		ib[15] = (ImageButton) findViewById(R.id.bt16);

		for (int i = 0; i <= count;) {
			Random();
			if (count == 0 || count == 1) {
				if (trash[a] == 9999) {
					Random();
				} else {
					ib[a].setImageResource(R.drawable.cat);
					trash[a] = 9999;
					check[a] = 1;
					count++;
					i++;
				}
			} else if (count == 2 || count == 3) {
				if (trash[a] == 9999) {
					Random();
				} else {
					ib[a].setImageResource(R.drawable.catt);
					trash[a] = 9999;
					check[a] = 2;
					count++;
					i++;
				}
			} else if (count == 4 || count == 5) {
				if (trash[a] == 9999) {
					Random();
				} else {
					ib[a].setImageResource(R.drawable.cattt);
					trash[a] = 9999;
					check[a] = 3;
					count++;
					i++;
				}
			} else if (count == 6 || count == 7) {
				if (trash[a] == 9999) {
					Random();
				} else {
					ib[a].setImageResource(R.drawable.ccat);
					trash[a] = 9999;
					check[a] = 4;
					count++;
					i++;
				}
			} else if (count == 8 || count == 9) {
				if (trash[a] == 9999) {
					Random();
				} else {
					ib[a].setImageResource(R.drawable.catone);
					trash[a] = 9999;
					check[a] = 5;
					count++;
					i++;
				}
			} else if (count == 10 || count == 11) {
				if (trash[a] == 9999) {
					Random();
				} else {
					ib[a].setImageResource(R.drawable.cattwo);
					trash[a] = 9999;
					check[a] = 6;
					count++;
					i++;
				}
			} else if (count == 12 || count == 13) {
				if (trash[a] == 9999) {
					Random();
				} else {
					ib[a].setImageResource(R.drawable.catseven);
					trash[a] = 9999;
					check[a] = 7;
					count++;
					i++;
				}
			} else if (count == 14 || count == 15) {
				if (trash[a] == 9999) {
					Random();
				} else {
					ib[a].setImageResource(R.drawable.catsix);
					trash[a] = 9999;
					check[a] = 8;
					count++;
					i++;
				}
			} else {
				break;
			}
			Cover();
		}
	}

	public void Random() {
		a = (int) (Math.random() * 16);
	}

	public void Cover() {
		run1 = new Runnable() {
			@Override
			public void run() {
				// TODO Auto-generated method stub
				for (int j = 0; j < 16; j++) {
					ib[j].setImageResource(R.drawable.hufs);
					ib[j].setEnabled(true);
				}
			}

		};
		handler = new Handler();
		handler.postDelayed(run1, 3000);
		
	}

	public void CheckTo(int z) {
		if (check[z] == 1) {
			ib[z].setImageResource(R.drawable.cat);
			fb[z] = 1;
		} else if (check[z] == 2) {
			ib[z].setImageResource(R.drawable.catt);
			fb[z] = 1;
		} else if (check[z] == 3) {
			ib[z].setImageResource(R.drawable.cattt);
			fb[z] = 1;
		} else if (check[z] == 4) {
			ib[z].setImageResource(R.drawable.ccat);
			fb[z] = 1;
		} else if (check[z] == 5) {
			ib[z].setImageResource(R.drawable.catone);
			fb[z] = 1;
		} else if (check[z] == 6) {
			ib[z].setImageResource(R.drawable.cattwo);
			fb[z] = 1;
		} else if (check[z] == 7) {
			ib[z].setImageResource(R.drawable.catseven);
			fb[z] = 1;
		} else {
			ib[z].setImageResource(R.drawable.catsix);
			fb[z] = 1;
		}
	}

	public void CountCard(int i) {
		if (onetwo == 2) {
			temp2 = check[i];
			for(int j = 0; j < 16; j++) {
				ib[j].setEnabled(false);
			}
			Judgement();
			onetwo = 0;
		} else {
			temp1 = check[i];
		}
	}

	public void Judgement() {
		if(temp1 != temp2){
		run2 = new Runnable() {
			@Override
			public void run() {
				// TODO Auto-generated method stub
				for(int i = 0; i < 16; i++) {
					if(fb[i] == 1) {
						fb[i] = 0;
						ib[i].setImageResource(R.drawable.hufs);
					}
					if(fb[i] != 2) {
						ib[i].setEnabled(true);
					}
				}
			}
		};
		handler2 = new Handler();
		handler2.postDelayed(run2, 1500);	
	} else if(temp1 == temp2){
		jumsoo = jumsoo + 10;
		cardcount++;
		if(cardcount == 8) {
			a = 0; count = 0; onetwo = 0; temp1 = 0; temp2 = 0; cardcount = 0;
			for(int k = 0; k < 16; k++) {
				fb[k] = 0;
			}
			Change();
		}
		for(int i = 0; i < 16; i++) {
			if(fb[i] == 1) {
				fb[i] = 2;
				ib[i].setEnabled(false);
			}
			if(fb[i] != 2) {
				ib[i].setEnabled(true);
			}
		}
	}
}
	
	
	public void mOnClick(View v) {
		switch (v.getId()) {
		case R.id.bt1:
			onetwo++;
			CheckTo(0);
			CountCard(0);
			break;
		case R.id.bt2:
			onetwo++;
			CheckTo(1);
			CountCard(1);
			break;
		case R.id.bt3:
			onetwo++;
			CheckTo(2);
			CountCard(2);
			break;
		case R.id.bt4:
			onetwo++;
			CheckTo(3);
			CountCard(3);
			break;
		case R.id.bt5:
			onetwo++;
			CheckTo(4);
			CountCard(4);
			break;
		case R.id.bt6:
			onetwo++;
			CheckTo(5);
			CountCard(5);
			break;
		case R.id.bt7:
			onetwo++;
			CheckTo(6);
			CountCard(6);
			break;
		case R.id.bt8:
			onetwo++;
			CheckTo(7);
			CountCard(7);
			break;
		case R.id.bt9:
			onetwo++;
			CheckTo(8);
			CountCard(8);
			break;
		case R.id.bt10:
			onetwo++;
			CheckTo(9);
			CountCard(9);
			break;
		case R.id.bt11:
			onetwo++;
			CheckTo(10);
			CountCard(10);
			break;
		case R.id.bt12:
			onetwo++;
			CheckTo(11);
			CountCard(11);
			break;
		case R.id.bt13:
			onetwo++;
			CheckTo(12);
			CountCard(12);
			break;
		case R.id.bt14:
			onetwo++;
			CheckTo(13);
			CountCard(13);
			break;
		case R.id.bt15:
			onetwo++;
			CheckTo(14);
			CountCard(14);
			break;
		case R.id.bt16:
			onetwo++;
			CheckTo(15);
			CountCard(15);
			break;
		}
	}
}