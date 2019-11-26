package com.ashish.firapp;

import androidx.appcompat.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;
import android.content.Intent;
import android.os.Bundle;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
public class NewReports extends AppCompatActivity {
    private ListView listView;
    private DatabaseReference databaseReference;
    ArrayList<String> list = new ArrayList<>();
    ArrayAdapter<String> arrayAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_reports);
        listView=findViewById(R.id.myListView);
        arrayAdapter=new ArrayAdapter<String>(this,android.R.layout.simple_dropdown_item_1line,list);
        listView.setAdapter(arrayAdapter);
        databaseReference= FirebaseDatabase.getInstance().getReference().child("Reports Table");


        Query query1=databaseReference.orderByChild("Status").equalTo("");
        query1.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String s) {
                String value=dataSnapshot.getKey();
                list.add(value);
                arrayAdapter.notifyDataSetChanged();

            }

            @Override
            public void onChildChanged(DataSnapshot dataSnapshot, String s) {

            }

            @Override
            public void onChildRemoved(DataSnapshot dataSnapshot) {
                String value=dataSnapshot.getValue(String.class);
                list.remove(value);
                arrayAdapter.notifyDataSetChanged();

            }

            @Override
            public void onChildMoved(DataSnapshot dataSnapshot, String s) {

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                Toast.makeText(getApplicationContext(),databaseError.getMessage(),Toast.LENGTH_LONG).show();

            }
        });

        /*databaseReference.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String s) {

                String value=ds.getKey();
                    list.add(value);
                    arrayAdapter.notifyDataSetChanged();
            }

            @Override
            public void onChildChanged(DataSnapshot dataSnapshot, String s) {

            }

            @Override
            public void onChildRemoved(DataSnapshot dataSnapshot) {
                String value=dataSnapshot.getValue(String.class);
                list.remove(value);
                arrayAdapter.notifyDataSetChanged();

            }

            @Override
            public void onChildMoved(DataSnapshot dataSnapshot, String s) {

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                Toast.makeText(getApplicationContext(),databaseError.getMessage(),Toast.LENGTH_LONG).show();

            }
        });*/
//                Toast.makeText(getApplicationContext(),databaseError.getMessage(),Toast.LENGTH_LONG).show();
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                // Toast.makeText(NewReports.this, "Testing " + list.get(position), Toast.LENGTH_LONG).show();
                Intent intent=new Intent(NewReports.this,ReportsDetailsDialog.class);
                intent.putExtra("Complainant Name",list.get(position));
                startActivity(intent);
            }
        });


    }
}
