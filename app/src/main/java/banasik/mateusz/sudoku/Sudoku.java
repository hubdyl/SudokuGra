package banasik.mateusz.sudoku;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class Sudoku extends Activity implements OnClickListener {
    private static final String TAG = "Sudoku";

	/** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        Button aboutButton = (Button) findViewById(R.id.about_button);
        aboutButton.setOnClickListener(this);
        
        Button newButton = (Button) findViewById(R.id.new_button);
        newButton.setOnClickListener(this);

		Button exitButton = (Button) findViewById(R.id.exit_button);
		exitButton.setOnClickListener(this);
    }

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		super.onCreateOptionsMenu(menu);
		return true;		
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {

		return super.onOptionsItemSelected(item);
	}

	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.about_button:
			startActivity(new Intent(this, About.class));
			break;
		case R.id.new_button:
			openNewGameDialog();
			break;
			case R.id.exit_button:
				finish();
				break;
		}		
	}

	private void openNewGameDialog() {
		new AlertDialog.Builder(this)
			.setTitle(R.string.new_game_title)
			.setItems(R.array.difficulty, new DialogInterface.OnClickListener() {
				public void onClick(DialogInterface dialog, int which) {
					startGame(which);
				}
			})
			.show();
	}

	protected void startGame(int difficulty) {
		Log.d(TAG, "clicked on" + difficulty);
		Intent intent = new Intent(Sudoku.this, Game.class);
		intent.putExtra(Game.KEY_DIFFICULTY, difficulty);
		startActivity(intent);
	}

    @Override
    protected void onPause() {
        super.onPause();

    }

    @Override
    protected void onResume() {
        super.onResume();

    }    
}