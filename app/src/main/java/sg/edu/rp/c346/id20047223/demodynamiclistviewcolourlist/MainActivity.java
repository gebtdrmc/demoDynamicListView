package sg.edu.rp.c346.id20047223.demodynamiclistviewcolourlist;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    EditText etElement, etIndexElement;
    Button btnAdd, btnDelete, btnUpdate;
    ListView lvColor;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etElement = findViewById(R.id.editTextColor);
        btnAdd = findViewById(R.id.buttonAddItem);
        lvColor = findViewById(R.id.listViewColour);
        etIndexElement = findViewById(R.id.editTextIndex);
        btnDelete = findViewById(R.id.buttonDeleteItem);
        btnUpdate = findViewById(R.id.buttonUpdateItem);

        ArrayList<String> alColours = new ArrayList<>();

        alColours.add("Red");
        alColours.add("Orange");

        ArrayAdapter<String> aaColour = new ArrayAdapter<>(MainActivity.this, android.R.layout.simple_list_item_1, alColours);

        lvColor.setAdapter(aaColour);

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String colour = etElement.getText().toString();
                int pos = Integer.parseInt(etIndexElement.getText().toString());
                alColours.add(pos, colour);
                aaColour.notifyDataSetChanged();
            }
        });

        lvColor.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String colour = alColours.get(position);
                Toast.makeText(MainActivity.this, colour, Toast.LENGTH_SHORT).show();
            }
        });

        btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int pos = Integer.parseInt(etIndexElement.getText().toString());
                alColours.remove(pos);
            }
        });

        btnUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String colour = etElement.getText().toString();
                int pos = Integer.parseInt(etIndexElement.getText().toString());
                alColours.set(pos, colour);
            }
        });


    }
}