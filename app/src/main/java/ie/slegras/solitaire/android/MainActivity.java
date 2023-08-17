package ie.slegras.solitaire.android;

import android.content.DialogInterface;
import android.graphics.Rect;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.FragmentManager;
import androidx.core.view.MotionEventCompat;
import androidx.appcompat.app.AppCompatActivity;

import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.Window;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;
import java.io.StreamCorruptedException;

import ie.slegras.solitaire.R;
import ie.slegras.solitaire.model.Game;
import ie.slegras.solitaire.view.Panel;

public class MainActivity extends AppCompatActivity {
    private float x;
    private float y;
    private Panel panel;
    private Game game;


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu, menu);

        try{
            MenuItem version = menu.findItem(R.id.action_version);
            version.setTitle("version:" + getPackageManager().getPackageInfo(getPackageName(), 0).versionName);
        }catch (Throwable e){

        }
        return true;
    }

    @Override
    public void onBackPressed() {
//        super.onBackPressed();
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        final int menuId = item.getItemId();
        if(menuId == R.id.action_restart){
            createAndShowAlertDialog();
        }else if(menuId == R.id.action_exit){
            AlertDialog dlg = new AlertDialog.Builder(this, R.style.DlgTheme).setTitle(R.string.exit_app).setMessage(R.string.exit_confirm).setPositiveButton(android.R.string.ok, new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    finish();
                    System.exit(0);
                }
            }).setNegativeButton(android.R.string.no, new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    dialog.dismiss();
                }
            }).create();
            dlg.show();
        }else if(menuId == R.id.action_setting){
            ColorDialog dlg = new ColorDialog(this);
            dlg.setOnDismissListener(new DialogInterface.OnDismissListener() {
                @Override
                public void onDismiss(DialogInterface dialog) {
                    panel.invalidate();
                }
            });
            dlg.show();
        }
        return true;
    }

    @Override
    public boolean onTouchEvent(MotionEvent e) {
        int action = MotionEventCompat.getActionMasked(e);

        if (action == MotionEvent.ACTION_DOWN) {
            x = e.getX();
            y = e.getY();

            //compute touch param
            float width = panel.getRealWidth();
            float height = panel.getRealHeight();
            float xMinNew = width - height / 8.0f;
            float yMinNew = height - height / 8.0f;
//            if (x > xMinNew && y > yMinNew) {
//                createAndShowAlertDialog();
//                return false;
//            }

            panel.receiveTouchEvent(x, y);
            setContentView(panel);
            return false;
        } else if (action == MotionEvent.ACTION_MOVE) {
            x = e.getX();
            y = e.getY();

            Rect rect = new Rect();
            Window win = getWindow();
            win.getDecorView().getWindowVisibleDisplayFrame(rect);
            int statusBarHeight = rect.top;
            int contentViewTop = win.findViewById(Window.ID_ANDROID_CONTENT).getTop();
            int titleBarHeight = contentViewTop - statusBarHeight;

            panel.receiveMovingEvent(x, y - titleBarHeight - statusBarHeight);
            setContentView(panel);
            return false;
        } else if (action == MotionEvent.ACTION_UP) {
            panel.receiveStopEvent(x, y);
            setContentView(panel);
            return false;
        }

        return true;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //initialize game
        game = new Game();
        game.initGame();

        //draw the game
        panel = new Panel(getApplicationContext(), null);
        panel.setGame(game);
        setContentView(panel);
    }

    @Override
    public void onPause() {
        super.onPause();
        if (panel != null) {
            Game gameToSave = panel.getGame();
            write(gameToSave);
        }
    }

    @Override
    public void onResume() {
        super.onResume();

        Game gameLoaded = read();
        if (gameLoaded != null) {
            panel.setGame(gameLoaded);
            setContentView(panel);
        }
    }

    private void createAndShowAlertDialog() {
        FragmentManager fragmentManager = getSupportFragmentManager();
        CustomDialogBox customDialog = new CustomDialogBox();
        customDialog.setCancelable(false);
        customDialog.show(fragmentManager, "Custom Dialog");
    }

    public void customDialogYes() {
        game = new Game();
        game.initGame();
        panel.setGame(game);
        setContentView(panel);
    }

    private void write(Game game){
        if (panel != null) {
            String filename = "savingGame.srl";
            ObjectOutput out = null;

            try {
                out = new ObjectOutputStream(new FileOutputStream(new File(getFilesDir(),"") + File.separator + filename));
                out.writeObject(game);
                out.close();
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public Game read(){
        ObjectInputStream input;
        String filename = "savingGame.srl";

        try {
            input = new ObjectInputStream(new FileInputStream(new File(new File(getFilesDir(),"")+File.separator+filename)));
            Game game = (Game) input.readObject();
            input.close();
            return game;
        } catch (StreamCorruptedException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }
}
