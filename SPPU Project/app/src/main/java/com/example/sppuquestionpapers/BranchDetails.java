package com.example.sppuquestionpapers;


import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;

public class BranchDetails extends AppCompatActivity {

    HashMap<Integer, String> innerMap = new HashMap<Integer, String>(); // Subject data
    HashMap<String, HashMap<Integer, String>> outerMap = new HashMap<>(); // Paper and corresponding links
    String branchName="";

    Integer position;
    int pos;
    String[] compSecondSubs = {"DM","DELD","DSA","COA","OOP","M3","CG","ADS","MP","PPL"};
    String[] compThirdSubs = {"TOC","DBMS","SEPM","ISEE","CN","DAA","SPOS","ESIT","SMD","WT"};
    String[] compFourthSubs = {"HPC","AIR","DA","DMW","STQA","ML","ICS","ERS","CC"};

    String[] entcSecondSubs = {"SS","EDC","ECM","DSAENTC","DE","M3ENTC","IC","CS","AC","OOPENTC"};
    String[] entcThirdSubs = {"DC","DSP","EM","MC","MTENTC","PEENTC","ITCCN","BM","AP","SPOSENTC"};
    String[] entcFouthSubs = {"CNS","ESRTOS","IOT","EPD","RMT","VLSI","AVE","WSN","MoC","BCS"};

    String[] itSecondSubs = {"DS","COAIT","DELDIT","FDA","PSOOP","M3IT","CGIT","PAI","DSF","FCCN"};
    String[] itThirdSubs = {"TOCIT","DBMSIT","SEPMIT","OS","HCI","CNT","SP","DAAIT","CCIT","DSBDA"};
    String[] itFouthSubs = {"ICSIT","MLA","SDM","BAI","STQAIT","DCS","UC","ISR","SMA"};

    String[] mechSecondSubs = {"M3MECH","MP1","TD","MS","SOM","FM","TOM1","EMT","AT","EEE"};
    String[] mechThirdSubs = {"DME1","HT","TOM2","TM","MQC","NMO","DME2","RAC","MT","MP2"};
    String[] mechFouthSubs = {"HP","CADCAM","DMMECH","FEA","HVAC","EAM","AE","OR","EE","MSD","IE","SWE","PDD","AMP","RAC4"};  // NEED TO CREATE EXTRA LIST. . .

    String[] electricalSecondSubs = {"PGT","M3ELEC","MSELEC","ADE","EMI","PS1","EM1","NA","NMCP","FMA"};
    String[] electricalThirdSubs = {"ITM","AMA","EM2","PE","EIMT","PS2","CS1","UEE","DEM","EAMELEC"};
    String[] electricalFouthSubs = {"PSOC","PLC","CS2","PQ","EHVACT","EHV","SPELEC","PECD","HVE","SG"};

