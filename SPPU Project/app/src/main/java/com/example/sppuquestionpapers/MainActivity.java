package com.example.sppuquestionpapers;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.ListPopupWindow;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Intent;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageButton;
import android.widget.PopupMenu;
import android.widget.PopupWindow;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    final ArrayList<String> compSecondYearArray = new ArrayList<String>();          //comp
    final ArrayList<String> compThirdYearArray = new ArrayList<String>();
    final ArrayList<String> compFourthYearArray = new ArrayList<String>();
    final ArrayList<String> entcSecondYearArray = new ArrayList<String>();          //entc
    final ArrayList<String> entcThirdYearArray = new ArrayList<String>();
    final ArrayList<String> entcFourthYearArray = new ArrayList<String>();
    final ArrayList<String> itSecondYearArray = new ArrayList<String>();            //it
    final ArrayList<String> itThirdYearArray = new ArrayList<String>();
    final ArrayList<String> itFourthYearArray = new ArrayList<String>();
    final ArrayList<String> elecSecondYearArray = new ArrayList<String>();          //elec
    final ArrayList<String> elecThirdYearArray = new ArrayList<String>();
    final ArrayList<String> elecFourthYearArray = new ArrayList<String>();
    final ArrayList<String> mechSecondYearArray = new ArrayList<String>();          //mech
    final ArrayList<String> mechThirdYearArray = new ArrayList<String>();
    final ArrayList<String> mechFourthYearArray = new ArrayList<String>();
    final ArrayList<String> firstYear2015Array = new ArrayList<String>();           //firstYear
    final ArrayList<String> firstYear2019Array = new ArrayList<String>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // to make action bar disappear.
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        getSupportActionBar().hide();


        setContentView(R.layout.activity_main);
        getSupportActionBar().setDisplayShowTitleEnabled(false); //shows no text in the action bar


        //ID's

        final ImageButton compImageButton = (ImageButton)findViewById(R.id.compImage);
        final ImageButton entcImageButton = (ImageButton)findViewById(R.id.entcImage);
        final ImageButton itImageButton = (ImageButton)findViewById(R.id.itImage);
        final ImageButton elecImageButton = (ImageButton)findViewById(R.id.elecImage);
        final ImageButton mechImageButton = (ImageButton)findViewById(R.id.mechImage);
        final ImageButton firstyearImageButton = (ImageButton)findViewById(R.id.firstyearimage);
        //back_dim_layout = (RelativeLayout) findViewById(R.id.share_bac_dim_layout);


        //Computer

        compImageButton.setOnClickListener(new View.OnClickListener() {
                                               @Override
                                               public void onClick(View v) {
                                                   WindowManager.LayoutParams windowManager = getWindow().getAttributes();
                                                   ((WindowManager.LayoutParams) windowManager).dimAmount = 0.90f;
                                                   getWindow().addFlags(WindowManager.LayoutParams.FLAG_DIM_BEHIND);

                                                   //Creating the instance of PopupMenu
                                                   PopupMenu popup = new PopupMenu(MainActivity.this, compImageButton);
                                                   //Inflating the Popup using xml file
                                                   popup.getMenuInflater().inflate(R.menu.popup_menu, popup.getMenu());

                                                   //registering popup with OnMenuItemClickListener
                                                   popup.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                                                       public boolean onMenuItemClick(MenuItem item) {
                                                           switch (item.getItemId()) {
                                                               case R.id.second:
                                                                   compSecondYearSubjects();
                                                                   Intent intent=new Intent(getApplicationContext(), BranchDetails.class);
                                                                   intent.putExtra("comp2",compSecondYearArray);
                                                                   startActivity(intent);
                                                                   return true;
                                                               case R.id.third:
                                                                   compThirdYearSubjects();
                                                                   Intent intent1=new Intent(getApplicationContext(), BranchDetails.class);
                                                                   intent1.putExtra("comp3",compThirdYearArray);
                                                                   startActivity(intent1);
                                                                   return true;
                                                               case R.id.fourth:
                                                                   compFourthYearSubjects();
                                                                   Intent intent2=new Intent(getApplicationContext(), BranchDetails.class);
                                                                   intent2.putExtra("comp4",compFourthYearArray);
                                                                   startActivity(intent2);
                                                                   return true;
                                                               default:
                                                                   return false;
                                                           }


                                                       }
                                                   });

                                                   popup.show();//showing popup menu

                                               }
                                           }
        );


        //ENTC

        entcImageButton.setOnClickListener(new View.OnClickListener() {
                                               @Override
                                               public void onClick(View v) {
                                                   //Creating the instance of PopupMenu
                                                   PopupMenu popup = new PopupMenu(MainActivity.this, entcImageButton);
                                                   //Inflating the Popup using xml file
                                                   popup.getMenuInflater().inflate(R.menu.popup_menu, popup.getMenu());
                                                   //registering popup with OnMenuItemClickListener
                                                   popup.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                                                       public boolean onMenuItemClick(MenuItem item) {
                                                           switch (item.getItemId()) {
                                                               case R.id.second:
                                                                   entcSecondYearSubjects();
                                                                   Intent intent=new Intent(getApplicationContext(), BranchDetails.class);
                                                                   intent.putExtra("entc2",entcSecondYearArray);
                                                                   startActivity(intent);
                                                                   return true;
                                                               case R.id.third:
                                                                   entcThirdYearSubjects();
                                                                   Intent intent1=new Intent(getApplicationContext(), BranchDetails.class);
                                                                   intent1.putExtra("entc3",entcThirdYearArray);
                                                                   startActivity(intent1);
                                                                   return true;
                                                               case R.id.fourth:
                                                                   entcFourthYearSubjects();
                                                                   Intent intent2=new Intent(getApplicationContext(), BranchDetails.class);
                                                                   intent2.putExtra("entc4",entcFourthYearArray);
                                                                   startActivity(intent2);
                                                                   return true;
                                                               default:
                                                                   return false;
                                                           }
                                                       }
                                                   });
                                                   popup.show();//showing popup menu
                                               }
                                           }
        );


        //IT

        itImageButton.setOnClickListener(new View.OnClickListener() {
                                             @Override
                                             public void onClick(View v) {
                                                 //Creating the instance of PopupMenu
                                                 PopupMenu popup = new PopupMenu(MainActivity.this, itImageButton);
                                                 //Inflating the Popup using xml file
                                                 popup.getMenuInflater().inflate(R.menu.popup_menu, popup.getMenu());
                                                 //registering popup with OnMenuItemClickListener
                                                 popup.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                                                     public boolean onMenuItemClick(MenuItem item) {
                                                         switch (item.getItemId()) {
                                                             case R.id.second:
                                                                 itSecondYearSubjects();
                                                                 Intent intent=new Intent(getApplicationContext(), BranchDetails.class);
                                                                 intent.putExtra("it2",itSecondYearArray);
                                                                 startActivity(intent);
                                                                 return true;
                                                             case R.id.third:
                                                                 itThirdYearSubjects();
                                                                 Intent intent1=new Intent(getApplicationContext(), BranchDetails.class);
                                                                 intent1.putExtra("it3",itThirdYearArray);
                                                                 startActivity(intent1);
                                                                 return true;
                                                             case R.id.fourth:
                                                                 itFourthYearSubjects();
                                                                 Intent intent2=new Intent(getApplicationContext(), BranchDetails.class);
                                                                 intent2.putExtra("it4",itFourthYearArray);
                                                                 startActivity(intent2);
                                                                 return true;
                                                             default:
                                                                 return false;
                                                         }
                                                     }
                                                 });
                                                 popup.show();//showing popup menu
                                             }
                                         }
        );

        //Electrical

        elecImageButton.setOnClickListener(new View.OnClickListener() {
                                               @Override
                                               public void onClick(View v) {
                                                   //Creating the instance of PopupMenu
                                                   PopupMenu popup = new PopupMenu(MainActivity.this, elecImageButton);
                                                   //Inflating the Popup using xml file
                                                   popup.getMenuInflater().inflate(R.menu.popup_menu, popup.getMenu());
                                                   //registering popup with OnMenuItemClickListener
                                                   popup.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                                                       public boolean onMenuItemClick(MenuItem item) {
                                                           switch (item.getItemId()) {
                                                               case R.id.second:
                                                                   elecSecondYearSubjects();
                                                                   Intent intent=new Intent(getApplicationContext(), BranchDetails.class);
                                                                   intent.putExtra("elec2",elecSecondYearArray);
                                                                   startActivity(intent);
                                                                   return true;
                                                               case R.id.third:
                                                                   elecThirdYearSubjects();
                                                                   Intent intent1=new Intent(getApplicationContext(), BranchDetails.class);
                                                                   intent1.putExtra("elec3", elecThirdYearArray);
                                                                   startActivity(intent1);
                                                                   return true;
                                                               case R.id.fourth:
                                                                   elecFourthYearSubjects();
                                                                   Intent intent2=new Intent(getApplicationContext(), BranchDetails.class);
                                                                   intent2.putExtra("elec4",elecFourthYearArray);
                                                                   startActivity(intent2);
                                                                   return true;
                                                               default:
                                                                   return false;
                                                           }
                                                       }
                                                   });
                                                   popup.show();//showing popup menu
                                               }
                                           }
        );

        //Mechanical

        mechImageButton.setOnClickListener(new View.OnClickListener() {
                                               @Override
                                               public void onClick(View v) {
                                                   //Creating the instance of PopupMenu
                                                   PopupMenu popup = new PopupMenu(MainActivity.this, mechImageButton);
                                                   //Inflating the Popup using xml file
                                                   popup.getMenuInflater().inflate(R.menu.popup_menu, popup.getMenu());
                                                   //registering popup with OnMenuItemClickListener
                                                   popup.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                                                       public boolean onMenuItemClick(MenuItem item) {
                                                           switch (item.getItemId()) {
                                                               case R.id.second:
                                                                   mechSecondYearSubjects();
                                                                   Intent intent=new Intent(getApplicationContext(), BranchDetails.class);
                                                                   intent.putExtra("mech2",mechSecondYearArray);
                                                                   startActivity(intent);
                                                                   return true;
                                                               case R.id.third:
                                                                   mechThirdYearSubjects();
                                                                   Intent intent1=new Intent(getApplicationContext(), BranchDetails.class);
                                                                   intent1.putExtra("mech3",mechThirdYearArray);
                                                                   startActivity(intent1);
                                                                   return true;
                                                               case R.id.fourth:
                                                                   mechFourthYearSubjects();
                                                                   Intent intent2=new Intent(getApplicationContext(), BranchDetails.class);
                                                                   intent2.putExtra("mech4",mechFourthYearArray);
                                                                   startActivity(intent2);
                                                                   return true;
                                                               default:
                                                                   return false;
                                                           }
                                                       }
                                                   });
                                                   popup.show();//showing popup menu
                                               }
                                           }
        );

        //FirstYear
        firstyearImageButton.setOnClickListener(new View.OnClickListener() {
                                                    @Override
                                                    public void onClick(View v) {
                                                        //Creating the instance of PopupMenu
                                                        PopupMenu popup = new PopupMenu(MainActivity.this, firstyearImageButton);
                                                        //Inflating the Popup using xml file
                                                        popup.getMenuInflater().inflate(R.menu.popup_menu_fe, popup.getMenu());
                                                        //registering popup with OnMenuItemClickListener
                                                        popup.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                                                            public boolean onMenuItemClick(MenuItem item) {
                                                                switch (item.getItemId()) {
                                                                    case R.id.fe2015:
                                                                        firstYear2015Subjects();
                                                                        Intent intent=new Intent(getApplicationContext(), BranchDetails.class);
                                                                        intent.putExtra("fe15",firstYear2015Array);
                                                                        startActivity(intent);
                                                                        return true;
                                                                    case R.id.fe2019:
                                                                        firstYear2019Subjects();
                                                                        Intent intent1=new Intent(getApplicationContext(), BranchDetails.class);
                                                                        intent1.putExtra("fe19",firstYear2019Array);
                                                                        startActivity(intent1);
                                                                        return true;
                                                                    default:
                                                                        return false;
                                                                }
                                                            }
                                                        });
                                                        popup.show();//showing popup menu
                                                    }
                                                }
        );


    };
