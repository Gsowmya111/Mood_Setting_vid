package edison.vidya.mood_setting;

import android.content.Context;
import android.database.Cursor;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageButton;
import android.widget.TextView;

import java.util.ArrayList;

public class DisplayAdapter extends BaseAdapter {
    private Context mContext;
    //list fields to be displayed
    private ArrayList<String> anum;
    private ArrayList<String> ahousenum;
    private ArrayList<String> ahousename;
    private ArrayList<String> aroomnum;
    private ArrayList<String> adevicename;
    private ArrayList<String> adevicenum;
    private ArrayList<String> aswitch1;
    private ArrayList<String> astatus;
    private ArrayList<String> adata;
    private ArrayList<String> mood_type;
    private String one,two,three,four;
    private Object fsfs;
    static String number,housenumber,housenamee,roomnumber,devicenamee,devicenumber,switch1_namee,statuss,dataa,moood_type;
   static LayoutInflater layoutInflater;
    DatabaseHelper db = null;
    static String device_name;

    public DisplayAdapter(Context c, ArrayList<String> anum, ArrayList<String> ahousenum, ArrayList<String> ahousename, ArrayList<String> aroomnum, ArrayList<String> adevicename,ArrayList<String> adevicenum, ArrayList<String> aswitch1,ArrayList<String> astatus,ArrayList<String> adata,ArrayList<String> mood_type) {
        this.mContext = c;
        //transfer content from database to temporary memory
        this.anum = anum;

        this.ahousenum = ahousenum;
        this.ahousename = ahousename;
        this.aroomnum = aroomnum;

        this.adevicename = adevicename;
        this.adevicenum = adevicenum;
        this.aswitch1 = aswitch1;
        this.astatus = astatus;
        this.adevicename = adevicename;
        this.aswitch1 = aswitch1;
        this.astatus = astatus;
        this.adata = adata;
        this.mood_type = mood_type;
    }



    public int getCount() {
        // TODO Auto-generated method stub
        return anum.size();
    }

    public Object getItem(int position) {
        // TODO Auto-generated method stub
        return null;
    }

