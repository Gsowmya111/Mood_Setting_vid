package edison.vidya.mood_setting;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.SeekBar;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import edison.vidya.mood_setting.dimmerExternalLibrary.ShaderSeekArc;

import static edison.vidya.mood_setting.DatabaseHelper.MOOD_TYPE;
import static edison.vidya.mood_setting.DatabaseHelper.TABLE_NAME;
import static edison.vidya.mood_setting.DisplayAdapter.dataa;
import static edison.vidya.mood_setting.DisplayAdapter.devicenumber;
import static edison.vidya.mood_setting.DisplayAdapter.moood_type;
import static edison.vidya.mood_setting.DisplayAdapter.number;
import static edison.vidya.mood_setting.DisplayAdapter.switch1_namee;
import static edison.vidya.mood_setting.ListActivity.device_type;

public class MainActivity extends AppCompatActivity {
    private static final String TAG1 = "ShaderSeekArc";
    ShaderSeekArc seekArc;
    ImageView image_dimmer;
    Button setings;
    Button mood1, mood2, mood3;
    Button flash, fade, strobe, smooth;
    TextView tvspeed;
    SeekBar brightness;
    View alertLayout;
    Button colorview;
    int color_bright;
    Object fsfs_speed, tvspeed1, color_fsfs;
    Integer rrr, ggg, bbb;
    private Button save, cancel, btopen, btstop, btclose, btopen_sheer, btclose_sheer, btstop_sheer, btopen_curtain, btclose_curtain, btstop_curtain;
    private String fsfs;
    private String devnum;
    List ar_num_switch = new ArrayList();
    List ar_off_data = new ArrayList();
    List ar_on_data = new ArrayList();
    private String rrrr, gggg, bbbb;
    DatabaseHelper db = null;
    private String status;
    private String data;
    static String mood_num;
    static String mood_type;
    Button s1, s2, s3, s4, s5, fan_dec, fan_inc, fan;
    Spinner fan_speed;
    private String fanspeed;
    ArrayList<Object> bulbon;
    private String sone, stwo;
    private String num_switch;
    private String off_data;
    private String on_data;
    private String device_name;
    private String device_num;
    SQLiteDatabase dataBase;
    private ArrayList<String> anum = new ArrayList<String>();
    private ArrayList<String> ahousenum = new ArrayList<String>();
    private ArrayList<String> ahousename = new ArrayList<String>();
    private ArrayList<String> aroomnum = new ArrayList<String>();
    private ArrayList<String> adevicenum = new ArrayList<String>();
    private ArrayList<String> adevicename = new ArrayList<String>();
    private ArrayList<String> aswitch1 = new ArrayList<String>();
    private ArrayList<String> astatus = new ArrayList<String>();
    private ArrayList<String> adata = new ArrayList<String>();
    private ArrayList<String> amood_type = new ArrayList<String>();
    private String one, two;
    private String col_num, house_number, house_names, room_number, devicee_num, devicee_name, switch_nam, status_display, moood_type;
    private DatabaseHelper db2;
    private String two2, two3;
    private Cursor mCursor;

    private String d4;
    private String cur_status;
    private String cur_type;
    private String curtain_status, curtain_type;
    private String dataa;
    private Button ac_tb;
    private String ac_data;
    private String pro_status;
    private Button btn_low, btn_hign, btn_medium;
    private int dimer;
    private String dimerval;
    private int check2,check3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        db = new DatabaseHelper(MainActivity.this);
        db.getWritableDatabase();

        mood1 = (Button) findViewById(R.id.mood1);
        mood2 = (Button) findViewById(R.id.mood2);
        mood3 = (Button) findViewById(R.id.mood3);

