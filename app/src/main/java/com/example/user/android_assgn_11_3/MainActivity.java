package com.example.user.android_assgn_11_3;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.graphics.BitmapFactory;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    //here i have created main class
//public keyword is used in the declaration of a class,method or field;public classes,method and fields can be accessed by the members of any class.
//extends is for extending a class. implements is for implementing an interface
//AppCompatActivity is a class from e v7 appcompat library. This is a compatibility library that back ports some features of recent versions of
// Android to older devices.
    //object of DBhelper class
    private DBhelper DbHelper;
    //create class DBHelper
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        //Variables, methods, and constructors, which are declared protected in a superclass can be accessed only by the subclasses
        // in other package or any class within the package of the protected members class.
        //void is a Java keyword.  Used at method declaration and definition to specify that the method does not return any type,
        // the method returns void.
        //onCreate Called when the activity is first created. This is where you should do all of your normal static set up: create views,
        // bind data to lists, etc. This method also provides you with a Bundle containing the activity's previously frozen state,
        // if there was one.Always followed by onStart().
        //Bundle is most often used for passing data through various Activities.
// This callback is called only when there is a saved instance previously saved using onSaveInstanceState().
// We restore some state in onCreate() while we can optionally restore other state here, possibly usable after onStart() has
// completed.The savedInstanceState Bundle is same as the one used in onCreate().

        super.onCreate(savedInstanceState);
// call the super class onCreate to complete the creation of activity like the view hierarchy
        setContentView(R.layout.activity_main);
        //R means Resource
        //layout means design
        //  main is the xml you have created under res->layout->main.xml
        //  Whenever you want to change your current Look of an Activity or when you move from one Activity to another .
        // The other Activity must have a design to show . So we call this method in onCreate and this is the second statement to set
        // the design
        DbHelper = new DBhelper(this);
        //performing insert operation and closing database
        Employee employee_One = new Employee(BitmapFactory.decodeResource(
                getResources(), R.drawable.photo),"Nagaraju", 23);
        //Creates Bitmap objects from various sources, including files, streams, and byte-arrays.
        //decodeResource:Parameters
        // res	Resources: The resources object containing the image data
        //id	int: The resource id of the image data
        //  Returns
        // Bitmap	The decoded bitmap, or null if the image could not be decoded.
        DbHelper.open();//opens the database
        DbHelper.insertEmpDetails(employee_One);//insert the employee details
        DbHelper.close();//closes the database
        employee_One = null;//opens we close the database we will clear the database and opens the db empty next time
        DbHelper.open();//again opens the db
        employee_One = DbHelper.retriveEmpDetails();//retriving the emp details into object
        DbHelper.close();//closes the db
        //Finding texviews and imageview in java and using set method
        TextView empname = (TextView) findViewById(R.id.name);
        //A user interface element that displays text to the user.
        //findViewById:A user interface element that displays text to the user.
        empname.setText(employee_One.getName());
        //Sets the text to be displayed using a string resource identifier.
        //get the value of emp name from object
        ImageView empphoto = (ImageView) findViewById(R.id.photo);
        //Displays image resources, for example Bitmap or Drawable resources. ImageView is also commonly used to apply tints to an image and handle image scaling.
        //a bitmap is a mapping from some domain to bits. It is also called a bit array or bitmap index
        empphoto.setImageBitmap(employee_One.getBitmap());
        TextView empage = (TextView) findViewById(R.id.age);
        empage.setText("" + employee_One.getAge());//get the age from the object

    }
}