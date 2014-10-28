package com.example.tipcalculator;

import android.app.Activity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnFocusChangeListener;
import android.widget.EditText;

public class MainActivity extends Activity {

	private EditText totalBillEditText;
	private EditText tipEditText;
	private EditText billWithoutTipEditText;
	
	private double tip = 0.15;
	private double billWithoutTip;
	private double totalBill;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		billWithoutTipEditText = (EditText)findViewById(R.id.billWithoutTipEditText);
		billWithoutTipEditText.addTextChangedListener(new TextWatcher() {
			
			@Override
			public void onTextChanged(CharSequence s, int start, int before, int count) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void beforeTextChanged(CharSequence s, int start, int count,
					int after) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void afterTextChanged(Editable arg0) {
				try {
					billWithoutTip = Double.parseDouble(billWithoutTipEditText.getText().toString());
				} catch (NumberFormatException e) {
					billWithoutTip = 0.0;
				}
				
				caculateAndDisplayTotalBill();
			}

		});
		
		tipEditText = (EditText) findViewById(R.id.tipEditText);
		tipEditText.addTextChangedListener(new TextWatcher() {
			
			@Override
			public void onTextChanged(CharSequence s, int start, int before, int count) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void beforeTextChanged(CharSequence s, int start, int count,
					int after) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void afterTextChanged(Editable s) {
				try {
					tip = Double.parseDouble(tipEditText.getText().toString());
				} catch (NumberFormatException e) {
					tip = 0.0;
				}

				caculateAndDisplayTotalBill();
			}
		});
	
		totalBillEditText = (EditText) findViewById(R.id.totalBillEditText);
	}

	public void caculateAndDisplayTotalBill() {
		totalBill = billWithoutTip * (1 +  tip);
		totalBillEditText.setText(String.format("%5.2f", totalBill));
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
}