//COMP SUBJECTS

    public void compSecondYearSubjects() {
        compSecondYearArray.clear();
        compSecondYearArray.add("Discrete Mathematics");
        compSecondYearArray.add("Digital Electronics and Logic Design");
        compSecondYearArray.add("Data Structures and Algorithms");
        compSecondYearArray.add("Computer Organization and Architecture");
        compSecondYearArray.add("Object Oriented Programming");
        compSecondYearArray.add("Engineering Mathematics III");
        compSecondYearArray.add("Computer Graphics");
        compSecondYearArray.add("Advanced Data Structures");
        compSecondYearArray.add("Microprocessor");
        compSecondYearArray.add("Principles of Programming Languages");
    }
    public void compThirdYearSubjects() {
        compThirdYearArray.clear();
        compThirdYearArray.add("Theory of Computation");
        compThirdYearArray.add("Database Management Systems");
        compThirdYearArray.add("Software Engg & Project Management");
        compThirdYearArray.add("Information Systems & Engg Economics");
        compThirdYearArray.add("Computer Network");
        compThirdYearArray.add("Design & Analysis of Algorithm");
        compThirdYearArray.add("Systems Prog & Operating System");
        compThirdYearArray.add("Embedded System & Internet Things");
        compThirdYearArray.add("Software Modeling & Design");
        compThirdYearArray.add("Web Technology");
    }
    public void compFourthYearSubjects() {
        compFourthYearArray.clear();
        compFourthYearArray.add("High Performance Computing");
        compFourthYearArray.add("Artificial Intelligence & Robotics");
        compFourthYearArray.add("Data Analytics");
        compFourthYearArray.add("Data Mining & Warehousing");
        compFourthYearArray.add("Software Testing & Quality Assurance");
        compFourthYearArray.add("Machine Learning");
        compFourthYearArray.add("Information & Cyber Security");
        compFourthYearArray.add("Embedded & RTO System");
        compFourthYearArray.add("Cloud Computing");
    }


