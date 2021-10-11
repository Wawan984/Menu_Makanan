package com.example.menumakanan;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toolbar;

public class MainActivity extends AppCompatActivity {

    Toolbar mToolbar;
    ListView mListView;

    String[] foodNames = {"Pecel Lele", "Nasi Goreng Mercon", "Ayam Geprek Keju", "Kari Ayam", "Tahu Bulat", "Salad Buah"};
    String[] foodPrices = {"Harga : Rp 15.000", "Harga : Rp 14.500", "Harga : Rp 20.000", "Harga : Rp 17.500", "Harga : Rp 500", "Harga : Rp 12.000"};
    String[] foodDetails = {"Pecel lele atau pecek lele di Indonesia adalah nama sebuah makanan khas Jawa yang terdiri dari ikan lele dan sambal tomat. Biasanya yang dimaksud adalah ikan lele yang digoreng kering dengan minyak lalu disajikan dengan sambal tomat dan lalapan. Lalapan biasa terdiri dari kemangi, kubis, mentimun, dan kacang panjang.",
            "Nasi Goreng Mercon adalah nasi goreng spesial yang berbeda dengan nasi goreng pada umumnya, karena nasi goreng satu ini ditambahi bumbu-bumbu yang berbeda sehingga membuat rasanya pedas sekali dan meletup-meletup seperti mercon.",
            "Ayam geprek adalah makanan ayam goreng tepung khas Indonesia yang diulek atau dilumatkan bersama sambal bajak dan dilumuri keju tentunya.",
            "Kari ayam adalah hidangan umum di Asia Selatan, Asia Tenggara, serta di Caribbean (di mana makanan tersebut biasa disebut sebagai Ayam Kari).",
            "Tahu bulat adalah sebuah jajanan kaki lima berupa olahan kacang kedelai yang dibuat menjadi sebuah tahu berbentuk bulat dengan isi kopong. Biasanya, tahu bulat dijual di sebuah mobil bak terbuka dan kebanyakan dihargai Rp500 per buah.",
            "Salad buah adalah makanan segar yang terbuat dari berbagai macam buah enak dan segar yang dicampur dengan bahan lain seperti yogurt, mayones, dan keju. Umumnya makanan ini dijadikan sebagai hidangan penutup yang lezat, atau jadi camilan sore."};
    int[] foodImages = {R.drawable.pecel_lele,
            R.drawable.nasi_goreng_mercon,
            R.drawable.ayam_geprek_keju,
            R.drawable.kari_ayam,
            R.drawable.tahu_bulat,
            R.drawable.salad_buah,};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mToolbar = (Toolbar) findViewById(R.id.toolbar);
        mToolbar.setTitle("Menu Makanan Zaman Now");
        mListView = (ListView) findViewById(R.id.listview);
        MyAdapter myAdapter = new MyAdapter(MainActivity.this, foodNames, foodPrices, foodImages, foodDetails);
        mListView.setAdapter(myAdapter);
        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent mIntent = new Intent(MainActivity.this, DetailActivity.class);
                mIntent.putExtra("foodNames", foodNames[i]);
                mIntent.putExtra("foodPrices", foodPrices[i]);
                mIntent.putExtra("foodImages", foodImages[i]);
                mIntent.putExtra("foodDetails", foodDetails[i]);
                startActivity(mIntent);
            }
        });
    }
}