    String[] fe2015Subs = {"BXE15","BEE15","BCEE15","BME15","M115","M215","EP15","EM15","EC15","EG115"};
    String[] fe2019Subs = {"M119","EP19","EC19","SME19","BEE19","BXE19","PPS19","EM19","M219"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // to make action bar disappear.
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        getSupportActionBar().hide();


        setContentView(R.layout.activity_branch_details);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        final ListView listView = (ListView) findViewById(R.id.OurListView);

        //TextView subTextView = (TextView) findViewById(R.id.toolbarBranch);

        Intent intent = getIntent();
        if (intent.hasExtra("comp2")) {
            ArrayList<String> branch = (ArrayList<String>) getIntent().getSerializableExtra("comp2");
            ArrayAdapter<String> transferList = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, branch);
            // subTextView.setText("Computer - SE");
            listView.setAdapter(transferList);
            listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                    compcase(compSecondSubs, position);
                }
            });


        } else if (intent.hasExtra("comp3")) {
            ArrayList<String> branch = (ArrayList<String>) getIntent().getSerializableExtra("comp3");
            ArrayAdapter<String> transferList = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, branch);

            listView.setAdapter(transferList);
            listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                    compcase(compThirdSubs, position);
                }
            });

        } else if (intent.hasExtra("comp4")) {
            ArrayList<String> branch = (ArrayList<String>) getIntent().getSerializableExtra("comp4");
            ArrayAdapter<String> transferList = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, branch);

            listView.setAdapter(transferList);
            listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                    compcase(compFourthSubs, position);
                }
            });

        } else if (intent.hasExtra("entc2")) {
            ArrayList<String> branch = (ArrayList<String>) getIntent().getSerializableExtra("entc2");
            ArrayAdapter<String> transferList = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, branch);

            listView.setAdapter(transferList);
            listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                    compcase(entcSecondSubs, position);
                }
            });

        } else if (intent.hasExtra("entc3")) {
            ArrayList<String> branch = (ArrayList<String>) getIntent().getSerializableExtra("entc3");
            ArrayAdapter<String> transferList = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, branch);

            listView.setAdapter(transferList);
            listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                    compcase(entcThirdSubs, position);
                }
            });

        } else if (intent.hasExtra("entc4")) {
            ArrayList<String> branch = (ArrayList<String>) getIntent().getSerializableExtra("entc4");
            ArrayAdapter<String> transferList = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, branch);

            listView.setAdapter(transferList);
            listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                    compcase(entcFouthSubs, position);
                }
            });

        } else if (intent.hasExtra("it2")) {
            ArrayList<String> branch = (ArrayList<String>) getIntent().getSerializableExtra("it2");
            ArrayAdapter<String> transferList = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, branch);

            listView.setAdapter(transferList);
            listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                    compcase(itSecondSubs, position);
                }
            });

        } else if (intent.hasExtra("it3")) {
            ArrayList<String> branch = (ArrayList<String>) getIntent().getSerializableExtra("it3");
            ArrayAdapter<String> transferList = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, branch);

            listView.setAdapter(transferList);
            listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                    compcase(itThirdSubs, position);
                }
            });

        } else if (intent.hasExtra("it4")) {
            ArrayList<String> branch = (ArrayList<String>) getIntent().getSerializableExtra("it4");
            ArrayAdapter<String> transferList = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, branch);

            listView.setAdapter(transferList);
            listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                    compcase(itFouthSubs, position);
                }
            });

        } else if (intent.hasExtra("elec2")) {
            ArrayList<String> branch = (ArrayList<String>) getIntent().getSerializableExtra("elec2");
            ArrayAdapter<String> transferList = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, branch);

            listView.setAdapter(transferList);
            listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                    compcase(electricalSecondSubs, position);
                }
            });

        } else if (intent.hasExtra("elec3")) {
            ArrayList<String> branch = (ArrayList<String>) getIntent().getSerializableExtra("elec3");
            ArrayAdapter<String> transferList = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, branch);

            listView.setAdapter(transferList);
            listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                    compcase(electricalThirdSubs, position);
                }
            });

        } else if (intent.hasExtra("elec4")) {
            ArrayList<String> branch = (ArrayList<String>) getIntent().getSerializableExtra("elec4");
            ArrayAdapter<String> transferList = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, branch);

            listView.setAdapter(transferList);
            listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                    compcase(electricalFouthSubs, position);
                }
            });

        } else if (intent.hasExtra("mech2")) {
            ArrayList<String> branch = (ArrayList<String>) getIntent().getSerializableExtra("mech2");
            ArrayAdapter<String> transferList = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, branch);

            listView.setAdapter(transferList);
            listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                    compcase(mechSecondSubs, position);
                }
            });

        } else if (intent.hasExtra("mech3")) {
            ArrayList<String> branch = (ArrayList<String>) getIntent().getSerializableExtra("mech3");
            ArrayAdapter<String> transferList = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, branch);

            listView.setAdapter(transferList);
            listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                    compcase(mechThirdSubs, position);
                }
            });

        } else if (intent.hasExtra("mech4")) {
            ArrayList<String> branch = (ArrayList<String>) getIntent().getSerializableExtra("mech4");
            ArrayAdapter<String> transferList = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, branch);

            listView.setAdapter(transferList);
            listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                    compcase(mechFouthSubs, position);
                }
            });

        } else if (intent.hasExtra("fe15")) {
            ArrayList<String> branch = (ArrayList<String>) getIntent().getSerializableExtra("fe15");
            ArrayAdapter<String> transferList = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, branch);

            listView.setAdapter(transferList);
            listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                    compcase(fe2015Subs, position);
                }
            });

        } else if (intent.hasExtra("fe19")) {
            ArrayList<String> branch = (ArrayList<String>) getIntent().getSerializableExtra("fe19");
            ArrayAdapter<String> transferList = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, branch);

            listView.setAdapter(transferList);
            listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                    compcase(fe2019Subs, position);
                }
            });

        } else {
            Toast.makeText(getApplicationContext(), "Unable to load....", Toast.LENGTH_SHORT).show();
        }

    }

    private void compcase(String[] yearSubArray, int pos)
    {
        if (pos==0) {
            Intent intent = new Intent(getApplicationContext(),PaperDetails.class);
            intent.putExtra("sub0",yearSubArray[0]);
            startActivity(intent);
        }
        else if (pos==1) {
            Intent intent = new Intent(getApplicationContext(),PaperDetails.class);
            intent.putExtra("sub1",yearSubArray[1]);
            startActivity(intent);
        }
        else if(pos==2){
            Intent intent = new Intent(getApplicationContext(),PaperDetails.class);
            intent .putExtra("sub2",yearSubArray[2]);
            startActivity(intent );
        }
        else if(pos==3){
            Intent intent = new Intent(getApplicationContext(),PaperDetails.class);
            intent .putExtra("sub3",yearSubArray[3]);
            startActivity(intent );
        }
        else if(pos==4){
            Intent intent= new Intent(getApplicationContext(),PaperDetails.class);
            intent.putExtra("sub4",yearSubArray[4]);
            startActivity(intent);
        }
        else if(pos==5){
            Intent intent = new Intent(getApplicationContext(),PaperDetails.class);
            intent .putExtra("sub5",yearSubArray[5]);
            startActivity(intent );
        }
        else if(pos==6){
            Intent intent = new Intent(getApplicationContext(),PaperDetails.class);
            intent.putExtra("sub6",yearSubArray[6]);
            startActivity(intent );
        }
        else if(pos==7){
            Intent intent = new Intent(getApplicationContext(),PaperDetails.class);
            intent .putExtra("sub7",yearSubArray[7]);
            startActivity(intent);
        }
        else if(pos==8){
            Intent intent = new Intent(getApplicationContext(),PaperDetails.class);
            intent .putExtra("sub8",yearSubArray[8]);
            startActivity(intent );
        }
        else if(pos==9){
            Intent intent = new Intent(getApplicationContext(),PaperDetails.class);
            intent.putExtra("sub9",yearSubArray[9]);
            startActivity(intent );
        }
        else if(pos==10){
            Intent intent = new Intent(getApplicationContext(),PaperDetails.class);
            intent .putExtra("sub10",yearSubArray[10]);
            startActivity(intent);
        }
        else if(pos==11){
            Intent intent = new Intent(getApplicationContext(),PaperDetails.class);
            intent .putExtra("sub11",yearSubArray[11]);
            startActivity(intent);
        }
        else if(pos==12){
            Intent intent = new Intent(getApplicationContext(),PaperDetails.class);
            intent.putExtra("sub12",yearSubArray[12]);
            startActivity(intent );
        }
        else if(pos==13){
            Intent intent= new Intent(getApplicationContext(),PaperDetails.class);
            intent .putExtra("sub13",yearSubArray[13]);
            startActivity(intent );
        }
        else if(pos==14){
            Intent intent= new Intent(getApplicationContext(),PaperDetails.class);
            intent .putExtra("sub14",yearSubArray[14]);
            startActivity(intent );
        }

    }
}