        if (device_type.equals("rgb")) {
            device_num = "1";
            mood1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    mood_num = "1";
                    mood_type = "rmood1";
                    rgb();
                }
            });
            mood2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    mood_num = "2";
                    mood_type = "rmood2";
                    rgb();
                }
            });
            mood3.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    mood_num = "3";
                    mood_type = "rmood3";
                    rgb();
                }
            });
        } else if (device_type.equals("switch21")) {
            device_num = "2";
            mood1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    mood_num = "1";
                    mood_type = "smood1";
                    switch21();
                }
            });
            mood2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    mood_num = "2";
                    mood_type = "smood2";
                    switch21();
                }
            });
            mood3.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    mood_num = "3";
                    mood_type = "smood3";
                    switch21();
                }
            });
        } else if (device_type.equals("switch51")) {
            mood1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    mood_num = "1";
                    mood_type = "ssmood1";
                    switch51();
                }
            });
            mood2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    mood_num = "2";
                    mood_type = "ssmood2";
                    switch51();
                }
            });
            mood3.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    mood_num = "3";
                    mood_type = "ssmood3";
                    switch51();
                }
            });
        } else if (device_type.equals("dimmer")) {
            device_num = "3";
            mood1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    mood_num = "1";
                    mood_type = "dmood1";
                    dimmer();
                }
            });
            mood2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    mood_num = "2";
                    mood_type = "dmood2";
                    dimmer();
                }
            });
            mood3.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    mood_num = "3";
                    mood_type = "dmood3";
                    dimmer();
                }
            });
        } else if (device_type.equals("curtain")) {
            device_num = "3";
            mood1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    mood_num = "1";
                    mood_type = "cmood1";
                    curtain();
                }
            });
            mood2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    mood_num = "2";
                    mood_type = "cmood2";
                    curtain();
                }
            });
            mood3.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    mood_num = "3";
                    mood_type = "cmood3";
                    curtain();
                }
            });
        } else if (device_type.equals("ac")) {
            device_num = "4";
            mood1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    mood_num = "1";
                    mood_type = "acmood1";
                    ac();
                }
            });
            mood2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    mood_num = "2";
                    mood_type = "acmood2";
                    ac();
                }
            });
            mood3.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    mood_num = "3";
                    mood_type = "acmood3";
                    ac();
                }
            });
        } else if (device_type.equals("bell")) {
            device_num = "5";
            mood1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    mood_num = "1";
                    mood_type = "bellmood1";
                    bell();
                }
            });
            mood2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    mood_num = "2";
                    mood_type = "bellmood2";
                    bell();
                }
            });
            mood3.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    mood_num = "3";
                    mood_type = "bellmood3";
                    bell();
                }
            });
        } else if (device_type.equals("dog")) {
            device_num = "6";
            mood1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    mood_num = "1";
                    mood_type = "dogmood1";
                    dog();
                }
            });
            mood2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    mood_num = "2";
                    mood_type = "dogmood2";
                    dog();
                }
            });
            mood3.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    mood_num = "3";
                    mood_type = "dogmood3";
                    dog();
                }
            });
        } else if (device_type.equals("geyser")) {
            device_num = "7";
            mood1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    mood_num = "1";
                    mood_type = "geymood1";
                    geyser();
                }
            });
            mood2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    mood_num = "2";
                    mood_type = "geymood2";
                    geyser();
                }
            });
            mood3.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    mood_num = "3";
                    mood_type = "geymood3";
                    geyser();
                }
            });
        } else if (device_type.equals("sprinkler")) {
            device_num = "8";
            mood1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    mood_num = "1";
                    mood_type = "sprimood1";
                    sprinkler();
                }
            });
            mood2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    mood_num = "2";
                    mood_type = "sprimood2";
                    sprinkler();
                }
            });
            mood3.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    mood_num = "3";
                    mood_type = "sprimood3";
                    sprinkler();
                }
            });
        } else if (device_type.equals("doorlock")) {
            device_num = "9";
            mood1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    mood_num = "1";
                    mood_type = "dlckmood1";
                    doorlock();
                }
            });
            mood2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    mood_num = "2";
                    mood_type = "dlckmood2";
                    doorlock();
                }
            });
            mood3.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    mood_num = "3";
                    mood_type = "dlckmood3";
                    doorlock();
                }
            });
        } else if (device_type.equals("projector")) {
            device_num = "10";
            mood1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    mood_num = "1";
                    mood_type = "promood1";
                    projector();
                }
            });
            mood2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    mood_num = "2";
                    mood_type = "promood2";
                    projector();
                }
            });
            mood3.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    mood_num = "3";
                    mood_type = "promood3";
                    projector();
                }
            });
        }
    }

    private void dimmer() {
        device_name = "Dimmer";
        final LayoutInflater inflater1 = getLayoutInflater();
        alertLayout = inflater1.inflate(R.layout.dimmer_popup_moodlist, null);
        AlertDialog.Builder alert = new AlertDialog.Builder(MainActivity.this);

        alert.setView(alertLayout);
        alert.setCancelable(true);
        final AlertDialog dialog1 = alert.create();
        dialog1.show();
        int width = (int) (getResources().getDisplayMetrics().widthPixels * 0.60);
        int height = (int) (getResources().getDisplayMetrics().heightPixels * 0.40);
        dialog1.getWindow().setLayout(width, height);
        dialog1.show();

        // setings= (Button) findViewById(R.id.settings);
        seekArc = (ShaderSeekArc) alertLayout.findViewById(R.id.seek_arc);
        image_dimmer = (ImageView) alertLayout.findViewById(R.id.image1);
        save = (Button) alertLayout.findViewById(R.id.save_dimmer);
        cancel = (Button) alertLayout.findViewById(R.id.cancel);
        btn_hign = (Button) alertLayout.findViewById(R.id.dimmer_high_brigtns);
        btn_low = (Button) alertLayout.findViewById(R.id.dimmer_low_brigtns);
        btn_medium = (Button) alertLayout.findViewById(R.id.dimmer_medium_brigtns);
        Button mood_list = (Button) alertLayout.findViewById(R.id.mood_list);
        image_dimmer.setImageResource(R.drawable.b1);
        btn_hign.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                image_dimmer.setImageResource(R.drawable.b9);
                dimer = 255;
            }
        });


        btn_low.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                image_dimmer.setImageResource(R.drawable.b1);
                dimer = 3;
            }
        });

        btn_medium.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                image_dimmer.setImageResource(R.drawable.b3);
                dimer = 40;
            }
        });

        seekArc.setOnSeekArcChangeListener(new ShaderSeekArc.OnSeekArcChangeListener() {

            @Override
            public void onProgressChanged(ShaderSeekArc seekArc, float progress) {

                if (seekArc.getProgress() >= 1 && seekArc.getProgress() < 2) {
                    image_dimmer.setImageResource(R.drawable.b1);
                    dimer = 3;


                }
                if (seekArc.getProgress() >= 2 && seekArc.getProgress() < 3) {
                    image_dimmer.setImageResource(R.drawable.b2);
                    dimer = 40;

                }
                if (seekArc.getProgress() >= 3 && seekArc.getProgress() < 4) {
                    image_dimmer.setImageResource(R.drawable.b3);
                    dimer = 75;

                }
                if (seekArc.getProgress() >= 4 && seekArc.getProgress() < 5) {
                    image_dimmer.setImageResource(R.drawable.b4);
                    dimer = 103;
                }
                if (seekArc.getProgress() >= 5 && seekArc.getProgress() < 6) {
                    image_dimmer.setImageResource(R.drawable.b5);
                    dimer = 140;

                }
                if (seekArc.getProgress() >= 6 && seekArc.getProgress() < 7) {
                    image_dimmer.setImageResource(R.drawable.b6);
                    dimer = 169;

                }
                if (seekArc.getProgress() >= 7 && seekArc.getProgress() < 8) {
                    image_dimmer.setImageResource(R.drawable.b7);
                    dimer = 180;

                }
                if (seekArc.getProgress() >= 8 && seekArc.getProgress() <= 9) {
                    image_dimmer.setImageResource(R.drawable.b8);
                    dimer = 200;

                }

                if (seekArc.getProgress() >= 9 && seekArc.getProgress() <= 10) {
                    image_dimmer.setImageResource(R.drawable.b9);
                    dimer = 255;

                }

                Log.d("TAG", "progress " + progress);
            }

            @Override
            public void onStartTrackingTouch(ShaderSeekArc seekArc) {
                Log.d("TAG", "onStartTrackingTouch");
            }

            @Override
            public void onStopTrackingTouch(ShaderSeekArc seekArc) {
                Log.d("TAG", "onStopTrackingTouch");
            }
        });


        ////////////
        dataBase = db.getWritableDatabase();
        //the SQL command to fetched all records from the table
        mCursor = dataBase.rawQuery("SELECT * FROM " + TABLE_NAME, null);
        //reset variables
        anum.clear();
        ahousenum.clear();
        ahousename.clear();
        aroomnum.clear();
        adevicename.clear();
        adevicenum.clear();
        aswitch1.clear();
        astatus.clear();
        adata.clear();
        amood_type.clear();


        if (mCursor.getCount() > 0) {
            //fetch each record
            if (mCursor.moveToFirst()) {
                do {
                    if (mood_num.equals("1")) {
                        if (mCursor.getString(mCursor.getColumnIndex(MOOD_TYPE)).equals("dmood1")) {
                            dimmer_status();
                        }
                    } else if (mood_num.equals("2")) {
                        if (mCursor.getString(mCursor.getColumnIndex(MOOD_TYPE)).equals("dmood2")) {
                            dimmer_status();
                        }
                    } else if (mood_num.equals("3")) {

                        if (mCursor.getString(mCursor.getColumnIndex(MOOD_TYPE)).equals("dmood3")) {
                            dimmer_status();
                        }
                    }
                } while (mCursor.moveToNext());
                db.close();
            }
            //do above till data exhausted
            mCursor.close();
            //  }
        } else {

            // insert();
        }

        mood_list.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, DisplayList.class);
                startActivity(i);
                finish();

            }
        });


        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DatabaseHelper db2 = new DatabaseHelper(view.getContext());
                db2.getWritableDatabase();

                if (dimer > 0 && dimer < 9) {
                    dimerval = "00" + dimer;
                } else if (dimer > 9 && dimer < 99) {
                    dimerval = "0" + dimer;
                } else if (dimer > 99) {
                    dimerval = String.valueOf(dimer);
                }
                data = dimerval;

                dataBase = db.getWritableDatabase();
                mCursor = dataBase.rawQuery("SELECT * FROM " + TABLE_NAME, null);
                mCursor = dataBase.rawQuery("SELECT * FROM MoodSetTable WHERE MOOD_TYPE='" + mood_type + "'", null);
                Boolean rowExists;

                if (mCursor.moveToFirst()) {
                    db2.updateData(col_num, "1", "abcd", "1", switch_nam, devicee_name, devicee_num, "ON", data, moood_type);
                } else {
                    if (data != null) {
                        insert();
                    } else {
                        Toast.makeText(MainActivity.this, "Please set data", Toast.LENGTH_LONG).show();
                    }
                }

                dialog1.dismiss();


            }
        });
    }


    public void switch21() {

        device_name = "Switch21";
        final LayoutInflater inflater1 = getLayoutInflater();
        alertLayout = inflater1.inflate(R.layout.mood_switch21, null);
        AlertDialog.Builder alert = new AlertDialog.Builder(MainActivity.this, R.style.MyDialogTheme1);

        alert.setView(alertLayout);
        alert.setCancelable(true);
        final AlertDialog dialog1 = alert.create();
        dialog1.show();
        Button mood_list = (Button) alertLayout.findViewById(R.id.mood_list);

        s1 = (Button) alertLayout.findViewById(R.id.s1);
        s2 = (Button) alertLayout.findViewById(R.id.s2);
        fan = (Button) alertLayout.findViewById(R.id.fan);
        fan_speed = (Spinner) alertLayout.findViewById(R.id.fan_speed);
        //  TextView tvv = (TextView) alertLayout1.findViewById(R.id.tv);
        save = (Button) alertLayout.findViewById(R.id.save);
        cancel = (Button) alertLayout.findViewById(R.id.cancel);

        final String[] str = {"0", "1", "2", "3", "4", "5"};
        ArrayAdapter<String> adp2 = new ArrayAdapter<>(alertLayout.getRootView().getContext(), R.layout.spinner_item, str);
        adp2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        fan_speed.setAdapter(adp2);
        bulbon = new ArrayList<>();
        s1.setTag(0);
        s2.setTag(0);
        fan.setTag(0);
///////////////////////////////////////////////////////////////
        dataBase = db.getWritableDatabase();
        //the SQL command to fetched all records from the table
        mCursor = dataBase.rawQuery("SELECT * FROM " + TABLE_NAME, null);
        //reset variables
        anum.clear();
        ahousenum.clear();
        ahousename.clear();
        aroomnum.clear();

        adevicename.clear();
        adevicenum.clear();
        aswitch1.clear();
        astatus.clear();
        adata.clear();
        amood_type.clear();


        if (mCursor.getCount() > 0) {
            //fetch each record
            if (mCursor.moveToFirst()) {
                //mCursor.moveToFirst();
                do {
                    if (mood_num.equals("1")) {
                        //  mCursor = db.getData("mood1");
                        if (mCursor.getString(mCursor.getColumnIndex(MOOD_TYPE)).equals("smood1")) {
                            switch21_status();
                            //data = ar_num_switch + ";" + on_data;
                            // db2.updateData(aaanum,"1","abcd","1",aaaswitch1,aaadevicename,aaadevicenum,"ON",data,aaamood_type);
                        }
                    } else if (mood_num.equals("2")) {
                        //  mCursor = db.getData("mood1");
                        if (mCursor.getString(mCursor.getColumnIndex(MOOD_TYPE)).equals("smood2")) {
                            switch21_status();
                            //data = ar_num_switch + ";" + on_data;
                            // db2.updateData(aaanum,"1","abcd","1",aaaswitch1,aaadevicename,aaadevicenum,"ON",data,aaamood_type);
                        }
                    } else if (mood_num.equals("3")) {
                        //  mCursor = db.getData("mood1");
                        if (mCursor.getString(mCursor.getColumnIndex(MOOD_TYPE)).equals("smood3")) {
                            switch21_status();
                            //data = ar_num_switch + ";" + on_data;
                            // db2.updateData(aaanum,"1","abcd","1",aaaswitch1,aaadevicename,aaadevicenum,"ON",data,aaamood_type);
                        }
                    }
                } while (mCursor.moveToNext());
                db.close();
            }
            //do above till data exhausted
            mCursor.close();
            //  }
        } else {


        }

////////////////////////////////////////////////////////////////////////////////////
        s1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (view.getTag().equals(0)) {
                    s1.setBackgroundResource(R.drawable.bulb02);
                    view.setTag(1);
                    s1.setTag(1);
                    sone = "201";
                    bulbon.add(sone);
                } else {
                    s1.setBackgroundResource(R.drawable.bulb01);
                    view.setTag(0);
                    s1.setTag(0);
                    //switch_onoff="301";
                    bulbon.remove(sone);
                }
                //  Log.d("TAG",switch_onoff);
                Log.d("TAG", String.valueOf(bulbon));
            }
        });

        s2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (view.getTag().equals(0)) {
                    s2.setBackgroundResource(R.drawable.bulb02);
                    view.setTag(1);
                    s2.setTag(1);
                    stwo = "202";
                    bulbon.add(stwo);
                } else {
                    s2.setBackgroundResource(R.drawable.bulb01);
                    view.setTag(0);
                    s2.setTag(0);
                    //switch_onoff="302";
                    bulbon.remove(stwo);
                }
                //   Log.d("TAG",switch_onoff);
                Log.d("TAG", String.valueOf(bulbon));

            }
        });
        fan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (view.getTag().equals(0)) {
                    fan.setBackgroundResource(R.drawable.fan02);
                    view.setTag(1);
                    fan.setTag(1);
                    //sone="201";
                    // bulbon.add(sone);
                } else {
                    fan.setBackgroundResource(R.drawable.fan01);
                    view.setTag(0);
                    fan.setTag(0);
                    //switch_onoff="301";
                    // bulbon.remove(sone);
                }
                //  Log.d("TAG",switch_onoff);
                Log.d("TAG", String.valueOf(bulbon));
            }
        });

        fan_speed.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                if (i == 0) {
                    fanspeed = "0";
                    //  bulbon.add("0");
                } else if (i == 1) {
                    fanspeed = "1";
                    bulbon.add("71");
                } else if (i == 2) {
                    fanspeed = "2";
                    bulbon.add("71");
                } else if (i == 3) {
                    fanspeed = "3";
                    bulbon.add("71");
                } else if (i == 4) {
                    fanspeed = "4";
                    bulbon.add("71");
                } else if (i == 5) {
                    fanspeed = "5";
                    bulbon.add("71");
                }
                Log.d("TAG", fanspeed);
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
            }
        });
        mood_list.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, DisplayList.class);
                startActivity(i);
                finish();

            }
        });


        ar_num_switch.clear();
        ar_off_data.clear();
        ar_on_data.clear();
        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DatabaseHelper db2 = new DatabaseHelper(view.getContext());
                db2.getWritableDatabase();
                if (bulbon != null && bulbon.size() > 0) {
                    for (Object area : bulbon) {
                        if (area.equals("201")) {
                            num_switch = "1";
                            off_data = "301";
                             ar_num_switch.add(1);
                            ar_off_data.add("001000000101" + off_data + "000000000000000");
                               } else if (area.equals("202")) {
                            num_switch = "2";
                            off_data = "302";
                            ar_num_switch.add(num_switch);
                            ar_off_data.add("001000000101" + off_data + "000000000000000");
                               } else if (area.equals("71")) {
                            if (ar_num_switch.contains("98")) {
                                on_data = fanspeed;
                            } else {
                                num_switch = "98";
                                off_data = "723";
                                on_data = fanspeed;

                                ar_num_switch.add(num_switch);
                                ar_off_data.add("001000000101" + off_data + "000000000000000");
                                ar_on_data.add(on_data);
                            }
                        }
                    }
                    //fsfs="0";
                    if (on_data != null) {
                        data = ar_num_switch + ";" + on_data;
                    } else {
                        on_data = "0";
                        data = ar_num_switch + ";" + on_data;
                    }
                    dataBase = db.getWritableDatabase();
                    mCursor = dataBase.rawQuery("SELECT * FROM " + TABLE_NAME, null);
                    mCursor = dataBase.rawQuery("SELECT * FROM MoodSetTable WHERE MOOD_TYPE='" + mood_type + "'", null);
                    Boolean rowExists;

                    if (mCursor.moveToFirst()) {
                        db2.updateData(col_num, "1", "abcd", "1", switch_nam, devicee_name, devicee_num, "ON", data, moood_type);

                    } else {
                        if (data != null) {
                            insert();
                        } else {
                            Toast.makeText(MainActivity.this, "Please set data", Toast.LENGTH_LONG).show();
                        }
                    }
                } else {
                    Toast.makeText(view.getContext(), "Set operation", Toast.LENGTH_LONG).show();
                }
                dialog1.dismiss();

            }


        });
        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog1.dismiss();

            }
        });

        int width = (int) (getResources().getDisplayMetrics().widthPixels * 0.70);
        int height = (int) (getResources().getDisplayMetrics().heightPixels * 0.35);
        dialog1.getWindow().setLayout(width, height);
        dialog1.show();

    }

    private void switch21_status() {

        col_num = mCursor.getString(mCursor.getColumnIndex(DatabaseHelper.COLUMN_NO));

        house_number = mCursor.getString(mCursor.getColumnIndex(DatabaseHelper.HOUSE_NUM));
        house_names = mCursor.getString(mCursor.getColumnIndex(DatabaseHelper.HOUSE_NAME));
        room_number = mCursor.getString(mCursor.getColumnIndex(DatabaseHelper.ROOM_NUM));

        devicee_name = mCursor.getString(mCursor.getColumnIndex(DatabaseHelper.DEVICE_TYPE));
        devicee_num = mCursor.getString(mCursor.getColumnIndex(DatabaseHelper.DEVICE_NUM));
        switch_nam = mCursor.getString(mCursor.getColumnIndex(DatabaseHelper.SETTING_NUM));
        status_display = mCursor.getString(mCursor.getColumnIndex(DatabaseHelper.STATUS));
        adata.add(mCursor.getString(mCursor.getColumnIndex(DatabaseHelper.DATA)));
        moood_type = mCursor.getString(mCursor.getColumnIndex(MOOD_TYPE));
        String ondat = String.valueOf(adata);

        String splitTime[] = ondat.split(";");
        one = splitTime[0];
        two = splitTime[1];
        String splitTime2[] = two.split("]");
        two2 = splitTime2[0];
        //switch21_display_status();


        int a = one.length();
        if (one.length() == 4 && one.contains("1")) {
            s1.setBackgroundResource(R.drawable.bulb02);
            s1.setTag(1);
            sone = "201";
            bulbon.add(sone);

        } else if (one.length() == 4 && one.contains("2")) {
            s2.setBackgroundResource(R.drawable.bulb02);
            s2.setTag(1);
            stwo = "202";
            bulbon.add(stwo);

        } else if (one.length() == 5 && one.contains("98")) {
            bulbon.add("71");
            set_fan_speed();
        } else if (one.length() == 11 && one.contains("1") && one.contains("2") && one.contains("98")) {
            s1.setBackgroundResource(R.drawable.bulb02);
            s2.setBackgroundResource(R.drawable.bulb02);
            s1.setTag(1);
            s2.setTag(1);
            sone = "201";
            stwo = "202";
            bulbon.add(sone);
            bulbon.add(stwo);
            bulbon.add("71");
            set_fan_speed();

        } else if (one.length() == 7 && one.contains("1") && one.contains("2")) {
            s1.setBackgroundResource(R.drawable.bulb02);
            s2.setBackgroundResource(R.drawable.bulb02);
            sone = "201";
            stwo = "202";
            bulbon.add(sone);
            bulbon.add(stwo);
            s1.setTag(1);
            s2.setTag(1);
        } else if (one.length() == 8 && one.contains("1") && one.contains("98")) {
            s1.setBackgroundResource(R.drawable.bulb02);
            s1.setTag(1);
            sone = "201";
            bulbon.add(sone);
            bulbon.add("71");
            set_fan_speed();

        } else if (one.length() == 8 && one.contains("2") && one.contains("98")) {
            s2.setBackgroundResource(R.drawable.bulb02);
            stwo = "202";
            s2.setTag(1);
            bulbon.add("71");
            bulbon.add(stwo);
            set_fan_speed();

        } else {

        }
    }


    private void set_fan_speed() {
        if (two2.equals("0")) {
            fan_speed.setSelection(0);
            fan.setBackgroundResource(R.drawable.fan01);
        } else if (two2.equals("1")) {
            fan_speed.setSelection(1);
            fan.setBackgroundResource(R.drawable.fan02);
        } else if (two2.equals("2")) {
            fan_speed.setSelection(2);
            fan.setBackgroundResource(R.drawable.fan02);
        } else if (two2.equals("3")) {
            fan.setBackgroundResource(R.drawable.fan02);
            fan_speed.setSelection(3);
        } else if (two2.equals("4")) {
            fan.setBackgroundResource(R.drawable.fan02);
            fan_speed.setSelection(4);
        } else if (two2.equals("5")) {
            fan.setBackgroundResource(R.drawable.fan02);
            fan_speed.setSelection(5);
        }
    }

    ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    private void switch51() {
        final LayoutInflater inflater1 = getLayoutInflater();
        alertLayout = inflater1.inflate(R.layout.mood_switch51, null);
        AlertDialog.Builder alert = new AlertDialog.Builder(MainActivity.this, R.style.MyDialogTheme1);

        alert.setView(alertLayout);
        alert.setCancelable(true);
        final AlertDialog dialog1 = alert.create();
        dialog1.show();
        int width = (int) (getResources().getDisplayMetrics().widthPixels * 0.80);
        int height = (int) (getResources().getDisplayMetrics().heightPixels * 0.50);
        dialog1.getWindow().setLayout(width, height);
        dialog1.show();

    }

    ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    public void rgb() {
        device_name = "RGB";
        fsfs = null;
        rrrr = null;
        gggg = null;
        bbbb = null;
        fsfs_speed = null;

        final LayoutInflater inflater1 = getLayoutInflater();
        alertLayout = inflater1.inflate(R.layout.rgb_popup, null);
        AlertDialog.Builder alert = new AlertDialog.Builder(MainActivity.this, R.style.MyDialogTheme1);

        alert.setView(alertLayout);
        alert.setCancelable(true);
        final AlertDialog dialog1 = alert.create();
        dialog1.show();
        Button c1 = (Button) alertLayout.findViewById(R.id.c1);
        Button c2 = (Button) alertLayout.findViewById(R.id.c2);
        Button c3 = (Button) alertLayout.findViewById(R.id.c3);
        Button c4 = (Button) alertLayout.findViewById(R.id.c4);
        Button c5 = (Button) alertLayout.findViewById(R.id.c5);
        Button c6 = (Button) alertLayout.findViewById(R.id.c6);
        Button c7 = (Button) alertLayout.findViewById(R.id.c7);
        Button c8 = (Button) alertLayout.findViewById(R.id.c8);
        Button c9 = (Button) alertLayout.findViewById(R.id.c9);
        Button c10 = (Button) alertLayout.findViewById(R.id.c10);
        Button c11 = (Button) alertLayout.findViewById(R.id.c11);
        Button c12 = (Button) alertLayout.findViewById(R.id.c12);
        Button mood_list = (Button) alertLayout.findViewById(R.id.mood_list);

        save = (Button) alertLayout.findViewById(R.id.save);
        cancel = (Button) alertLayout.findViewById(R.id.cancel);
        colorview = (Button) alertLayout.findViewById(R.id.colorview);

        final Button btup = (Button) alertLayout.findViewById(R.id.up);
        final Button btdown = (Button) alertLayout.findViewById(R.id.down);
        tvspeed = (TextView) alertLayout.findViewById(R.id.tvspeed);
        brightness = (SeekBar) alertLayout.findViewById(R.id.brightness);
        flash = (Button) alertLayout.findViewById(R.id.flash);
        strobe = (Button) alertLayout.findViewById(R.id.strobe);
        fade = (Button) alertLayout.findViewById(R.id.fade);
        smooth = (Button) alertLayout.findViewById(R.id.smooth);
        brightness.setMax(10);

        brightness.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {

            @Override
            public void onProgressChanged(SeekBar seekBar, int progress,
                                          boolean fromUser) {

                // colorview.setText(String.valueOf(progress));

                if (progress == 1) {
                    color_bright = 131;
                } else if (progress == 2) {
                    color_bright = 132;
                } else if (progress == 3) {
                    color_bright = 133;
                    // colorview.setText(String.valueOf(color_bright));
                } else if (progress == 4) {
                    color_bright = 134;
                } else if (progress == 5) {
                    color_bright = 135;
                } else if (progress == 6) {
                    color_bright = 136;
                } else if (progress == 7) {
                    color_bright = 137;
                } else if (progress == 8) {
                    color_bright = 138;
                } else if (progress == 9) {
                    color_bright = 139;
                } else if (progress == 10) {
                    color_bright = 140;
                }

            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        c1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                colorview.setBackgroundColor(Color.parseColor("#F9F600"));
                colorview.setText("");
                disableflashstrobe();
            }
        });
        c2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                colorview.setBackgroundColor(Color.parseColor("#FEBE50"));
                colorview.setText("");
                disableflashstrobe();

            }
        });
        c3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                colorview.setBackgroundColor(Color.parseColor("#F7913C"));
                colorview.setText("");
                disableflashstrobe();

            }
        });

        c4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                colorview.setBackgroundColor(Color.parseColor("#F3703C"));
                colorview.setText("");
                disableflashstrobe();

            }
        });
        c5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                colorview.setBackgroundColor(Color.parseColor("#EA1D24"));
                colorview.setText("");
                disableflashstrobe();

            }
        });
        c6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                colorview.setBackgroundColor(Color.parseColor("#9F0064"));
                colorview.setText("");
                disableflashstrobe();

            }
        });
        c7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                colorview.setBackgroundColor(Color.parseColor("#892891"));
                colorview.setText("");
                disableflashstrobe();

            }
        });
        c8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                colorview.setBackgroundColor(Color.parseColor("#5F6EB3"));
                colorview.setText("");
                disableflashstrobe();

            }
        });
        c9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                colorview.setBackgroundColor(Color.parseColor("#0293D4"));
                colorview.setText("");
                disableflashstrobe();

            }
        });
        c10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                colorview.setBackgroundColor(Color.parseColor("#009F8B"));
                colorview.setText("");
                disableflashstrobe();

            }
        });
        c11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                colorview.setBackgroundColor(Color.parseColor("#51B747"));
                colorview.setText("");
                disableflashstrobe();

            }
        });
        c12.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                colorview.setBackgroundColor(Color.parseColor("#FFFFFF"));
                colorview.setText("");
                disableflashstrobe();

            }
        });


        flash.setTag(0);
        flash.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (view.getTag().equals(0)) {
                    flash.setBackgroundResource(R.drawable.flash01);
                    strobe.setBackgroundResource(R.drawable.strobe);
                    fade.setBackgroundResource(R.drawable.fade);
                    smooth.setBackgroundResource(R.drawable.smooth);
                    colorview.setBackgroundResource(R.drawable.indicator_background);
                    // view.setTag(1);

                    String fls = "FLASH";
                    colorview.setText(fls);
                } else {
                    flash.setBackgroundResource(R.drawable.flash);
                    //view.setTag(0);
                }
            }
        });

        strobe.setTag(0);
        strobe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (view.getTag().equals(0)) {

                    strobe.setBackgroundResource(R.drawable.strobe01);
                    // view.setTag(1);
                    flash.setBackgroundResource(R.drawable.flash);
                    fade.setBackgroundResource(R.drawable.fade);

                    smooth.setBackgroundResource(R.drawable.smooth);
                    colorview.setBackgroundResource(R.drawable.indicator_background);
                    String str = "STROBE";
                    colorview.setText(str);
                } else {
                    strobe.setBackgroundResource(R.drawable.strobe);
                    // view.setTag(0);
                }
            }
        });

        fade.setTag(0);
        fade.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (view.getTag().equals(0)) {
                    fade.setBackgroundResource(R.drawable.fade01);
                    flash.setBackgroundResource(R.drawable.flash);
                    strobe.setBackgroundResource(R.drawable.strobe);
                    smooth.setBackgroundResource(R.drawable.smooth);
                    colorview.setBackgroundResource(R.drawable.indicator_background);
                    //   view.setTag(1);
                    String fad = "FADE";
                    colorview.setText(fad);
                } else {
                    fade.setBackgroundResource(R.drawable.fade);
                    // view.setTag(0);
                }
            }
        });

        smooth.setTag(0);
        smooth.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (view.getTag().equals(0)) {
                    smooth.setBackgroundResource(R.drawable.smooth01);
                    strobe.setBackgroundResource(R.drawable.strobe);
                    flash.setBackgroundResource(R.drawable.flash);
                    fade.setBackgroundResource(R.drawable.fade);
                    colorview.setBackgroundResource(R.drawable.indicator_background);
                    // view.setTag(1);
                    String fls = "SMOOTH";
                    colorview.setText(fls);
                } else {
                    smooth.setBackgroundResource(R.drawable.smooth);
                    //view.setTag(0);
                }
            }
        });

        final int[] count = {0};
        btup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btup.setEnabled(true);
                count[0]++;
                if (count[0] == 0) {
                    tvspeed.setBackgroundResource(R.drawable.spzero);
                    // tvspeed.setTag(0);
                } else if (count[0] == 1) {
                    tvspeed.setBackgroundResource(R.drawable.spone);

                    tvspeed.setTag(1);
                } else if (count[0] == 2) {
                    tvspeed.setBackgroundResource(R.drawable.sptwo);
                    tvspeed.setTag(2);
                } else if (count[0] == 3) {
                    tvspeed.setBackgroundResource(R.drawable.spthree);
                    tvspeed.setTag(3);
                } else if (count[0] == 4) {
                    tvspeed.setBackgroundResource(R.drawable.spfour);
                    tvspeed.setTag(4);
                } else if (count[0] == 5) {
                    tvspeed.setBackgroundResource(R.drawable.spfive);
                    tvspeed.setTag(5);
                } else if (count[0] == 6) {
                    tvspeed.setBackgroundResource(R.drawable.spsix);
                    tvspeed.setTag(6);
                } else if (count[0] == 7) {
                    tvspeed.setBackgroundResource(R.drawable.spseven);
                    tvspeed.setTag(7);
                } else if (count[0] == 8) {
                    tvspeed.setBackgroundResource(R.drawable.speight);
                    tvspeed.setTag(8);
                } else if (count[0] == 9) {
                    tvspeed.setBackgroundResource(R.drawable.spnine);
                    tvspeed.setTag(9);
                } else if (count[0] == 10) {
                    tvspeed.setBackgroundResource(R.drawable.spten);
                    tvspeed.setTag(10);
                } else if (count[0] == 11) {
                    btup.setEnabled(false);
                    count[0]--;
                }


                //tvspeed.setText(String.valueOf(count[0]));
                btup.setEnabled(true);

            }
        });

        btdown.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btdown.setEnabled(true);
                count[0]--;

                if (count[0] == -1) {
                    btdown.setEnabled(false);
                    count[0]++;
                } else if (count[0] == 0) {
                    tvspeed.setBackgroundResource(R.drawable.spzero);
                    tvspeed.setTag(0);
                } else if (count[0] == 1) {
                    tvspeed.setBackgroundResource(R.drawable.spone);
                    tvspeed.setTag(1);
                } else if (count[0] == 2) {
                    tvspeed.setBackgroundResource(R.drawable.sptwo);
                    tvspeed.setTag(2);
                } else if (count[0] == 3) {
                    tvspeed.setBackgroundResource(R.drawable.spthree);
                    tvspeed.setTag(3);
                } else if (count[0] == 4) {
                    tvspeed.setBackgroundResource(R.drawable.spfour);
                    tvspeed.setTag(4);
                } else if (count[0] == 5) {
                    tvspeed.setBackgroundResource(R.drawable.spfive);
                    tvspeed.setTag(5);
                } else if (count[0] == 6) {
                    tvspeed.setBackgroundResource(R.drawable.spsix);
                    tvspeed.setTag(6);
                } else if (count[0] == 7) {
                    tvspeed.setBackgroundResource(R.drawable.spseven);
                    tvspeed.setTag(7);
                } else if (count[0] == 8) {
                    tvspeed.setBackgroundResource(R.drawable.speight);
                    tvspeed.setTag(8);
                } else if (count[0] == 9) {
                    tvspeed.setBackgroundResource(R.drawable.spnine);
                    tvspeed.setTag(9);
                } else if (count[0] == 10) {
                    tvspeed.setBackgroundResource(R.drawable.spten);
                    tvspeed.setTag(10);
                }
                btdown.setEnabled(true);
            }

        });

        // dialog1.getWindow().setLayout(400, 450);
        //dialog1.show();;

        dataBase = db.getWritableDatabase();
        //the SQL command to fetched all records from the table
        mCursor = dataBase.rawQuery("SELECT * FROM " + TABLE_NAME, null);
        //reset variables
        anum.clear();
        ahousenum.clear();
        ahousename.clear();
        aroomnum.clear();

        adevicename.clear();
        adevicenum.clear();
        aswitch1.clear();
        astatus.clear();
        adata.clear();
        amood_type.clear();


        if (mCursor.getCount() > 0) {
            //fetch each record
            if (mCursor.moveToFirst()) {
                //mCursor.moveToFirst();
                do {
                    if (mood_num.equals("1")) {
                        //  mCursor = db.getData("mood1");
                        if (mCursor.getString(mCursor.getColumnIndex(MOOD_TYPE)).equals("rmood1")) {
                            rgb_status();
                            //data = ar_num_switch + ";" + on_data;
                            // db2.updateData(aaanum,"1","abcd","1",aaaswitch1,aaadevicename,aaadevicenum,"ON",data,aaamood_type);
                        }
                    } else if (mood_num.equals("2")) {
                        //  mCursor = db.getData("mood1");
                        if (mCursor.getString(mCursor.getColumnIndex(MOOD_TYPE)).equals("rmood2")) {
                            rgb_status();
                            //data = ar_num_switch + ";" + on_data;
                            // db2.updateData(aaanum,"1","abcd","1",aaaswitch1,aaadevicename,aaadevicenum,"ON",data,aaamood_type);
                        }
                    } else if (mood_num.equals("3")) {
                        //  mCursor = db.getData("mood1");
                        if (mCursor.getString(mCursor.getColumnIndex(MOOD_TYPE)).equals("rmood3")) {
                            rgb_status();
                            //data = ar_num_switch + ";" + on_data;
                            // db2.updateData(aaanum,"1","abcd","1",aaaswitch1,aaadevicename,aaadevicenum,"ON",data,aaamood_type);
                        }
                    }
                } while (mCursor.moveToNext());
                db.close();
            }
            //do above till data exhausted
            mCursor.close();
            //  }
        } else {

            // insert();
        }


        int width = (int) (getResources().getDisplayMetrics().widthPixels * 0.80);
        int height = (int) (getResources().getDisplayMetrics().heightPixels * 0.50);
        dialog1.getWindow().setLayout(width, height);
        dialog1.show();

        mood_list.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, DisplayList.class);
                startActivity(i);
                finish();

            }
        });

        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog1.dismiss();
            }
        });

        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DatabaseHelper db2 = new DatabaseHelper(view.getContext());
                db2.getWritableDatabase();
                CharSequence z = colorview.getText();
                if (z.equals("")) {
                    fsfs_speed = "000";
                    int color;
                    Drawable background = colorview.getBackground();
                    if (background instanceof ColorDrawable) {
                        color = ((ColorDrawable) background).getColor();
                        Integer intColor = color;
                        String hexColor = "#" + Integer.toHexString(intColor).substring(2);
                        rrr = Integer.valueOf(hexColor.substring(1, 3), 16);
                        ggg = Integer.valueOf(hexColor.substring(3, 5), 16);
                        bbb = Integer.valueOf(hexColor.substring(5, 7), 16);

                        if (rrr <= 9) {
                            rrrr = "00" + rrr;
                        } else if (rrr > 9 && rrr <= 99) {
                            rrrr = "0" + rrr;
                        } else {
                            rrrr = String.valueOf(rrr);
                        }

                        if (ggg <= 9) {
                            gggg = "00" + ggg;
                        } else if (ggg > 9 && ggg <= 99) {
                            gggg = "0" + ggg;
                        } else {
                            gggg = String.valueOf(ggg);
                        }

                        if (bbb <= 9) {
                            bbbb = "00" + bbb;
                        } else if (bbb > 9 && bbb <= 99) {
                            bbbb = "0" + bbb;
                        } else {
                            bbbb = String.valueOf(bbb);
                        }

                        color_fsfs = "112";
                        int m = brightness.getProgress();
                        if (m == 1) {
                            color_bright = 131;
                        } else if (m == 2) {
                            color_bright = 132;
                        } else if (m == 3) {
                            color_bright = 133;
                            // colorview.setText(String.valueOf(color_bright));
                        } else if (m == 4) {
                            color_bright = 134;
                        } else if (m == 5) {
                            color_bright = 135;
                        } else if (m == 6) {
                            color_bright = 136;
                        } else if (m == 7) {
                            color_bright = 137;
                        } else if (m == 8) {
                            color_bright = 138;
                        } else if (m == 9) {
                            color_bright = 139;
                        } else if (m == 10) {
                            color_bright = 140;
                        }

                    }
                    fsfs = "0";
                    data = fsfs + "," + rrrr + "," + gggg + "," + bbbb + ";" + fsfs_speed + ";" + color_bright;
                    // insert();
                    dataBase = db.getWritableDatabase();
                    mCursor = dataBase.rawQuery("SELECT * FROM " + TABLE_NAME, null);
                    mCursor = dataBase.rawQuery("SELECT * FROM MoodSetTable WHERE MOOD_TYPE='" + mood_type + "'", null);
                    Boolean rowExists;

                    if (mCursor.moveToFirst()) {
                        db2.updateData(col_num, "1", "abcd", "1", switch_nam, devicee_name, devicee_num, "ON", data, moood_type);
                    } else {
                        if (data != null && fsfs != null && color_bright > 0 && fsfs_speed != null && rrrr != null && gggg != null && bbbb != null) {
                            insert();
                        } else {
                            Toast.makeText(MainActivity.this, "Please set data", Toast.LENGTH_LONG).show();
                        }
                    }
                } else {
                    CharSequence fs = colorview.getText();
                    if (fs.equals("FLASH")) {
                        fsfs = "104";
                    } else if (fs.equals("STROBE")) {
                        fsfs = "105";
                    } else if (fs.equals("FADE")) {
                        fsfs = "106";
                    } else if (fs.equals("SMOOTH")) {
                        fsfs = "107";
                    } else {
                        fsfs = "0";
                    }

                    color_fsfs = fsfs;
                    rrrr = "0";
                    gggg = "0";
                    bbbb = "0";


                    int m = brightness.getProgress();
                    if (m == 1) {
                        color_bright = 131;
                    } else if (m == 2) {
                        color_bright = 132;
                    } else if (m == 3) {
                        color_bright = 133;
                        // colorview.setText(String.valueOf(color_bright));
                    } else if (m == 4) {
                        color_bright = 134;
                    } else if (m == 5) {
                        color_bright = 135;
                    } else if (m == 6) {
                        color_bright = 136;
                    } else if (m == 7) {
                        color_bright = 137;
                    } else if (m == 8) {
                        color_bright = 138;
                    } else if (m == 9) {
                        color_bright = 139;
                    } else if (m == 10) {
                        color_bright = 140;
                    }


                    tvspeed1 = tvspeed.getTag();
                    //  Drawable ggggg = colorview.getBackground();
                    if (tvspeed1.equals(0)) {
                        fsfs_speed = "120";
                    }
                    if (tvspeed1.equals(1)) {
                        fsfs_speed = "121";
                    } else if (tvspeed1.equals(2)) {
                        fsfs_speed = "122";
                    } else if (tvspeed1.equals(3)) {
                        fsfs_speed = "123";
                    } else if (tvspeed1.equals(4)) {
                        fsfs_speed = "124";
                    } else if (tvspeed1.equals(5)) {
                        fsfs_speed = "125";
                    } else if (tvspeed1.equals(6)) {
                        fsfs_speed = "126";
                    } else if (tvspeed1.equals(7)) {
                        fsfs_speed = "127";
                    } else if (tvspeed1.equals(8)) {
                        fsfs_speed = "128";
                    } else if (tvspeed1.equals(9)) {
                        fsfs_speed = "129";
                    } else if (tvspeed1.equals(10)) {
                        fsfs_speed = "130";
                    } else {
                        fsfs_speed = "000";
                    }
                    data = fsfs + "," + rrrr + "," + gggg + "," + bbbb + ";" + fsfs_speed + ";" + color_bright;
                    dataBase = db.getWritableDatabase();
                    mCursor = dataBase.rawQuery("SELECT * FROM " + TABLE_NAME, null);
                    mCursor = dataBase.rawQuery("SELECT * FROM MoodSetTable WHERE MOOD_TYPE='" + mood_type + "'", null);
                    Boolean rowExists;

                    if (mCursor.moveToFirst()) {
                        db2.updateData(col_num, "1", "abcd", "1", switch_nam, devicee_name, devicee_num, "ON", data, moood_type);
                    } else {
                        if (data != null && fsfs != null && fsfs_speed != null) {
                            insert();
                        } else {
                            Toast.makeText(MainActivity.this, "Please set data", Toast.LENGTH_LONG).show();
                        }
                    }
                    // insert();
                }
                dialog1.dismiss();
            }
        });

    }


    private void dimmer_status() {
        //get data from field
        col_num = mCursor.getString(mCursor.getColumnIndex(DatabaseHelper.COLUMN_NO));
        house_number = mCursor.getString(mCursor.getColumnIndex(DatabaseHelper.HOUSE_NUM));
        house_names = mCursor.getString(mCursor.getColumnIndex(DatabaseHelper.HOUSE_NAME));
        room_number = mCursor.getString(mCursor.getColumnIndex(DatabaseHelper.ROOM_NUM));
        devicee_name = mCursor.getString(mCursor.getColumnIndex(DatabaseHelper.DEVICE_TYPE));
        devicee_num = mCursor.getString(mCursor.getColumnIndex(DatabaseHelper.DEVICE_NUM));
        switch_nam = mCursor.getString(mCursor.getColumnIndex(DatabaseHelper.SETTING_NUM));
        status_display = mCursor.getString(mCursor.getColumnIndex(DatabaseHelper.STATUS));
        adata.add(mCursor.getString(mCursor.getColumnIndex(DatabaseHelper.DATA)));
        moood_type = mCursor.getString(mCursor.getColumnIndex(MOOD_TYPE));
        adata.add(mCursor.getString(mCursor.getColumnIndex(DatabaseHelper.DATA)));
        String ondat = String.valueOf(adata);
        String data_string = mCursor.getString(mCursor.getColumnIndex(DatabaseHelper.DATA));
        int s11 = Integer.parseInt(data_string);

        if (s11 > 0 && s11 <= 15) {
            image_dimmer.setImageResource(R.drawable.b1);
            seekArc.setProgress(1);

        } else if (s11 > 15 && s11 <= 30) {
            image_dimmer.setImageResource(R.drawable.b2);
            seekArc.setProgress(2);
        } else if (s11 > 30 && s11 <= 55) {
            image_dimmer.setImageResource(R.drawable.b3);
            seekArc.setProgress(3);
        } else if (s11 > 55 && s11 <= 100) {
            image_dimmer.setImageResource(R.drawable.b4);
            seekArc.setProgress(4);
        } else if (s11 > 100 && s11 <= 150) {
            image_dimmer.setImageResource(R.drawable.b5);
            seekArc.setProgress(5);
        } else if (s11 > 150 && s11 <= 175) {
            image_dimmer.setImageResource(R.drawable.b6);
            seekArc.setProgress(6);
        } else if (s11 > 175 && s11 <= 200) {
            image_dimmer.setImageResource(R.drawable.b7);
            seekArc.setProgress(7);
        } else if (s11 > 200 && s11 <= 225) {
            image_dimmer.setImageResource(R.drawable.b8);
            seekArc.setProgress(8);
        } else if (s11 > 225 && s11 <= 255) {
            image_dimmer.setImageResource(R.drawable.b9);
            seekArc.setProgress(9);
        }


    }


    private void rgb_status() {
        //get data from field
        col_num = mCursor.getString(mCursor.getColumnIndex(DatabaseHelper.COLUMN_NO));
        house_number = mCursor.getString(mCursor.getColumnIndex(DatabaseHelper.HOUSE_NUM));
        house_names = mCursor.getString(mCursor.getColumnIndex(DatabaseHelper.HOUSE_NAME));
        room_number = mCursor.getString(mCursor.getColumnIndex(DatabaseHelper.ROOM_NUM));
        devicee_name = mCursor.getString(mCursor.getColumnIndex(DatabaseHelper.DEVICE_TYPE));
        devicee_num = mCursor.getString(mCursor.getColumnIndex(DatabaseHelper.DEVICE_NUM));
        switch_nam = mCursor.getString(mCursor.getColumnIndex(DatabaseHelper.SETTING_NUM));
        status_display = mCursor.getString(mCursor.getColumnIndex(DatabaseHelper.STATUS));
        adata.add(mCursor.getString(mCursor.getColumnIndex(DatabaseHelper.DATA)));
        moood_type = mCursor.getString(mCursor.getColumnIndex(MOOD_TYPE));
        adata.add(mCursor.getString(mCursor.getColumnIndex(DatabaseHelper.DATA)));

        String ondat = String.valueOf(adata);

        String [] d = ondat.split("(\\[)|(\\])");
        one = d[1];
        String d2[] = one.split(";");
        two = d2[0];
        two2 = d2[1];
        two3 = d2[2];

        String d3[] = two.split(",");
        d4=d3[0];
        String rr = d3[1];
        String gg = d3[2];
        String bb = d3[3];



        if (check2 >= 121 && check2 <= 130) {
            speed();
        }


        check3 = Integer.parseInt(two3);
        if (check3 >= 131 && check2 <= 130) {
            brightness();
        }

        if (d4.equals("0")) {
            int r = Integer.parseInt(rr);
            int g = Integer.parseInt(gg);
            int b = Integer.parseInt(bb);
            colorview.setBackgroundColor(Color.rgb(r, g, b));

        } else {
            flashfadesmooth();
        }

    }


    void brightness() {
        brightness.setMax(10);
        if (check3 == 131) {
            brightness.setProgress(1);

        } else if (check3 == 132) {
            brightness.setProgress(2);

        } else if (check3 == 133) {
            brightness.setProgress(3);
        } else if (check3 == 134) {
            brightness.setProgress(4);
        } else if (check3 == 135) {
            brightness.setProgress(5);
        } else if (check3 == 136) {
            brightness.setProgress(6);
        } else if (check3 == 137) {
            brightness.setProgress(7);
        } else if (check3 == 138) {
            brightness.setProgress(8);
        } else if (check3 == 139) {
            brightness.setProgress(9);
        } else if (check3 == 140) {
            brightness.setProgress(10);
        } else {
            brightness.setProgress(0);
        }

    }

    void speed() {
        if (check2 == 121) {
            tvspeed.setBackgroundResource(R.drawable.spone);

        } else if (check2 == 122) {
            tvspeed.setBackgroundResource(R.drawable.sptwo);
        } else if (check2 == 123) {
            tvspeed.setBackgroundResource(R.drawable.spthree);
        } else if (check2 == 124) {
            tvspeed.setBackgroundResource(R.drawable.spfour);
        } else if (check2 == 125) {
            tvspeed.setBackgroundResource(R.drawable.spfive);
        } else if (check2 == 126) {
            tvspeed.setBackgroundResource(R.drawable.spsix);
        } else if (check2 == 127) {
            tvspeed.setBackgroundResource(R.drawable.spseven);
        } else if (check2 == 128) {
            tvspeed.setBackgroundResource(R.drawable.speight);
        } else if (check2 == 129) {
            tvspeed.setBackgroundResource(R.drawable.spnine);
        } else if (check2 == 130) {
            tvspeed.setBackgroundResource(R.drawable.spten);
        } else {
            tvspeed.setBackgroundResource(R.drawable.spzero);
        }

    }

    void flashfadesmooth() {
        switch (d4) {
            case "104": {

                flash.setBackgroundResource(R.drawable.flash01);
                strobe.setBackgroundResource(R.drawable.strobe);
                fade.setBackgroundResource(R.drawable.fade);
                smooth.setBackgroundResource(R.drawable.smooth);
                // view.setTag(1);

                String fls = "FLASH";
                colorview.setText(fls);
                break;
            }
            case "105":
                strobe.setBackgroundResource(R.drawable.strobe01);
                // view.setTag(1);
                flash.setBackgroundResource(R.drawable.flash);
                fade.setBackgroundResource(R.drawable.fade);

                smooth.setBackgroundResource(R.drawable.smooth);
                String str = "STROBE";
                colorview.setText(str);
                break;
            case "106":
                fade.setBackgroundResource(R.drawable.fade01);
                flash.setBackgroundResource(R.drawable.flash);
                strobe.setBackgroundResource(R.drawable.strobe);
                smooth.setBackgroundResource(R.drawable.smooth);
                //   view.setTag(1);
                String fad = "FADE";
                colorview.setText(fad);
                break;
            case "107": {
                smooth.setBackgroundResource(R.drawable.smooth01);
                strobe.setBackgroundResource(R.drawable.strobe);
                flash.setBackgroundResource(R.drawable.flash);
                fade.setBackgroundResource(R.drawable.fade);
                // view.setTag(1);
                String fls = "SMOOTH";
                colorview.setText(fls);
                break;
            }
        }
    }

    private void insert() {

        db.insertPlate("1", "abcd", "1", mood_num, device_name, device_num, "ON", data, mood_type);
    }

    void disableflashstrobe() {
        flash.setBackgroundResource(R.drawable.flash);
        strobe.setBackgroundResource(R.drawable.strobe);
        fade.setBackgroundResource(R.drawable.fade);
        smooth.setBackgroundResource(R.drawable.smooth);
    }


    private void curtain() {
        device_name = "Curtain";
        cur_status = null;
        cur_type = null;
        final LayoutInflater inflater1 = getLayoutInflater();
        alertLayout = inflater1.inflate(R.layout.curtain_popup, null);
        AlertDialog.Builder alert = new AlertDialog.Builder(MainActivity.this, R.style.MyDialogTheme1);

        alert.setView(alertLayout);
        alert.setCancelable(true);
        final AlertDialog dialog1 = alert.create();
        dialog1.show();
        Button mood_list = (Button) alertLayout.findViewById(R.id.mood_list);
        save = (Button) alertLayout.findViewById(R.id.save);
        cancel = (Button) alertLayout.findViewById(R.id.cancel);

        btopen = (Button) alertLayout.findViewById(R.id.btopen);
        btclose = (Button) alertLayout.findViewById(R.id.btclose);
        btstop = (Button) alertLayout.findViewById(R.id.btstop);

        btopen_sheer = (Button) alertLayout.findViewById(R.id.btopen_sheer);
        btclose_sheer = (Button) alertLayout.findViewById(R.id.btclose_sheer);
        btstop_sheer = (Button) alertLayout.findViewById(R.id.btstop_sheer);

        btopen_curtain = (Button) alertLayout.findViewById(R.id.btopen_curtain);
        btclose_curtain = (Button) alertLayout.findViewById(R.id.btclose_curtain);
        btstop_curtain = (Button) alertLayout.findViewById(R.id.btstop_curtain);
        btopen.setTag(0);
        btclose.setTag(0);
        btstop.setTag(0);

        btopen_sheer.setTag(0);
        btclose_sheer.setTag(0);
        btstop_sheer.setTag(0);

        btopen_curtain.setTag(0);
        btclose_curtain.setTag(0);
        btstop_curtain.setTag(0);

        dataBase = db.getWritableDatabase();
        //the SQL command to fetched all records from the table
        mCursor = dataBase.rawQuery("SELECT * FROM " + TABLE_NAME, null);
        //reset variables
        anum.clear();
        ahousenum.clear();
        ahousename.clear();
        aroomnum.clear();

        adevicename.clear();
        adevicenum.clear();
        aswitch1.clear();
        astatus.clear();
        adata.clear();
        amood_type.clear();


        if (mCursor.getCount() > 0) {
            //fetch each record
            if (mCursor.moveToFirst()) {
                //mCursor.moveToFirst();
                do {
                    if (mood_num.equals("1")) {
                        //  mCursor = db.getData("mood1");
                        if (mCursor.getString(mCursor.getColumnIndex(MOOD_TYPE)).equals("cmood1")) {
                            curtain_status();
                         }
                    } else if (mood_num.equals("2")) {

                        if (mCursor.getString(mCursor.getColumnIndex(MOOD_TYPE)).equals("cmood2")) {
                            curtain_status();
                         }
                    } else if (mood_num.equals("3")) {

                        if (mCursor.getString(mCursor.getColumnIndex(MOOD_TYPE)).equals("cmood3")) {
                            curtain_status();
                            }
                    }
                } while (mCursor.moveToNext());
                db.close();
            }
            //do above till data exhausted
            mCursor.close();
            //  }
        } else {

            // insert();
        }

        int width = (int) (getResources().getDisplayMetrics().widthPixels * 0.80);
        int height = (int) (getResources().getDisplayMetrics().heightPixels * 0.45);
        dialog1.getWindow().setLayout(width, height);
        dialog1.show();


        btopen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (view.getTag().equals(0)) {
                    btopen.setBackgroundResource(R.drawable.open01);
                    btclose.setBackgroundResource(R.drawable.close);
                    btopen_sheer.setBackgroundResource(R.drawable.open);
                    btclose_sheer.setBackgroundResource(R.drawable.close);
                    btopen_curtain.setBackgroundResource(R.drawable.open);
                    btclose_curtain.setBackgroundResource(R.drawable.close);
                    cur_status = "101";
                    cur_type = "ALL";

                } else {
                    btopen.setBackgroundResource(R.drawable.open);
                    cur_status = "";
                    cur_type = "";
                }
            }
        });
        btclose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (view.getTag().equals(0)) {
                    btclose.setBackgroundResource(R.drawable.close01);

                    btopen.setBackgroundResource(R.drawable.open);
                    btopen_sheer.setBackgroundResource(R.drawable.open);
                    btclose_sheer.setBackgroundResource(R.drawable.close);
                    btopen_curtain.setBackgroundResource(R.drawable.open);
                    btclose_curtain.setBackgroundResource(R.drawable.close);
                    cur_status = "102";
                    cur_type = "ALL";

                } else {
                    btclose.setBackgroundResource(R.drawable.close);
                    cur_status = "";
                    cur_type = "";
                }
            }
        });

        btopen_sheer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (view.getTag().equals(0)) {
                    btopen_sheer.setBackgroundResource(R.drawable.open01);

                    btclose.setBackgroundResource(R.drawable.close);
                    btopen.setBackgroundResource(R.drawable.open);
                    btclose_sheer.setBackgroundResource(R.drawable.close);
                    btopen_curtain.setBackgroundResource(R.drawable.open);
                    btclose_curtain.setBackgroundResource(R.drawable.close);
                    cur_status = "101";
                    cur_type = "CLR";

                } else {
                    btopen_sheer.setBackgroundResource(R.drawable.open);
                    cur_status = "";
                    cur_type = "";
                }
            }
        });
        btclose_sheer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (view.getTag().equals(0)) {
                    btclose_sheer.setBackgroundResource(R.drawable.close01);

                    btclose.setBackgroundResource(R.drawable.close);
                    btopen_sheer.setBackgroundResource(R.drawable.open);
                    btopen.setBackgroundResource(R.drawable.open);
                    btopen_curtain.setBackgroundResource(R.drawable.open);
                    btclose_curtain.setBackgroundResource(R.drawable.close);
                    cur_status = "102";
                    cur_type = "CLR";

                } else {
                    btclose_sheer.setBackgroundResource(R.drawable.close);
                    cur_status = "";
                    cur_type = "";
                }
            }
        });

        btopen_curtain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (view.getTag().equals(0)) {
                    btopen_curtain.setBackgroundResource(R.drawable.open01);

                    btclose.setBackgroundResource(R.drawable.close);
                    btopen_sheer.setBackgroundResource(R.drawable.open);
                    btclose_sheer.setBackgroundResource(R.drawable.close);
                    btopen.setBackgroundResource(R.drawable.open);
                    btclose_curtain.setBackgroundResource(R.drawable.close);
                    cur_status = "101";
                    cur_type = "CC";

                } else {
                    btopen_curtain.setBackgroundResource(R.drawable.open);
                    cur_status = "";
                    cur_type = "";
                }
            }
        });

        btclose_curtain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (view.getTag().equals(0)) {
                    btclose_curtain.setBackgroundResource(R.drawable.close01);

                    btclose.setBackgroundResource(R.drawable.close);
                    btopen_sheer.setBackgroundResource(R.drawable.open);
                    btclose_sheer.setBackgroundResource(R.drawable.close);
                    btopen_curtain.setBackgroundResource(R.drawable.open);
                    btopen.setBackgroundResource(R.drawable.open);
                    cur_status = "102";
                    cur_type = "CC";

                } else {
                    btclose_curtain.setBackgroundResource(R.drawable.close);
                    cur_status = "";
                    cur_type = "";
                }
            }
        });

        mood_list.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, DisplayList.class);
                startActivity(i);
                finish();

            }
        });
        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog1.dismiss();
            }
        });

        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DatabaseHelper db2 = new DatabaseHelper(view.getContext());
                db2.getWritableDatabase();
                data = cur_status + ";" + cur_type;
                // insert();
                dataBase = db.getWritableDatabase();
                mCursor = dataBase.rawQuery("SELECT * FROM " + TABLE_NAME, null);
                mCursor = dataBase.rawQuery("SELECT * FROM MoodSetTable WHERE MOOD_TYPE='" + mood_type + "'", null);
                Boolean rowExists;

                if (mCursor.moveToFirst()) {
                    db2.updateData(col_num, "1", "abcd", "1", switch_nam, devicee_name, devicee_num, "ON", data, moood_type);

                } else {
                    if (data != null && cur_status != null && cur_type != null) {
                        insert();
                    } else {
                        Toast.makeText(MainActivity.this, "Please set data", Toast.LENGTH_LONG).show();
                    }
                }
                dialog1.dismiss();
            }
        });


    }

    private void curtain_status() {
        //get data from field
        col_num = mCursor.getString(mCursor.getColumnIndex(DatabaseHelper.COLUMN_NO));
        house_number = mCursor.getString(mCursor.getColumnIndex(DatabaseHelper.HOUSE_NUM));
        house_names = mCursor.getString(mCursor.getColumnIndex(DatabaseHelper.HOUSE_NAME));
        room_number = mCursor.getString(mCursor.getColumnIndex(DatabaseHelper.ROOM_NUM));
        devicee_name = mCursor.getString(mCursor.getColumnIndex(DatabaseHelper.DEVICE_TYPE));
        devicee_num = mCursor.getString(mCursor.getColumnIndex(DatabaseHelper.DEVICE_NUM));
        switch_nam = mCursor.getString(mCursor.getColumnIndex(DatabaseHelper.SETTING_NUM));
        status_display = mCursor.getString(mCursor.getColumnIndex(DatabaseHelper.STATUS));
        adata.add(mCursor.getString(mCursor.getColumnIndex(DatabaseHelper.DATA)));
        moood_type = mCursor.getString(mCursor.getColumnIndex(MOOD_TYPE));
        dataa = mCursor.getString(mCursor.getColumnIndex(DatabaseHelper.DATA));


        String ondat = dataa;

        String splitTime[] = ondat.split(";");
        curtain_status = splitTime[0];
        curtain_type = splitTime[1];
        //int a = one.length();
        if (curtain_type.equals("ALL") && curtain_status.equals("101")) {
            btopen.setBackgroundResource(R.drawable.open01);
            cur_status = "101";
            cur_type = "ALL";
        } else if (curtain_type.equals("ALL") && curtain_status.equals("102")) {
            btclose.setBackgroundResource(R.drawable.close01);
            cur_status = "102";
            cur_type = "ALL";
        } else if (curtain_type.equals("CLR") && curtain_status.equals("101")) {
            btopen_sheer.setBackgroundResource(R.drawable.open01);
            cur_status = "101";
            cur_type = "CLR";
        } else if (curtain_type.equals("CLR") && curtain_status.equals("102")) {
            btclose_sheer.setBackgroundResource(R.drawable.close01);
            cur_status = "102";
            cur_type = "CLR";
        } else if (curtain_type.equals("CC") && curtain_status.equals("101")) {
            btopen_curtain.setBackgroundResource(R.drawable.open01);
            cur_status = "101";
            cur_type = "CC";
        } else if (curtain_type.equals("CC") && curtain_status.equals("102")) {
            btclose_curtain.setBackgroundResource(R.drawable.close01);
            cur_status = "102";
            cur_type = "CC";
        }
    }


    /////////////////////////////////////////////////////////////////////////////////////////////////////

    private void ac() {
        device_name = "AC";
        ac_data = null;
        final LayoutInflater inflater1 = getLayoutInflater();
        alertLayout = inflater1.inflate(R.layout.ac_popup, null);
        AlertDialog.Builder alert = new AlertDialog.Builder(MainActivity.this, R.style.MyDialogTheme1);

        alert.setView(alertLayout);
        alert.setCancelable(true);
        final AlertDialog dialog1 = alert.create();
        dialog1.show();
        Button mood_list = (Button) alertLayout.findViewById(R.id.mood_list);
        save = (Button) alertLayout.findViewById(R.id.save);
        cancel = (Button) alertLayout.findViewById(R.id.cancel);

        ac_tb = (Button) alertLayout.findViewById(R.id.ac_tb);

        ac_tb.setTag(0);


        dataBase = db.getWritableDatabase();
        //the SQL command to fetched all records from the table
        mCursor = dataBase.rawQuery("SELECT * FROM " + TABLE_NAME, null);
        //reset variables
        anum.clear();
        ahousenum.clear();
        ahousename.clear();
        aroomnum.clear();

        adevicename.clear();
        adevicenum.clear();
        aswitch1.clear();
        astatus.clear();
        adata.clear();
        amood_type.clear();


        if (mCursor.getCount() > 0) {
            //fetch each record
            if (mCursor.moveToFirst()) {
                //mCursor.moveToFirst();
                do {
                    if (mood_num.equals("1")) {
                        if (mCursor.getString(mCursor.getColumnIndex(MOOD_TYPE)).equals("acmood1")) {
                            ac_status();
                        }
                    } else if (mood_num.equals("2")) {
                        if (mCursor.getString(mCursor.getColumnIndex(MOOD_TYPE)).equals("acmood2")) {
                            ac_status();
                        }
                    } else if (mood_num.equals("3")) {
                        if (mCursor.getString(mCursor.getColumnIndex(MOOD_TYPE)).equals("acmood3")) {
                            ac_status();
                        }
                    }
                } while (mCursor.moveToNext());
                db.close();
            }
            //do above till data exhausted
            mCursor.close();
            //  }
        } else {

            // insert();
        }

        int width = (int) (getResources().getDisplayMetrics().widthPixels * 0.60);
        int height = (int) (getResources().getDisplayMetrics().heightPixels * 0.35);
        dialog1.getWindow().setLayout(width, height);
        dialog1.show();


        ac_tb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (view.getTag().equals(0)) {
                    ac_tb.setBackgroundResource(R.drawable.on);
                    ac_data = "201";
                    view.setTag(1);
                    ac_tb.setTag(1);

                } else {
                    ac_tb.setBackgroundResource(R.drawable.off);
                    ac_data = "301";
                    view.setTag(0);
                    ac_tb.setTag(0);

                }
            }
        });

        mood_list.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, DisplayList.class);
                startActivity(i);
                finish();

            }
        });
        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog1.dismiss();
            }
        });

        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DatabaseHelper db2 = new DatabaseHelper(view.getContext());
                db2.getWritableDatabase();
                data = ac_data;
                // insert();
                dataBase = db.getWritableDatabase();
                mCursor = dataBase.rawQuery("SELECT * FROM " + TABLE_NAME, null);
                mCursor = dataBase.rawQuery("SELECT * FROM MoodSetTable WHERE MOOD_TYPE='" + mood_type + "'", null);
                Boolean rowExists;

                if (mCursor.moveToFirst()) {
                    db2.updateData(col_num, "1", "abcd", "1", switch_nam, devicee_name, devicee_num, "ON", data, moood_type);

                } else {
                    if (data != null && ac_data != null) {
                        insert();
                    } else {
                        Toast.makeText(MainActivity.this, "Please set data", Toast.LENGTH_LONG).show();
                    }
                }
                dialog1.dismiss();
            }
        });


    }

    private void ac_status() {
        col_num = mCursor.getString(mCursor.getColumnIndex(DatabaseHelper.COLUMN_NO));
        house_number = mCursor.getString(mCursor.getColumnIndex(DatabaseHelper.HOUSE_NUM));
        house_names = mCursor.getString(mCursor.getColumnIndex(DatabaseHelper.HOUSE_NAME));
        room_number = mCursor.getString(mCursor.getColumnIndex(DatabaseHelper.ROOM_NUM));
        devicee_name = mCursor.getString(mCursor.getColumnIndex(DatabaseHelper.DEVICE_TYPE));
        devicee_num = mCursor.getString(mCursor.getColumnIndex(DatabaseHelper.DEVICE_NUM));
        switch_nam = mCursor.getString(mCursor.getColumnIndex(DatabaseHelper.SETTING_NUM));
        status_display = mCursor.getString(mCursor.getColumnIndex(DatabaseHelper.STATUS));
        adata.add(mCursor.getString(mCursor.getColumnIndex(DatabaseHelper.DATA)));
        moood_type = mCursor.getString(mCursor.getColumnIndex(MOOD_TYPE));
        dataa = mCursor.getString(mCursor.getColumnIndex(DatabaseHelper.DATA));


        String ondat = dataa;

        if (ondat.equals("201")) {
            ac_tb.setBackgroundResource(R.drawable.on);
            ac_data = "201";
            ac_tb.setTag(1);

        } else if (ondat.equals("301")) {
            ac_tb.setBackgroundResource(R.drawable.off);
            ac_data = "301";
            ac_tb.setTag(0);
        }

    }


    private void bell() {
        device_name = "BELL";
        ac_data = null;
        final LayoutInflater inflater1 = getLayoutInflater();
        alertLayout = inflater1.inflate(R.layout.ac_popup, null);
        AlertDialog.Builder alert = new AlertDialog.Builder(MainActivity.this, R.style.MyDialogTheme1);

        alert.setView(alertLayout);
        alert.setCancelable(true);
        final AlertDialog dialog1 = alert.create();
        dialog1.show();
        Button mood_list = (Button) alertLayout.findViewById(R.id.mood_list);
        save = (Button) alertLayout.findViewById(R.id.save);
        cancel = (Button) alertLayout.findViewById(R.id.cancel);

        ac_tb = (Button) alertLayout.findViewById(R.id.ac_tb);

        ac_tb.setTag(0);


        dataBase = db.getWritableDatabase();
        //the SQL command to fetched all records from the table
        mCursor = dataBase.rawQuery("SELECT * FROM " + TABLE_NAME, null);
        //reset variables
        anum.clear();
        ahousenum.clear();
        ahousename.clear();
        aroomnum.clear();

        adevicename.clear();
        adevicenum.clear();
        aswitch1.clear();
        astatus.clear();
        adata.clear();
        amood_type.clear();


        if (mCursor.getCount() > 0) {
            //fetch each record
            if (mCursor.moveToFirst()) {
                //mCursor.moveToFirst();
                do {
                    if (mood_num.equals("1")) {
                        if (mCursor.getString(mCursor.getColumnIndex(MOOD_TYPE)).equals("bellmood1")) {
                            ac_status();
                        }
                    } else if (mood_num.equals("2")) {
                        if (mCursor.getString(mCursor.getColumnIndex(MOOD_TYPE)).equals("bellmood2")) {
                            ac_status();
                        }
                    } else if (mood_num.equals("3")) {
                        if (mCursor.getString(mCursor.getColumnIndex(MOOD_TYPE)).equals("bellmood3")) {
                            ac_status();
                        }
                    }
                } while (mCursor.moveToNext());
                db.close();
            }
            //do above till data exhausted
            mCursor.close();
            //  }
        } else {

            // insert();
        }

        int width = (int) (getResources().getDisplayMetrics().widthPixels * 0.60);
        int height = (int) (getResources().getDisplayMetrics().heightPixels * 0.35);
        dialog1.getWindow().setLayout(width, height);
        dialog1.show();


        ac_tb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (view.getTag().equals(0)) {
                    ac_tb.setBackgroundResource(R.drawable.on);
                    ac_data = "201";
                    view.setTag(1);
                    ac_tb.setTag(1);

                } else {
                    ac_tb.setBackgroundResource(R.drawable.off);
                    ac_data = "301";
                    view.setTag(0);
                    ac_tb.setTag(0);

                }
            }
        });

        mood_list.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, DisplayList.class);
                startActivity(i);
                finish();

            }
        });
        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog1.dismiss();
            }
        });

        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DatabaseHelper db2 = new DatabaseHelper(view.getContext());
                db2.getWritableDatabase();
                data = ac_data;
                // insert();
                dataBase = db.getWritableDatabase();
                //  mCursor = dataBase.rawQuery("SELECT * FROM " + TABLE_NAME, null);
                mCursor = dataBase.rawQuery("SELECT * FROM MoodSetTable WHERE MOOD_TYPE='" + mood_type + "'", null);
                Boolean rowExists;

                if (mCursor.moveToFirst()) {


                    db2.updateData(col_num, "1", "abcd", "1", switch_nam, devicee_name, devicee_num, "ON", data, moood_type);

                } else {
                    if (data != null && ac_data != null) {
                        insert();
                    } else {
                        Toast.makeText(MainActivity.this, "Please set data", Toast.LENGTH_LONG).show();
                    }
                }
                dialog1.dismiss();
            }
        });

    }

    private void dog() {
        device_name = "DOG";
        ac_data = null;
        final LayoutInflater inflater1 = getLayoutInflater();
        alertLayout = inflater1.inflate(R.layout.ac_popup, null);
        AlertDialog.Builder alert = new AlertDialog.Builder(MainActivity.this, R.style.MyDialogTheme1);

        alert.setView(alertLayout);
        alert.setCancelable(true);
        final AlertDialog dialog1 = alert.create();
        dialog1.show();
        Button mood_list = (Button) alertLayout.findViewById(R.id.mood_list);
        save = (Button) alertLayout.findViewById(R.id.save);
        cancel = (Button) alertLayout.findViewById(R.id.cancel);

        ac_tb = (Button) alertLayout.findViewById(R.id.ac_tb);

        ac_tb.setTag(0);


        dataBase = db.getWritableDatabase();
        //the SQL command to fetched all records from the table
        mCursor = dataBase.rawQuery("SELECT * FROM " + TABLE_NAME, null);
        //reset variables
        anum.clear();
        ahousenum.clear();
        ahousename.clear();
        aroomnum.clear();

        adevicename.clear();
        adevicenum.clear();
        aswitch1.clear();
        astatus.clear();
        adata.clear();
        amood_type.clear();


        if (mCursor.getCount() > 0) {
            //fetch each record
            if (mCursor.moveToFirst()) {
                //mCursor.moveToFirst();
                do {
                    if (mood_num.equals("1")) {
                        if (mCursor.getString(mCursor.getColumnIndex(MOOD_TYPE)).equals("dogmood1")) {
                            ac_status();
                        }
                    } else if (mood_num.equals("2")) {
                        if (mCursor.getString(mCursor.getColumnIndex(MOOD_TYPE)).equals("dogmood2")) {
                            ac_status();
                        }
                    } else if (mood_num.equals("3")) {
                        if (mCursor.getString(mCursor.getColumnIndex(MOOD_TYPE)).equals("dogmood3")) {
                            ac_status();
                        }
                    }
                } while (mCursor.moveToNext());
                db.close();
            }
            //do above till data exhausted
            mCursor.close();
            //  }
        } else {

            // insert();
        }

        int width = (int) (getResources().getDisplayMetrics().widthPixels * 0.60);
        int height = (int) (getResources().getDisplayMetrics().heightPixels * 0.35);
        dialog1.getWindow().setLayout(width, height);
        dialog1.show();


        ac_tb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (view.getTag().equals(0)) {
                    ac_tb.setBackgroundResource(R.drawable.on);
                    ac_data = "201";
                    view.setTag(1);
                    ac_tb.setTag(1);

                } else {
                    ac_tb.setBackgroundResource(R.drawable.off);
                    ac_data = "301";
                    view.setTag(0);
                    ac_tb.setTag(0);

                }
            }
        });

        mood_list.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, DisplayList.class);
                startActivity(i);
                finish();

            }
        });
        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog1.dismiss();
            }
        });

        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DatabaseHelper db2 = new DatabaseHelper(view.getContext());
                db2.getWritableDatabase();
                data = ac_data;
                // insert();
                dataBase = db.getWritableDatabase();
                //  mCursor = dataBase.rawQuery("SELECT * FROM " + TABLE_NAME, null);
                mCursor = dataBase.rawQuery("SELECT * FROM MoodSetTable WHERE MOOD_TYPE='" + mood_type + "'", null);
                Boolean rowExists;

                if (mCursor.moveToFirst()) {
                    db2.updateData(col_num, "1", "abcd", "1", switch_nam, devicee_name, devicee_num, "ON", data, moood_type);

                } else {
                    if (data != null && ac_data != null) {
                        insert();
                    } else {
                        Toast.makeText(MainActivity.this, "Please set data", Toast.LENGTH_LONG).show();
                    }
                }
                dialog1.dismiss();
            }
        });
    }

    private void geyser() {
        device_name = "GEYSER";
        ac_data = null;
        final LayoutInflater inflater1 = getLayoutInflater();
        alertLayout = inflater1.inflate(R.layout.ac_popup, null);
        AlertDialog.Builder alert = new AlertDialog.Builder(MainActivity.this, R.style.MyDialogTheme1);

        alert.setView(alertLayout);
        alert.setCancelable(true);
        final AlertDialog dialog1 = alert.create();
        dialog1.show();
        Button mood_list = (Button) alertLayout.findViewById(R.id.mood_list);
        save = (Button) alertLayout.findViewById(R.id.save);
        cancel = (Button) alertLayout.findViewById(R.id.cancel);

        ac_tb = (Button) alertLayout.findViewById(R.id.ac_tb);

        ac_tb.setTag(0);


        dataBase = db.getWritableDatabase();
        //the SQL command to fetched all records from the table
        mCursor = dataBase.rawQuery("SELECT * FROM " + TABLE_NAME, null);
        //reset variables
        anum.clear();
        ahousenum.clear();
        ahousename.clear();
        aroomnum.clear();

        adevicename.clear();
        adevicenum.clear();
        aswitch1.clear();
        astatus.clear();
        adata.clear();
        amood_type.clear();


        if (mCursor.getCount() > 0) {
            //fetch each record
            if (mCursor.moveToFirst()) {
                //mCursor.moveToFirst();
                do {
                    if (mood_num.equals("1")) {
                        if (mCursor.getString(mCursor.getColumnIndex(MOOD_TYPE)).equals("geymood1")) {
                            ac_status();
                        }
                    } else if (mood_num.equals("2")) {
                        if (mCursor.getString(mCursor.getColumnIndex(MOOD_TYPE)).equals("geymood2")) {
                            ac_status();
                        }
                    } else if (mood_num.equals("3")) {
                        if (mCursor.getString(mCursor.getColumnIndex(MOOD_TYPE)).equals("geymood3")) {
                            ac_status();
                        }
                    }
                } while (mCursor.moveToNext());
                db.close();
            }
            //do above till data exhausted
            mCursor.close();
            //  }
        } else {

            // insert();
        }

        int width = (int) (getResources().getDisplayMetrics().widthPixels * 0.60);
        int height = (int) (getResources().getDisplayMetrics().heightPixels * 0.35);
        dialog1.getWindow().setLayout(width, height);
        dialog1.show();


        ac_tb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (view.getTag().equals(0)) {
                    ac_tb.setBackgroundResource(R.drawable.on);
                    ac_data = "201";
                    view.setTag(1);
                    ac_tb.setTag(1);

                } else {
                    ac_tb.setBackgroundResource(R.drawable.off);
                    ac_data = "301";
                    view.setTag(0);
                    ac_tb.setTag(0);

                }
            }
        });

        mood_list.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, DisplayList.class);
                startActivity(i);
                finish();

            }
        });
        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog1.dismiss();
            }
        });

        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DatabaseHelper db2 = new DatabaseHelper(view.getContext());
                db2.getWritableDatabase();
                data = ac_data;
                // insert();
                dataBase = db.getWritableDatabase();
                mCursor = dataBase.rawQuery("SELECT * FROM " + TABLE_NAME, null);
                mCursor = dataBase.rawQuery("SELECT * FROM MoodSetTable WHERE MOOD_TYPE='" + mood_type + "'", null);
                Boolean rowExists;

                if (mCursor.moveToFirst()) {
                    db2.updateData(col_num, "1", "abcd", "1", switch_nam, devicee_name, devicee_num, "ON", data, moood_type);

                } else {
                    if (data != null && ac_data != null) {
                        insert();
                    } else {
                        Toast.makeText(MainActivity.this, "Please set data", Toast.LENGTH_LONG).show();
                    }
                }
                dialog1.dismiss();
            }
        });
    }

    private void sprinkler() {
        device_name = "Sprinkler";
        ac_data = null;
        final LayoutInflater inflater1 = getLayoutInflater();
        alertLayout = inflater1.inflate(R.layout.ac_popup, null);
        AlertDialog.Builder alert = new AlertDialog.Builder(MainActivity.this, R.style.MyDialogTheme1);

        alert.setView(alertLayout);
        alert.setCancelable(true);
        final AlertDialog dialog1 = alert.create();
        dialog1.show();
        Button mood_list = (Button) alertLayout.findViewById(R.id.mood_list);
        save = (Button) alertLayout.findViewById(R.id.save);
        cancel = (Button) alertLayout.findViewById(R.id.cancel);

        ac_tb = (Button) alertLayout.findViewById(R.id.ac_tb);

        ac_tb.setTag(0);


        dataBase = db.getWritableDatabase();
        //the SQL command to fetched all records from the table
        mCursor = dataBase.rawQuery("SELECT * FROM " + TABLE_NAME, null);
        //reset variables
        anum.clear();
        ahousenum.clear();
        ahousename.clear();
        aroomnum.clear();

        adevicename.clear();
        adevicenum.clear();
        aswitch1.clear();
        astatus.clear();
        adata.clear();
        amood_type.clear();


        if (mCursor.getCount() > 0) {
            //fetch each record
            if (mCursor.moveToFirst()) {
                //mCursor.moveToFirst();
                do {
                    if (mood_num.equals("1")) {
                        if (mCursor.getString(mCursor.getColumnIndex(MOOD_TYPE)).equals("sprimood1")) {
                            ac_status();
                        }
                    } else if (mood_num.equals("2")) {
                        if (mCursor.getString(mCursor.getColumnIndex(MOOD_TYPE)).equals("sprimood2")) {
                            ac_status();
                        }
                    } else if (mood_num.equals("3")) {
                        if (mCursor.getString(mCursor.getColumnIndex(MOOD_TYPE)).equals("sprimood3")) {
                            ac_status();
                        }
                    }
                } while (mCursor.moveToNext());
                db.close();
            }
            //do above till data exhausted
            mCursor.close();
            //  }
        } else {

            // insert();
        }

        int width = (int) (getResources().getDisplayMetrics().widthPixels * 0.60);
        int height = (int) (getResources().getDisplayMetrics().heightPixels * 0.35);
        dialog1.getWindow().setLayout(width, height);
        dialog1.show();


        ac_tb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (view.getTag().equals(0)) {
                    ac_tb.setBackgroundResource(R.drawable.on);
                    ac_data = "201";
                    view.setTag(1);
                    ac_tb.setTag(1);

                } else {
                    ac_tb.setBackgroundResource(R.drawable.off);
                    ac_data = "301";
                    view.setTag(0);
                    ac_tb.setTag(0);

                }
            }
        });

        mood_list.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, DisplayList.class);
                startActivity(i);
                finish();

            }
        });
        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog1.dismiss();
            }
        });

        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DatabaseHelper db2 = new DatabaseHelper(view.getContext());
                db2.getWritableDatabase();
                data = ac_data;
                // insert();
                dataBase = db.getWritableDatabase();
                mCursor = dataBase.rawQuery("SELECT * FROM " + TABLE_NAME, null);
                mCursor = dataBase.rawQuery("SELECT * FROM MoodSetTable WHERE MOOD_TYPE='" + mood_type + "'", null);
                Boolean rowExists;

                if (mCursor.moveToFirst()) {
                    db2.updateData(col_num, "1", "abcd", "1", switch_nam, devicee_name, devicee_num, "ON", data, moood_type);

                } else {
                    if (data != null && ac_data != null) {
                        insert();
                    } else {
                        Toast.makeText(MainActivity.this, "Please set data", Toast.LENGTH_LONG).show();
                    }
                }
                dialog1.dismiss();
            }
        });
    }

    private void doorlock() {
        device_name = "Doorlock";
        ac_data = null;
        final LayoutInflater inflater1 = getLayoutInflater();
        alertLayout = inflater1.inflate(R.layout.ac_popup, null);
        AlertDialog.Builder alert = new AlertDialog.Builder(MainActivity.this, R.style.MyDialogTheme1);

        alert.setView(alertLayout);
        alert.setCancelable(true);
        final AlertDialog dialog1 = alert.create();
        dialog1.show();
        Button mood_list = (Button) alertLayout.findViewById(R.id.mood_list);
        save = (Button) alertLayout.findViewById(R.id.save);
        cancel = (Button) alertLayout.findViewById(R.id.cancel);

        ac_tb = (Button) alertLayout.findViewById(R.id.ac_tb);

        ac_tb.setTag(0);


        dataBase = db.getWritableDatabase();
        //the SQL command to fetched all records from the table
        mCursor = dataBase.rawQuery("SELECT * FROM " + TABLE_NAME, null);
        //reset variables
        anum.clear();
        ahousenum.clear();
        ahousename.clear();
        aroomnum.clear();

        adevicename.clear();
        adevicenum.clear();
        aswitch1.clear();
        astatus.clear();
        adata.clear();
        amood_type.clear();


        if (mCursor.getCount() > 0) {
            //fetch each record
            if (mCursor.moveToFirst()) {
                //mCursor.moveToFirst();
                do {
                    if (mood_num.equals("1")) {
                        if (mCursor.getString(mCursor.getColumnIndex(MOOD_TYPE)).equals("dlckmood1")) {
                            ac_status();
                        }
                    } else if (mood_num.equals("2")) {
                        if (mCursor.getString(mCursor.getColumnIndex(MOOD_TYPE)).equals("dlckmood2")) {
                            ac_status();
                        }
                    } else if (mood_num.equals("3")) {
                        if (mCursor.getString(mCursor.getColumnIndex(MOOD_TYPE)).equals("dlckmood3")) {
                            ac_status();
                        }
                    }
                } while (mCursor.moveToNext());
                db.close();
            }
            //do above till data exhausted
            mCursor.close();
            //  }
        } else {

            // insert();
        }

        int width = (int) (getResources().getDisplayMetrics().widthPixels * 0.60);
        int height = (int) (getResources().getDisplayMetrics().heightPixels * 0.35);
        dialog1.getWindow().setLayout(width, height);
        dialog1.show();


        ac_tb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (view.getTag().equals(0)) {
                    ac_tb.setBackgroundResource(R.drawable.on);
                    ac_data = "201";
                    view.setTag(1);
                    ac_tb.setTag(1);

                } else {
                    ac_tb.setBackgroundResource(R.drawable.off);
                    ac_data = "301";
                    view.setTag(0);
                    ac_tb.setTag(0);

                }
            }
        });

        mood_list.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, DisplayList.class);
                startActivity(i);
                finish();

            }
        });
        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog1.dismiss();
            }
        });

        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DatabaseHelper db2 = new DatabaseHelper(view.getContext());
                db2.getWritableDatabase();
                data = ac_data;
                // insert();
                dataBase = db.getWritableDatabase();
                mCursor = dataBase.rawQuery("SELECT * FROM " + TABLE_NAME, null);
                mCursor = dataBase.rawQuery("SELECT * FROM MoodSetTable WHERE MOOD_TYPE='" + mood_type + "'", null);
                Boolean rowExists;

                if (mCursor.moveToFirst()) {
                    db2.updateData(col_num, "1", "abcd", "1", switch_nam, devicee_name, devicee_num, "ON", data, moood_type);

                } else {
                    if (data != null && ac_data != null) {
                        insert();
                    } else {
                        Toast.makeText(MainActivity.this, "Please set data", Toast.LENGTH_LONG).show();
                    }
                }
                dialog1.dismiss();
            }
        });
    }

    private void projector() {
        device_name = "Projector";
        pro_status = null;
        final LayoutInflater inflater1 = getLayoutInflater();
        alertLayout = inflater1.inflate(R.layout.projector_popup, null);
        AlertDialog.Builder alert = new AlertDialog.Builder(MainActivity.this, R.style.MyDialogTheme1);

        alert.setView(alertLayout);
        alert.setCancelable(true);
        final AlertDialog dialog1 = alert.create();
        dialog1.show();
        Button mood_list = (Button) alertLayout.findViewById(R.id.mood_list);
        save = (Button) alertLayout.findViewById(R.id.save);
        cancel = (Button) alertLayout.findViewById(R.id.cancel);

        btopen = (Button) alertLayout.findViewById(R.id.btopen);
        btclose = (Button) alertLayout.findViewById(R.id.btclose);
        btstop = (Button) alertLayout.findViewById(R.id.btstop);

        btopen.setTag(0);
        btclose.setTag(0);
        btstop.setTag(0);


        dataBase = db.getWritableDatabase();
        //the SQL command to fetched all records from the table
        mCursor = dataBase.rawQuery("SELECT * FROM " + TABLE_NAME, null);
        //reset variables
        anum.clear();
        ahousenum.clear();
        ahousename.clear();
        aroomnum.clear();

        adevicename.clear();
        adevicenum.clear();
        aswitch1.clear();
        astatus.clear();
        adata.clear();
        amood_type.clear();


        if (mCursor.getCount() > 0) {
            //fetch each record
            if (mCursor.moveToFirst()) {
                //mCursor.moveToFirst();
                do {
                    if (mood_num.equals("1")) {
                        if (mCursor.getString(mCursor.getColumnIndex(MOOD_TYPE)).equals("promood1")) {
                            proj_status();
                        }
                    } else if (mood_num.equals("2")) {
                        if (mCursor.getString(mCursor.getColumnIndex(MOOD_TYPE)).equals("promood2")) {
                            proj_status();
                        }
                    } else if (mood_num.equals("3")) {
                        if (mCursor.getString(mCursor.getColumnIndex(MOOD_TYPE)).equals("promood3")) {
                            proj_status();
                        }
                    }
                } while (mCursor.moveToNext());
                db.close();
            }
            //do above till data exhausted
            mCursor.close();
            //  }
        } else {

            // insert();
        }

        int width = (int) (getResources().getDisplayMetrics().widthPixels * 0.60);
        int height = (int) (getResources().getDisplayMetrics().heightPixels * 0.35);
        dialog1.getWindow().setLayout(width, height);
        dialog1.show();


        btopen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (view.getTag().equals(0)) {
                    btopen.setBackgroundResource(R.drawable.open01);
                    btclose.setBackgroundResource(R.drawable.close);
                    pro_status = "101";
                } else {
                    btopen.setBackgroundResource(R.drawable.open);
                    pro_status = "";
                }
            }
        });
      btclose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (view.getTag().equals(0)) {
                    btclose.setBackgroundResource(R.drawable.close01);

                    btopen.setBackgroundResource(R.drawable.open);
                    pro_status = "102";

                } else {
                    btclose.setBackgroundResource(R.drawable.close);
                    pro_status = "";

                }
            }
        });
        mood_list.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, DisplayList.class);
                startActivity(i);
                finish();

            }
        });
        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog1.dismiss();
            }
        });

        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DatabaseHelper db2 = new DatabaseHelper(view.getContext());
                db2.getWritableDatabase();
                data = pro_status;
                // insert();
                dataBase = db.getWritableDatabase();
                mCursor = dataBase.rawQuery("SELECT * FROM " + TABLE_NAME, null);
                mCursor = dataBase.rawQuery("SELECT * FROM MoodSetTable WHERE MOOD_TYPE='" + mood_type + "'", null);
                Boolean rowExists;

                if (mCursor.moveToFirst()) {
                    db2.updateData(col_num, "1", "abcd", "1", switch_nam, devicee_name, devicee_num, "ON", data, moood_type);

                } else {
                    if (data != null && pro_status != null) {
                        insert();
                    } else {
                        Toast.makeText(MainActivity.this, "Please set data", Toast.LENGTH_LONG).show();
                    }
                }
                dialog1.dismiss();
            }
        });
    }

    private void proj_status() {
        col_num = mCursor.getString(mCursor.getColumnIndex(DatabaseHelper.COLUMN_NO));
        house_number = mCursor.getString(mCursor.getColumnIndex(DatabaseHelper.HOUSE_NUM));
        house_names = mCursor.getString(mCursor.getColumnIndex(DatabaseHelper.HOUSE_NAME));
        room_number = mCursor.getString(mCursor.getColumnIndex(DatabaseHelper.ROOM_NUM));
        devicee_name = mCursor.getString(mCursor.getColumnIndex(DatabaseHelper.DEVICE_TYPE));
        devicee_num = mCursor.getString(mCursor.getColumnIndex(DatabaseHelper.DEVICE_NUM));
        switch_nam = mCursor.getString(mCursor.getColumnIndex(DatabaseHelper.SETTING_NUM));
        status_display = mCursor.getString(mCursor.getColumnIndex(DatabaseHelper.STATUS));
        adata.add(mCursor.getString(mCursor.getColumnIndex(DatabaseHelper.DATA)));
        moood_type = mCursor.getString(mCursor.getColumnIndex(MOOD_TYPE));
        dataa = mCursor.getString(mCursor.getColumnIndex(DatabaseHelper.DATA));


        String ondat = dataa;

        if (ondat.equals("101")) {
            btopen.setBackgroundResource(R.drawable.open01);
            pro_status = "101";
            // ac_tb.setTag(1);

        } else if (ondat.equals("102")) {
            btclose.setBackgroundResource(R.drawable.close01);
            pro_status = "102";

        }

    }


}