//ENTC SUBJECTS

    public void entcSecondYearSubjects() {
        entcSecondYearArray.clear();
        entcSecondYearArray.add("Signals and Systems");
        entcSecondYearArray.add("Electronic Devices and Circuits");
        entcSecondYearArray.add("Electrical Circuits and Machines");
        entcSecondYearArray.add("Data Structures and Algorithms");
        entcSecondYearArray.add("Digital Electronics");
        entcSecondYearArray.add("Engineering Mathematics III");
        entcSecondYearArray.add("Integrated Circuits");
        entcSecondYearArray.add("Control Systems");
        entcSecondYearArray.add("Analog Communications");
        entcSecondYearArray.add("Object Oriented Programming");
    }
    public void entcThirdYearSubjects() {
        entcThirdYearArray.clear();
        entcThirdYearArray.add("Digital Communications");
        entcThirdYearArray.add("Digital Signal Processing");
        entcThirdYearArray.add("Electromagnetics");
        entcThirdYearArray.add("MicroControllers");
        entcThirdYearArray.add("Mechatronics");
        entcThirdYearArray.add("Power Electronics");
        entcThirdYearArray.add("Info Theory, Coding & Computer Networks");
        entcThirdYearArray.add("Business Management");
        entcThirdYearArray.add("Advanced Processors");
        entcThirdYearArray.add("System Programming & Operating System");
    }
    public void entcFourthYearSubjects(){
        entcFourthYearArray.clear();
        entcFourthYearArray.add("Computer Networks & Security");
        entcFourthYearArray.add("Embedded System & RTOS");
        entcFourthYearArray.add("Internet of Things");
        entcFourthYearArray.add("Electronics Product Design");
        entcFourthYearArray.add("Radiation & Microwave Techniques");
        entcFourthYearArray.add("VLSI Design & Technology");
        entcFourthYearArray.add("Audio Video Engineering");
        entcFourthYearArray.add("Wireless Sensor Networks");
        entcFourthYearArray.add("Mobile Communications");
        entcFourthYearArray.add("BroadBand Communication Systems");
    }

