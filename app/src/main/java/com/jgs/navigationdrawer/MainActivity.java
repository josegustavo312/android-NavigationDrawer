package com.jgs.navigationdrawer;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import android.view.View;

import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.google.android.material.navigation.NavigationView;

import androidx.drawerlayout.widget.DrawerLayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.Menu;

public class MainActivity extends AppCompatActivity {

    private AppBarConfiguration mAppBarConfiguration;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        FloatingActionButton fab = findViewById(R.id.fab); // Botão de email
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                enviarEmail();
            }
        });
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.nav_view);
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        mAppBarConfiguration = new AppBarConfiguration.Builder(
                R.id.nav_principal, R.id.nav_servicos, R.id.nav_clientes,
                R.id.nav_contato, R.id.nav_sobre
        )
                .setDrawerLayout(drawer)
                .build();
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        NavigationUI.setupActionBarWithNavController(this, navController, mAppBarConfiguration);
        NavigationUI.setupWithNavController(navigationView, navController);
    }

    public void enviarEmail(){

        // Exemplos de intent
        /*String celular = "tel:81999999999";
        String imagem = "https://s1.static.brasilescola.uol.com.br/be/conteudo/images/-5be0989bbc0c9.jpg";
        String endereco = "https://www.google.com/maps/place/Porto+Digital+-+NGPD+(N%C3%BAcleo+de+Gest%C3%A3o+do+Porto+Digital)/@-8.0631227,-34.8761157,17z/data=!3m1!4b1!4m5!3m4!1s0x7ab18a3179eebef:0x7caecfbcc5347f69!8m2!3d-8.063128!4d-34.873927";
        Intent intent = new Intent(Intent.ACTION_DIAL, Uri.parse(celular));
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(imagem));
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(endereco));*/

        Intent intent = new Intent(Intent.ACTION_SEND);

        intent.putExtra(Intent.EXTRA_EMAIL, new String[]{"jgugu312@gmail.com","jose.gustavo312@yahoo.com.br"});
        intent.putExtra(Intent.EXTRA_SUBJECT, "Contato pelo App");
        intent.putExtra(Intent.EXTRA_TEXT, "Mensagem automática");

        //Exemplos de MIME Types
        //intent.setType("text/plain");
        //intent.setType("image/*");
        //intent.setType("application/pdf");
        intent.setType("message/rfc822");

        startActivity(Intent.createChooser(intent,"Escolha um App de e-mail"));

    }

    @Override
    public boolean onSupportNavigateUp() {
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        return NavigationUI.navigateUp(navController, mAppBarConfiguration)
                || super.onSupportNavigateUp();
    }
}
