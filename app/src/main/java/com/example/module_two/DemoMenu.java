package com.example.module_two;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;
import android.widget.PopupMenu;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

public class DemoMenu extends AppCompatActivity {
    ImageButton imageButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_demo_menu);
        imageButton = (ImageButton) findViewById(R.id.imageButton);
        imageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showMenu(v);
            }
        });
    }

    //OPTION MENU
    /*
    - Tạo ra một đối tượng truyền "MenuInflater"
    - Truyền file XML của menu
    - Dùng 2 phương thức: phương thức khởi tạo "onCreatOptionMenu" và bắt sự kiện "onOptionsItemSelected"
     */
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.option_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.menu_search:
                Toast.makeText(this, "Search", Toast.LENGTH_LONG).show();
                break;
            case R.id.menu_cut:
                Toast.makeText(this, "Cut", Toast.LENGTH_LONG).show();
                break;
            case R.id.menu_paste:
                Toast.makeText(this, "Paste", Toast.LENGTH_LONG).show();
                break;
            case R.id.menu_contact:
                Toast.makeText(this, "Contact", Toast.LENGTH_LONG).show();
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    //POPUP MENU
    /*
    - Cũng phải tạo popupMenu giống như menu trong optionMenu
    - Tạo đối tượng button - ánh xạ vào Java-main
    - Bắt sự kiện button "setOnClickListener" - sự kiện của view
    - Khởi tạo đối tượng popupMenu và truyền xml-menu qua inflate
    - "setOnMenuItemClickLIstener" để bắt sự kiện của item trong menu
    - show() popupMenu ra bằng popupmenu.show()

     */
    private void showMenu(View view) {
        PopupMenu popupMenu = new PopupMenu(DemoMenu.this, view);
        popupMenu.inflate(R.menu.popup_menu);
        popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.menu_trustingod:
                        Toast.makeText(DemoMenu.this, "Trust In God", Toast.LENGTH_LONG).show();
                        break;
                    case R.id.menu_haleluja:
                        Toast.makeText(DemoMenu.this, "Haleluja", Toast.LENGTH_LONG).show();
                        break;
                }
                return false;
            }
        });
        popupMenu.show();
    }

    ;
}