//IT SUBJECTS

    public void itSecondYearSubjects() {
        itSecondYearArray.clear();
        itSecondYearArray.add("Discrete Structures");
        itSecondYearArray.add("Computer Organization and Architecture");
        itSecondYearArray.add("Digital Electronics and Logic Design");
        itSecondYearArray.add("Fundamentals of Data Structures");
        itSecondYearArray.add("Problem Solving & Object Oriented Prog Concepts");
        itSecondYearArray.add("Engineering Mathematics III");
        itSecondYearArray.add("Computer Graphics");
        itSecondYearArray.add("Processor Architecture and Interfacing");
        itSecondYearArray.add("Data Structures and Files");
        itSecondYearArray.add("Foundations of Communication & Computer Networks");
    }
    public void itThirdYearSubjects() {
        itThirdYearArray.clear();
        itThirdYearArray.add("Theory of Computation");
        itThirdYearArray.add("Database Management Systems");
        itThirdYearArray.add("Software Engg & Project Management");
        itThirdYearArray.add("Operating System");
        itThirdYearArray.add("Human Computer Interaction");
        itThirdYearArray.add("Computer Network Technology");
        itThirdYearArray.add("Systems Programming");
        itThirdYearArray.add("Design & Analysis of Algorithms");
        itThirdYearArray.add("Cloud Computing");
        itThirdYearArray.add("Data Science & Big Data Analytics");
    }
    public void itFourthYearSubjects() {
        itFourthYearArray.clear();
        itFourthYearArray.add("Information & Cyber Security");
        itFourthYearArray.add("Machine Learning & Application");
        itFourthYearArray.add("Software Design & Modelling");
        itFourthYearArray.add("Business Analytics & Intelligence");
        itFourthYearArray.add("Software Testing & Quality Assurance");
        itFourthYearArray.add("Distributed Computing System");
        itFourthYearArray.add("Ubiquitous Computing");
        itFourthYearArray.add("Information Storage & Retrieval");
        itFourthYearArray.add("Social Media Analytics");
    }