    public long getItemId(int position) {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public int getViewTypeCount() {

        return getCount();
    }

    @Override
    public int getItemViewType(int position) {

        return position;
    }

    public View getView(int pos, View child, ViewGroup parent) {
        Holder mHolder;

        if (child == null) {
            layoutInflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            child = layoutInflater.inflate(R.layout.single_item_list, null);
            mHolder = new Holder();

            //link to TextView
            mHolder.num = (TextView) child.findViewById(R.id.num);
            mHolder.devicename = (TextView) child.findViewById(R.id.devicename);
            mHolder.switch1 = (TextView) child.findViewById(R.id.switch1);
            mHolder.status = (TextView) child.findViewById(R.id.status);
            mHolder.data = (TextView) child.findViewById(R.id.data);
            mHolder.edit = (ImageButton) child.findViewById(R.id.edit);
            mHolder.delete = (ImageButton) child.findViewById(R.id.delete);
            child.setTag(mHolder);
        } else {
            mHolder = (Holder) child.getTag();
        }


        //transfer to TextView in screen
        mHolder.num.setText(anum.get(pos));
        mHolder.devicename.setText(adevicename.get(pos));
        mHolder.switch1.setText(aswitch1.get(pos));
        mHolder.status.setText(astatus.get(pos));
       // mHolder.data.setText(adata.get(pos));
        if(adevicename.get(pos).equals("RGB")) {
            String c = adata.get(pos);
            String splitTime[] = c.split(",");
            one = splitTime[0];
            two = splitTime[1];
            three = splitTime[2];
            four = splitTime[3];

            String splitTime1[] = four.split(";");
            String one1 = splitTime1[0];
            String two2 = splitTime1[1];
            String three3 = splitTime1[2];

            if (one.equals("0")) {
                int r = Integer.parseInt(two);
                int g = Integer.parseInt(three);
                int b = Integer.parseInt(one1);
                mHolder.data.setBackgroundColor(Color.rgb(r, g, b));
            } else {
                if (one.equals("104")) {
                    fsfs = "FLASH";
                } else if (one.equals("105")) {
                    fsfs = "STROBE";
                } else if (one.equals("106")) {
                    fsfs = "FADE";
                } else if (one.equals("107")) {
                    fsfs = "SMOOTH";
                } else {

                }
                mHolder.data.setText((CharSequence) fsfs);
            }
        }
        else  if(adevicename.get(pos).equals("Switch21")) {
            String c = adata.get(pos);
            mHolder.data.setText(c);
            }
        else  if(adevicename.get(pos).equals("Curtain")) {
            String c = adata.get(pos);
            mHolder.data.setText(c);
        }
        else  if(adevicename.get(pos).equals("AC")) {
            String c = adata.get(pos);
            mHolder.data.setText(c);
        }
        else  if(adevicename.get(pos).equals("BELL")) {
            String c = adata.get(pos);
            mHolder.data.setText(c);
        }
        else  if(adevicename.get(pos).equals("DOG")) {
            String c = adata.get(pos);
            mHolder.data.setText(c);
        }
        else  if(adevicename.get(pos).equals("GEYSER")) {
            String c = adata.get(pos);
            mHolder.data.setText(c);
        }
        else  if(adevicename.get(pos).equals("Sprinkler")) {
            String c = adata.get(pos);
            mHolder.data.setText(c);
        }
        else  if(adevicename.get(pos).equals("Doorlock")) {
            String c = adata.get(pos);
            mHolder.data.setText(c);
        }
        else  if(adevicename.get(pos).equals("Projector")) {
            String c = adata.get(pos);
            mHolder.data.setText(c);
        }
        else  if(adevicename.get(pos).equals("Dimmer")) {
            String c = adata.get(pos);
            mHolder.data.setText(c);
        }

        // mHolder.edit.setText(nama.get(pos));
       // mHolder.delete.setText(jbt.get(pos));

        mHolder.delete.setTag(pos);
        mHolder.delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Integer index = (Integer) view.getTag();
                number = anum.get(index.intValue());
                housenumber = ahousenum.get(index.intValue());
                housenamee = ahousename.get(index.intValue());
                roomnumber = aroomnum.get(index.intValue());

                devicenamee = adevicename.get(index.intValue());
                switch1_namee = aswitch1.get(index.intValue());
                statuss = astatus.get(index.intValue());
                dataa = adata.get(index.intValue());
                DisplayList r=new DisplayList();
                DatabaseHelper db = new DatabaseHelper(view.getContext());
                db.getWritableDatabase();
                db.delete(number);
            }
        });




        mHolder.edit.setTag(pos);
        mHolder.edit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Integer index = (Integer) view.getTag();
                number = anum.get(index.intValue());
                housenumber = ahousenum.get(index.intValue());
                housenamee = ahousename.get(index.intValue());
                roomnumber = aroomnum.get(index.intValue());

                devicenamee = adevicename.get(index.intValue());
                switch1_namee = aswitch1.get(index.intValue());
                statuss = astatus.get(index.intValue());
                dataa = adata.get(index.intValue());
                moood_type = mood_type.get(index.intValue());

                if (devicenamee.equals("Switch21")) {
                    device_name="Switch21";
                    DisplayList r=new DisplayList();
                    r.switch21();
                }
                else  if (devicenamee.equals("RGB")) {
                    device_name="RGB";
                    DisplayList r=new DisplayList();
                    r.rgb();
                }
                else  if (devicenamee.equals("Curtain")) {
                    device_name="Curtain";
                    DisplayList r=new DisplayList();
                    r.curtain();
                }
                else  if (devicenamee.equals("AC")) {
                    device_name="AC";
                    DisplayList r=new DisplayList();
                    r.ac();
                }
                else if (devicenamee.equals("BELL")) {
                    device_name="BELL";
                    DisplayList r=new DisplayList();
                    r.ac();
                }
                else  if (devicenamee.equals("DOG")) {
                    device_name="DOG";
                    DisplayList r=new DisplayList();
                    r.ac();
                }
                else  if (devicenamee.equals("GEYSER")) {
                    device_name="GEYSER";
                    DisplayList r=new DisplayList();
                    r.ac();
                }
                else  if (devicenamee.equals("Sprinkler")) {
                    device_name="Sprinkler";
                    DisplayList r=new DisplayList();
                    r.ac();
                }
                else  if (devicenamee.equals("Doorlock")) {
                    device_name="Doorlock";
                    DisplayList r=new DisplayList();
                    r.ac();
                }
                else  if (devicenamee.equals("Projector")) {
                    device_name="Projector";
                    DisplayList r=new DisplayList();
                    r.projector();
                }
                else  if (devicenamee.equals("Dimmer")) {
                    device_name="Dimmer";
                    DisplayList r=new DisplayList();
                    r.dimmer();
                }
            }
        });

        return child;
    }

    public class Holder {
        TextView num;
        TextView devicename;
        TextView switch1;
        public TextView status;
        public TextView data;
        public ImageButton edit;
        public ImageButton delete;
    }

}