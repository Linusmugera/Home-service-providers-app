package com.masterandroid.ehome;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class ServicemenActivity2 extends AppCompatActivity {
    private ListView listView;
    FirebaseDatabase firebaseDatabase;
    DatabaseReference serviceDbRef;
    Regservice regservice;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_servicemen2);

        listView = findViewById(R.id.listView);

        final ArrayList<String> list = new ArrayList<>();
        final ArrayAdapter adapter = new ArrayAdapter<String>(this , R.layout.activity_servicemen2,R.id.txtviewreg ,list);
        listView.setAdapter(adapter);

        DatabaseReference serviceDbRef = FirebaseDatabase.getInstance().getReference().child("ServiceProviders");
        serviceDbRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                list.clear();
                for(DataSnapshot snapshot : dataSnapshot.getChildren()){
                    Regservice info = snapshot.getValue(Regservice.class);
                    String txt = "firstname: " + info.getFirstname() + "; \nlastname: " + info.getLastname() + "; \nemail: " + info.getEmail() + "; \nService Offering: " +
                            info.getServiceoffering() + "; \ncertificant Number: " + info.getCertnumber() + "; \nIdentity No: " + info.getIdentity() +
                            "; \nmobile No: " + info.getMobile() + "; \nlocation: " + info.getLocation();
                    list.add(txt);
                }
                adapter.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }
}