//ELEC SUBJECTS

    public void elecSecondYearSubjects() {
        elecSecondYearArray.clear();
        elecSecondYearArray.add("Power Generation Technology");
        elecSecondYearArray.add("Engineering Mathematics III");
        elecSecondYearArray.add("Material Science");
        elecSecondYearArray.add("Analog & Digital Electronics");
        elecSecondYearArray.add("Electrical Measurements & Instrumentation");
        elecSecondYearArray.add("Power System-I");
        elecSecondYearArray.add("Electrical Machines-I");
        elecSecondYearArray.add("Network Analysis");
        elecSecondYearArray.add("Numerical Methods & Computer Prog");
        elecSecondYearArray.add("Fundamentals of MicroController & App");
    }
    public void elecThirdYearSubjects(){
        elecThirdYearArray.clear();
        elecThirdYearArray.add("Industrial & Technology Management");
        elecThirdYearArray.add("Advance MicroController & Its Applications");
        elecThirdYearArray.add("Electrical Machines-II");
        elecThirdYearArray.add("Power Electronics");
        elecThirdYearArray.add("Electrical Insta Maintenance & Testing");
        elecThirdYearArray.add("Power System-II");
        elecThirdYearArray.add("Control System-I");
        elecThirdYearArray.add("Utilisation of Electrical Energy");
        elecThirdYearArray.add("Design of Electrical Machines");
        elecThirdYearArray.add("Energy Audit & Management");
    }
    public void elecFourthYearSubjects(){
        elecFourthYearArray.clear();
        elecFourthYearArray.add("Power System Opertion & Control");
        elecFourthYearArray.add("PLC & SCADA Applications");
        elecFourthYearArray.add("Control System-II");
        elecFourthYearArray.add("Power Quality");
        elecFourthYearArray.add("EHV AC Transmission");
        elecFourthYearArray.add("Electric & Hybrid Vehicles");
        elecFourthYearArray.add("Switchgear & Protection");
        elecFourthYearArray.add("Power Electronics Controlled Drives");
        elecFourthYearArray.add("High Voltage Engineering");
        elecFourthYearArray.add("Smart Grid");
    }

