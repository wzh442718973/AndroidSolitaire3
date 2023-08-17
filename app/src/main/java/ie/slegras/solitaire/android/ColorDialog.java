package ie.slegras.solitaire.android;

import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.SeekBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.StyleRes;
import androidx.appcompat.app.AlertDialog;

import ie.slegras.solitaire.R;

/**
 *
 * Created by yorek on 12/28/16.
 */
public class ColorDialog extends AlertDialog implements SeekBar.OnSeekBarChangeListener {

    private String mHexColor;


    private OnClickListener mOkResetClickListener = new OnClickListener() {
        @Override
        public void onClick(DialogInterface dialog, int which) {
//            if (which == AlertDialog.BUTTON_POSITIVE) {
//                if (mListener != null) {
//                    if (updateColor(mColorEditView.getText().toString())) {
//                        mListener.onColorSelected(mHexColor);
//                    }
//                }
//            } else if (which == AlertDialog.BUTTON_NEUTRAL) {
//                if (mListener != null) {
//                    mListener.onBackgroundRestore();
//                }
//            }
        }
    };

    Integer bgcolor = null;
    private OnColorSelectedListener mListener;

    @Override
    public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
        int r = colorR.getProgress();
        int g = colorG.getProgress();
        int b = colorB.getProgress();

        bgcolor = Color.argb(255, r, g, b);
        colorBg.setBackgroundColor(bgcolor);
        colorBg.setTextColor(~bgcolor | 0xff000000);
        colorBg.setText("Color: 0x" + String.format("%08X", bgcolor));


    }

    @Override
    public void onStartTrackingTouch(SeekBar seekBar) {

    }

    @Override
    public void onStopTrackingTouch(SeekBar seekBar) {

    }

    public interface OnColorSelectedListener {
        void onColorSelected(String hexColor);
        void onBackgroundRestore();
        void onBitmapChased(Bitmap bitmap);
    }

    public ColorDialog(@NonNull Context context) {
        super(context, R.style.DlgTheme);
        initialize();
    }

    SeekBar colorR, colorG, colorB;
    TextView colorBg;

    private void initialize() {
        setCanceledOnTouchOutside(true);
        final View contentView = LayoutInflater.from(getContext()).inflate(R.layout.dialog_color, null);
        colorR = contentView.findViewById(R.id.color_r);
        colorG = contentView.findViewById(R.id.color_g);
        colorB = contentView.findViewById(R.id.color_b);
        colorBg = contentView.findViewById(R.id.bg_color);

        colorR.setOnSeekBarChangeListener(this);
        colorG.setOnSeekBarChangeListener(this);
        colorB.setOnSeekBarChangeListener(this);


        contentView.findViewById(R.id.cancel).setOnClickListener((view) ->{
            dismiss();
        });

        contentView.findViewById(R.id.ok).setOnClickListener((view)->{
            App app  = (App) getContext().getApplicationContext();
            app.bgColor = bgcolor;
            dismiss();
        });

        contentView.findViewById(R.id.reset).setOnClickListener((view)->{
            App app  = (App) getContext().getApplicationContext();
            app.bgColor = null;
            dismiss();
        });

//        setTitle("BackgroundColor");
        setView(contentView);
//        setButton(AlertDialog.BUTTON_POSITIVE, getContext().getString(android.R.string.ok), mOkResetClickListener);
//        setButton(AlertDialog.BUTTON_NEUTRAL, getContext().getString(R.string.restore), mOkResetClickListener);
    }

    public void setOnColorSelectedListener(OnColorSelectedListener listener) {
        mListener = listener;
    }



}
