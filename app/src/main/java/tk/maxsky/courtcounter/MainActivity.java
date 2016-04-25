/*
 * Copyright (c) 2016 MaxSky.TK. All Rights Reserved.
 */

package tk.maxsky.courtcounter;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {


	int currentTeamA = 0;
	int currentTeamB = 0;
	TextView teamAScore, teamBScore;
	private Button btnThreeA, btnThreeB, btnTwoA, btnTwoB, btnFTA, btnFTB;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		teamAScore = (TextView) findViewById(R.id.score_a);
		teamBScore = (TextView) findViewById(R.id.score_b);

		btnFTA = (Button) findViewById(R.id.btn_free_throw_a);
		btnFTB = (Button) findViewById(R.id.btn_free_throw_b);
		btnThreeA = (Button) findViewById(R.id.btn_3_points_a);
		btnThreeB = (Button) findViewById(R.id.btn_3_points_b);
		btnTwoA = (Button) findViewById(R.id.btn_2_points_a);
		btnTwoB = (Button) findViewById(R.id.btn_2_points_b);

		btnFTA.setOnClickListener(new MyClickListener());
		btnFTB.setOnClickListener(new MyClickListener());
		btnThreeA.setOnClickListener(new MyClickListener());
		btnThreeB.setOnClickListener(new MyClickListener());
		btnTwoA.setOnClickListener(new MyClickListener());
		btnTwoB.setOnClickListener(new MyClickListener());
	}

	private void getThreePoints(int team) {
		if (team == 1) {
			currentTeamA += 3;
			teamAScore.setText("" + currentTeamA);
		} else {
			currentTeamB += 3;
			teamBScore.setText("" + currentTeamB);
		}
	}

	private void getTwoPoints(int team) {
		if (team == 1) {
			currentTeamA += 2;
			teamAScore.setText("" + currentTeamA);
		} else {
			currentTeamB += 2;
			teamBScore.setText("" + currentTeamB);
		}
	}

	private void getFreeThrow(int team) {
		if (team == 1) {
			currentTeamA += 1;
			teamAScore.setText("" + currentTeamA);
		} else {
			currentTeamB += 1;
			teamBScore.setText("" + currentTeamB);
		}
	}

	public void resetScore(View v) {
		teamAScore.setText("" + 0);
		teamBScore.setText("" + 0);
	}

	class MyClickListener implements View.OnClickListener {

		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			switch (v.getId()) {
				case R.id.btn_2_points_a:
					getTwoPoints(1);
					break;
				case R.id.btn_2_points_b:
					getTwoPoints(2);
					break;
				case R.id.btn_3_points_a:
					getThreePoints(1);
					break;
				case R.id.btn_3_points_b:
					getThreePoints(2);
					break;
				case R.id.btn_free_throw_a:
					getFreeThrow(1);
					break;
				case R.id.btn_free_throw_b:
					getFreeThrow(2);
					break;
				default:
					break;
			}
		}
	}
}