//MECHANICAL SUBJECTS

    public void mechSecondYearSubjects() {
        mechSecondYearArray.clear();
        mechSecondYearArray.add("Engineering Mathematics III");
        mechSecondYearArray.add("Manufacturing Processes-I");
        mechSecondYearArray.add("Thermodynamics");
        mechSecondYearArray.add("Material Science");
        mechSecondYearArray.add("Strength Of Materials");
        mechSecondYearArray.add("Fluid Mechanics");
        mechSecondYearArray.add("Theory of Machines-I");
        mechSecondYearArray.add("Engineering Metallurgy");
        mechSecondYearArray.add("Applied Thermodynamics");
        mechSecondYearArray.add("Electrical & Electronics Engineering");
    }
    public void mechThirdYearSubjects() {
        mechThirdYearArray.clear();
        mechThirdYearArray.add("Design of Machine Elements-I");
        mechThirdYearArray.add("Heat Transfer");
        mechThirdYearArray.add("Theory of Machines-II");
        mechThirdYearArray.add("Turbo Machines");
        mechThirdYearArray.add("Metrology & Quality Control");
        mechThirdYearArray.add("Numerical Methods & Optimisation");
        mechThirdYearArray.add("Design of Machine Elements-II");
        mechThirdYearArray.add("Refrigeration & Air Condition");
        mechThirdYearArray.add("Mechatronics");
        mechThirdYearArray.add("Manufacturing Processes-II");
    }
    public void mechFourthYearSubjects() {
        mechFourthYearArray.clear();
        mechFourthYearArray.add("Hydraulics & Pneumatics");
        mechFourthYearArray.add("CAD, CAM & Automation");
        mechFourthYearArray.add("Dynamics of Machinery");
        mechFourthYearArray.add("Finite Element Analysis");
        mechFourthYearArray.add("Heating, Ventilation & Air Condition");
        mechFourthYearArray.add("Energy Audit Management");
        mechFourthYearArray.add("Automobile Engineering");
        mechFourthYearArray.add("Operation Research");
        mechFourthYearArray.add("Energy Engineering");
        mechFourthYearArray.add("Mechanical System Design");
        mechFourthYearArray.add("Industrial Engineering");
        mechFourthYearArray.add("Solar & Wind Energy");
        mechFourthYearArray.add("Product Design & Development");
        mechFourthYearArray.add("Advanced Manufacturing Processes");
        mechFourthYearArray.add("Refrigeration & Air Conditioning");
    }

    public void firstYear2015Subjects(){
        firstYear2015Array.clear();
        firstYear2015Array.add("Basic Civil & Environmental Engineering");
        firstYear2015Array.add("Basic Electrical Engineering");
        firstYear2015Array.add("Basic Electronics Engineering");
        firstYear2015Array.add("Basic Mechanical Engineering");
        firstYear2015Array.add("Engineering Mathematics-I");
        firstYear2015Array.add("Engineering Mathematics-II");
        firstYear2015Array.add("Engineering Physics");
        firstYear2015Array.add("Engineering Chemistry");
        firstYear2015Array.add("Engineering Mechanics");
        firstYear2015Array.add("Engineering Graphics");
    }
    public void firstYear2019Subjects(){
        firstYear2019Array.clear();
        firstYear2019Array.add("Engineering Mathematics-I");
        firstYear2019Array.add("Engineering Physics");
        firstYear2019Array.add("Engineering Chemistry");
        firstYear2019Array.add("Systems in Mechanical Engineering");
        firstYear2019Array.add("Basic Electrical Engineering");
        firstYear2019Array.add("Basic Electronics Engineering");
        firstYear2019Array.add("Programming & Problem Solving");
        firstYear2019Array.add("Engineering Mechanics");
        firstYear2019Array.add("Engineering Mathematics-II");
    }
}





